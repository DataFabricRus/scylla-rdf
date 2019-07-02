/*******************************************************************************
 * Copyright (c) 2015 Eclipse RDF4J contributors, Aduna, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package cc.datafabric.scyllardf.elasticsearch

import com.google.common.base.Function
import com.google.common.base.Functions
import com.google.common.collect.Iterables
import org.eclipse.rdf4j.model.IRI
import org.eclipse.rdf4j.model.Resource
import org.eclipse.rdf4j.model.vocabulary.GEOF
import org.eclipse.rdf4j.query.MalformedQueryException
import org.eclipse.rdf4j.query.algebra.Var
import org.eclipse.rdf4j.sail.SailException
import org.eclipse.rdf4j.sail.elasticsearch.ElasticsearchIndex
import org.eclipse.rdf4j.sail.elasticsearch.ElasticsearchDocument
import org.eclipse.rdf4j.sail.elasticsearch.ElasticsearchDocumentDistance
import org.eclipse.rdf4j.sail.elasticsearch.ElasticsearchDocumentScore
import org.eclipse.rdf4j.sail.lucene.AbstractSearchIndex
import org.eclipse.rdf4j.sail.lucene.DocumentDistance
import org.eclipse.rdf4j.sail.lucene.DocumentResult
import org.eclipse.rdf4j.sail.lucene.DocumentScore
import org.eclipse.rdf4j.sail.lucene.LuceneSail
import org.eclipse.rdf4j.sail.lucene.SearchDocument
import org.eclipse.rdf4j.sail.lucene.SearchFields
import org.eclipse.rdf4j.sail.lucene.SearchQuery
import org.elasticsearch.action.ActionRequestBuilder
import org.elasticsearch.action.index.IndexResponse
import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.action.support.master.AcknowledgedResponse
import org.elasticsearch.action.update.UpdateResponse
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.Strings
import org.elasticsearch.common.geo.GeoPoint
import org.elasticsearch.common.geo.ShapeRelation
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.TransportAddress
import org.elasticsearch.common.unit.DistanceUnit
import org.elasticsearch.common.xcontent.XContentFactory
import org.elasticsearch.common.xcontent.XContentType
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.index.query.QueryStringQueryBuilder
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders
import org.elasticsearch.index.reindex.DeleteByQueryAction
import org.elasticsearch.rest.RestStatus
import org.elasticsearch.search.SearchHit
import org.elasticsearch.search.SearchHits
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder
import org.elasticsearch.transport.client.PreBuiltTransportClient
import org.locationtech.spatial4j.context.SpatialContext
import org.locationtech.spatial4j.context.SpatialContextFactory
import org.locationtech.spatial4j.distance.DistanceUtils
import org.locationtech.spatial4j.io.GeohashUtils
import org.locationtech.spatial4j.shape.Point
import org.locationtech.spatial4j.shape.Shape
import org.slf4j.LoggerFactory
import java.io.IOException
import java.net.InetAddress
import java.text.ParseException
import java.util.Arrays
import java.util.HashMap
import java.util.HashSet
import java.util.Properties

/**
 * Extends the original [ElasticsearchIndex] with changes in:
 *
 *   * [newBulkUpdate] method
 */
class ModifiedElasticsearchIndex : AbstractSearchIndex() {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val queryAnalyzer = "standard"

    @Volatile
    private var client: TransportClient? = null

    lateinit var clusterName: String
        private set

    lateinit var indexName: String
        private set

    private lateinit var documentType: String

    private lateinit var analyzer: String

    private lateinit var geoContextMapper: Function<in String, out SpatialContext>

    val types: Array<String>
        get() = arrayOf(documentType)

    val mappings: Map<String, Any>
        @Throws(IOException::class)
        get() {
            val indexMappings = client!!.admin()
                    .indices()
                    .prepareGetMappings(indexName)
                    .setTypes(documentType)
                    .execute()
                    .actionGet()
                    .mappings
            val typeMappings = indexMappings.get(indexName)
            val mappings = typeMappings.get(documentType)
            return mappings.sourceAsMap()
        }

    @Throws(Exception::class)
    override fun initialize(parameters: Properties) {
        /**
         * @see https://github.com/elastic/elasticsearch/issues/25741
         */
        System.setProperty("es.set.netty.runtime.available.processors", "false")

        super.initialize(parameters)
        indexName = parameters.getProperty(INDEX_NAME_KEY, DEFAULT_INDEX_NAME)
        documentType = parameters.getProperty(DOCUMENT_TYPE_KEY, DEFAULT_DOCUMENT_TYPE)
        analyzer = parameters.getProperty(LuceneSail.ANALYZER_CLASS_KEY, DEFAULT_ANALYZER)
        // slightly hacky cast to cope with the fact that Properties is
        // Map<Object,Object>
        // even though it is effectively Map<String,String>
        geoContextMapper = createSpatialContextMapper(parameters as Map<String, String>)

        val settingsBuilder = Settings.builder()
        val iter = parameters.propertyNames()
        while (iter.hasMoreElements()) {
            val propName = iter.nextElement() as String
            if (propName.startsWith(ELASTICSEARCH_KEY_PREFIX)) {
                val esName = propName.substring(ELASTICSEARCH_KEY_PREFIX.length)
                settingsBuilder.put(esName, parameters.getProperty(propName))
            }
        }

        client = PreBuiltTransportClient(settingsBuilder.build())
        val transport = parameters.getProperty(TRANSPORT_KEY, DEFAULT_TRANSPORT)
        for (addrStr in transport.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            val addr: TransportAddress
            if (addrStr.startsWith("local[")) {
                val id = addrStr.substring("local[".length, addrStr.length - 1)
                // addr = new LocalTransportAddress(id);
                throw UnsupportedOperationException("Local Transport Address no longer supported")
            } else {
                val host: String
                val port: Int
                val hostPort = addrStr.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                host = hostPort[0]
                if (hostPort.size > 1) {
                    port = Integer.parseInt(hostPort[1])
                } else {
                    port = 9300
                }
                addr = TransportAddress(InetAddress.getByName(host), port)
            }
            client!!.addTransportAddress(addr)
        }
        clusterName = client!!.settings().get("cluster.name")

        val exists = client!!.admin().indices().prepareExists(indexName).execute().actionGet().isExists
        if (!exists) {
            createIndex()
        }

        logger.info("Field mappings:\n{}", mappings)

        val healthReqBuilder = client!!.admin().cluster().prepareHealth(indexName)
        val waitForStatus = parameters.getProperty(WAIT_FOR_STATUS_KEY)
        if ("green" == waitForStatus) {
            healthReqBuilder.setWaitForGreenStatus()
        } else if ("yellow" == waitForStatus) {
            healthReqBuilder.setWaitForYellowStatus()
        }
        val waitForNodes = parameters.getProperty(WAIT_FOR_NODES_KEY)
        if (waitForNodes != null) {
            healthReqBuilder.setWaitForNodes(waitForNodes)
        }
        val waitForActiveShards = parameters.getProperty(WAIT_FOR_ACTIVE_SHARDS_KEY)
        if (waitForActiveShards != null) {
            healthReqBuilder.setWaitForActiveShards(Integer.parseInt(waitForActiveShards))
        }
        val waitForRelocatingShards = parameters.getProperty(WAIT_FOR_RELOCATING_SHARDS_KEY)
        if (waitForRelocatingShards != null) {
            logger.warn("Property " + WAIT_FOR_RELOCATING_SHARDS_KEY + " no longer supported. Use "
                    + WAIT_FOR_NO_RELOCATING_SHARDS_KEY + " instead")
        }
        val waitForNoRelocatingShards = parameters.getProperty(WAIT_FOR_NO_RELOCATING_SHARDS_KEY)
        if (waitForNoRelocatingShards != null) {
            healthReqBuilder.setWaitForNoRelocatingShards(java.lang.Boolean.parseBoolean(waitForNoRelocatingShards))
        }
        val healthResponse = healthReqBuilder.execute().actionGet()
        logger.info("Cluster health: {}", healthResponse.status)
        logger.info("Cluster nodes: {} (data {})", healthResponse.numberOfNodes,
                healthResponse.numberOfDataNodes)
        val indexHealth = healthResponse.indices[indexName]!!
        logger.info("Index health: {}", indexHealth.getStatus())
        logger.info("Index shards: {} (active {} [primary {}], initializing {}, unassigned {}, relocating {})",
                indexHealth.getNumberOfShards(), indexHealth.getActiveShards(), indexHealth.getActivePrimaryShards(),
                indexHealth.getInitializingShards(), indexHealth.getUnassignedShards(),
                indexHealth.getRelocatingShards())
    }

    protected fun createSpatialContextMapper(
            parameters: Map<String, String>): Function<in String, out SpatialContext> {
        // this should really be based on the schema
        val classLoader = Thread.currentThread().contextClassLoader
        val geoContext = SpatialContextFactory.makeSpatialContext(parameters, classLoader)
        return Functions.constant(geoContext)
    }

    @Throws(IOException::class)
    private fun createIndex() {
        XContentFactory.jsonBuilder()
                .startObject()
                .field("index.query.default_field", SearchFields.TEXT_FIELD_NAME)
                .startObject("analysis")
                .startObject("analyzer")
                .startObject("default")
                .field("type", analyzer)
                .endObject()
                .endObject()
                .endObject()
                .endObject().use { xContentBuilder ->

                    doAcknowledgedRequest(client!!.admin()
                            .indices()
                            .prepareCreate(indexName)
                            .setSettings(
                                    Settings.builder().loadFromSource(Strings.toString(xContentBuilder), XContentType.JSON)))
                }

        // use _source instead of explicit stored = true
        val typeMapping = XContentFactory.jsonBuilder()
        typeMapping.startObject().startObject(documentType!!).startObject("properties")
        typeMapping.startObject(SearchFields.CONTEXT_FIELD_NAME)
                .field("type", "keyword")
                .field("index", true)
                .field("copy_to", "_all")
                .endObject()
        typeMapping.startObject(SearchFields.URI_FIELD_NAME)
                .field("type", "keyword")
                .field("index", true)
                .field("copy_to", "_all")
                .endObject()
        typeMapping.startObject(SearchFields.TEXT_FIELD_NAME)
                .field("type", "text")
                .field("index", true)
                .field("copy_to", "_all")
                .endObject()
        for (wktField in wktFields) {
            typeMapping.startObject(toGeoPointFieldName(wktField)).field("type", "geo_point").endObject()
            if (supportsShapes(wktField)) {
                typeMapping.startObject(toGeoShapeFieldName(wktField))
                        .field("type", "geo_shape")
                        .field("copy_to", "_all")
                        .endObject()
            }
        }
        typeMapping.endObject().endObject().endObject()

        doAcknowledgedRequest(
                client!!.admin().indices().preparePutMapping(indexName).setType(documentType).setSource(typeMapping))
    }

    private fun supportsShapes(field: String): Boolean {
        val geoContext = geoContextMapper!!.apply(field)
        try {
            geoContext!!.readShapeFromWkt("POLYGON ((0 0, 1 0, 1 1, 0 1, 0 0))")
            return true
        } catch (e: ParseException) {
            return false
        }

    }

    override fun getSpatialContext(property: String): SpatialContext? {
        return geoContextMapper!!.apply(property)
    }

    @Throws(IOException::class)
    override fun shutDown() {
        val toCloseClient = client
        client = null
        toCloseClient?.close()
    }

    // //////////////////////////////// Methods for updating the index

    /**
     * Returns a Document representing the specified document ID (combination of resource and context), or null when no
     * such Document exists yet.
     */
    @Throws(IOException::class)
    override fun getDocument(id: String): SearchDocument? {
        val response = client!!.prepareGet(indexName, documentType, id).execute().actionGet()
        return if (response.isExists) {
            ElasticsearchDocument(response.id, response.type, response.index,
                    response.version, response.source, geoContextMapper)
        } else null
        // no such Document
    }

    @Throws(IOException::class)
    override fun getDocuments(resourceId: String): Iterable<SearchDocument> {
        val hits = getDocuments(QueryBuilders.termQuery(SearchFields.URI_FIELD_NAME, resourceId))
        return Iterables.transform(hits) { hit -> ElasticsearchDocument(hit!!, geoContextMapper) }
    }

    override fun newDocument(id: String, resourceId: String, context: String): SearchDocument {
        return ElasticsearchDocument(id, documentType, indexName, resourceId, context, geoContextMapper)
    }

    override fun copyDocument(doc: SearchDocument): SearchDocument {
        val esDoc = doc as ElasticsearchDocument
        val source = esDoc.source
        val newDocument = HashMap(source)
        return ElasticsearchDocument(esDoc.id, esDoc.type, esDoc.index, esDoc.version,
                newDocument, geoContextMapper)
    }

    @Throws(IOException::class)
    override fun addDocument(doc: SearchDocument) {
        val esDoc = doc as ElasticsearchDocument
        doIndexRequest(
                client!!.prepareIndex(esDoc.index, esDoc.type, esDoc.id).setSource(esDoc.source))
    }

    @Throws(IOException::class)
    override fun updateDocument(doc: SearchDocument) {
        val esDoc = doc as ElasticsearchDocument
        doUpdateRequest(client!!.prepareUpdate(esDoc.index, esDoc.type, esDoc.id)
                .setVersion(esDoc.version)
                .setDoc(esDoc.source))
    }

    @Throws(IOException::class)
    override fun deleteDocument(doc: SearchDocument) {
        val esDoc = doc as ElasticsearchDocument
        client!!.prepareDelete(esDoc.index, esDoc.type, esDoc.id)
                .setVersion(esDoc.version)
                .execute()
                .actionGet()
    }

    public override fun newBulkUpdate(): ModifiedElasticsearchBulkUpdater {
        return ModifiedElasticsearchBulkUpdater(client!!)
    }

    /**
     * Returns a list of Documents representing the specified Resource (empty when no such Document exists yet). Each
     * document represent a set of statements with the specified Resource as a subject, which are stored in a specific
     * context
     */
    @Throws(IOException::class)
    private fun getDocuments(query: QueryBuilder): SearchHits {
        return search(client!!.prepareSearch(), query)
    }

    /**
     * Returns a Document representing the specified Resource & Context combination, or null when no such Document
     * exists yet.
     */
    @Throws(IOException::class)
    fun getDocument(subject: Resource, context: Resource): SearchDocument? {
        // fetch the Document representing this Resource
        val resourceId = SearchFields.getResourceID(subject)
        val contextId = SearchFields.getContextID(context)
        return getDocument(SearchFields.formIdString(resourceId, contextId))
    }

    /**
     * Returns a list of Documents representing the specified Resource (empty when no such Document exists yet). Each
     * document represent a set of statements with the specified Resource as a subject, which are stored in a specific
     * context
     */
    @Throws(IOException::class)
    fun getDocuments(subject: Resource): Iterable<SearchDocument> {
        val resourceId = SearchFields.getResourceID(subject)
        return getDocuments(resourceId)
    }

    @Throws(IOException::class)
    override fun begin() {
    }

    @Throws(IOException::class)
    override fun commit() {
        client!!.admin().indices().prepareRefresh(indexName).execute().actionGet()
    }

    @Throws(IOException::class)
    override fun rollback() {
    }

    @Throws(IOException::class)
    override fun beginReading() {
    }

    @Throws(IOException::class)
    override fun endReading() {
    }

    // //////////////////////////////// Methods for querying the index

    /**
     * Parse the passed query. To be removed, no longer used.
     *
     * @param query string
     * @return the parsed query
     * @throws ParseException when the parsing brakes
     */
    @Deprecated("")
    @Throws(MalformedQueryException::class)
    override fun parseQuery(query: String, propertyURI: IRI): SearchQuery? {
        //		QueryBuilder qb = prepareQuery(propertyURI, QueryBuilders.queryStringQuery(query));
        //		return new ElasticsearchQuery(client.prepareSearch(), qb, this);
        return null
    }

    /**
     * Parse the passed query.
     *
     * @param query string
     * @return the parsed query
     * @throws ParseException when the parsing brakes
     */
    @Throws(MalformedQueryException::class, IOException::class)
    override fun query(subject: Resource?, query: String, propertyURI: IRI?,
                       highlight: Boolean): Iterable<DocumentScore> {
        val qb = prepareQuery(propertyURI, QueryBuilders.queryStringQuery(query))
        val request = client!!.prepareSearch()
        if (highlight) {
            val hb = HighlightBuilder()
            val field: String
            if (propertyURI != null) {
                field = toPropertyFieldName(SearchFields.getPropertyField(propertyURI))
            } else {
                field = ALL_PROPERTY_FIELDS
                hb.requireFieldMatch(false)
            }
            hb.field(field)
            hb.preTags(SearchFields.HIGHLIGHTER_PRE_TAG)
            hb.postTags(SearchFields.HIGHLIGHTER_POST_TAG)
            // Elastic Search doesn't really have the same support for fragments as
            // Lucene.
            // So, we have to get back the whole highlighted value (comma-separated
            // if it is a list)
            // and then post-process it into fragments ourselves.
            hb.numOfFragments(0)
            request.highlighter(hb)
        }

        val hits: SearchHits
        if (subject != null) {
            hits = search(subject, request, qb)
        } else {
            hits = search(request, qb)
        }
        return Iterables.transform(hits) { hit -> ElasticsearchDocumentScore(hit, geoContextMapper) }!!
    }

    // /**
    // * Parses an id-string used for a context filed (a serialized resource)
    // back to a resource.
    // * <b>CAN RETURN NULL</b>
    // * Inverse method of {@link #getResourceID(Resource)}
    // * @param idString
    // * @return null if the passed idString was the {@link #CONTEXT_NULL}
    // constant
    // */
    // private Resource getContextResource(String idString) {
    // if (CONTEXT_NULL.equals(idString))
    // return null;
    // else
    // return getResource(idString);
    // }

    /**
     * Evaluates the given query only for the given resource.
     */
    fun search(resource: Resource, request: SearchRequestBuilder, query: QueryBuilder): SearchHits {
        // rewrite the query
        val idQuery = QueryBuilders.termQuery(SearchFields.URI_FIELD_NAME,
                SearchFields.getResourceID(resource))
        val combinedQuery = QueryBuilders.boolQuery().must(idQuery).must(query)
        return search(request, combinedQuery)
    }

    @Throws(MalformedQueryException::class, IOException::class)
    override fun geoQuery(geoProperty: IRI, p: Point, units: IRI,
                          distance: Double, distanceVar: String, contextVar: Var?): Iterable<DocumentDistance> {
        val unitDist: Double
        val unit: DistanceUnit
        if (GEOF.UOM_METRE == units) {
            unit = DistanceUnit.METERS
            unitDist = distance
        } else if (GEOF.UOM_DEGREE == units) {
            unit = DistanceUnit.KILOMETERS
            unitDist = unit.distancePerDegree * distance
        } else if (GEOF.UOM_RADIAN == units) {
            unit = DistanceUnit.KILOMETERS
            unitDist = DistanceUtils.radians2Dist(distance, DistanceUtils.EARTH_MEAN_RADIUS_KM)
        } else if (GEOF.UOM_UNITY == units) {
            unit = DistanceUnit.KILOMETERS
            unitDist = distance * Math.PI * DistanceUtils.EARTH_MEAN_RADIUS_KM
        } else {
            throw MalformedQueryException("Unsupported units: $units")
        }

        val lat = p.y
        val lon = p.x
        val fieldName = toGeoPointFieldName(SearchFields.getPropertyField(geoProperty))
        var qb: QueryBuilder = QueryBuilders.functionScoreQuery(
                QueryBuilders.geoDistanceQuery(fieldName).point(lat, lon).distance(unitDist, unit),
                ScoreFunctionBuilders.linearDecayFunction(fieldName, GeohashUtils.encodeLatLon(lat, lon),
                        DistanceUnit.Distance(unitDist, unit).toString()))
        if (contextVar != null) {
            qb = addContextTerm(qb, contextVar.value as Resource)
        }

        val request = client!!.prepareSearch()
        val hits = search(request, qb)
        val srcPoint = GeoPoint(lat, lon)

        return Iterables.transform<SearchHit, DocumentDistance>(hits) { hit ->
            ElasticsearchDocumentDistance(hit, geoContextMapper, fieldName, units, srcPoint, unit)
        }
    }

    private fun addContextTerm(qb: QueryBuilder, ctx: Resource?): QueryBuilder {
        val combinedQuery = QueryBuilders.boolQuery()
        val idQuery = QueryBuilders.termQuery(SearchFields.CONTEXT_FIELD_NAME, SearchFields.getContextID(ctx))
        if (ctx != null) {
            // the specified named graph
            combinedQuery.must(idQuery)
        } else {
            // not the unnamed graph
            combinedQuery.mustNot(idQuery)
        }
        combinedQuery.must(qb)
        return combinedQuery
    }

    @Throws(MalformedQueryException::class, IOException::class)
    override fun geoRelationQuery(relation: String, geoProperty: IRI, shape: Shape,
                                  contextVar: Var): Iterable<DocumentResult>? {
        //		ShapeRelation spatialOp = toSpatialOp(relation);
        //		if (spatialOp == null) {
        //			return null;
        //		}
        //		final String fieldName = toGeoShapeFieldName(SearchFields.getPropertyField(geoProperty));
        //		GeoShapeQueryBuilder fb = QueryBuilders.geoShapeQuery(fieldName,
        //				ElasticsearchSpatialSupport.getSpatialSupport().toShapeBuilder(shape));
        //		fb.relation(spatialOp);
        //		QueryBuilder qb = QueryBuilders.matchAllQuery();
        //		if (contextVar != null) {
        //			qb = addContextTerm(qb, (Resource) contextVar.getValue());
        //		}
        //
        //		SearchRequestBuilder request = client.prepareSearch();
        //		SearchHits hits = search(request, QueryBuilders.boolQuery().must(qb).filter(fb));
        //		return Iterables.transform(hits, new Function<SearchHit, DocumentResult>() {
        //
        //			@Override
        //			public DocumentResult apply(SearchHit hit) {
        //				return new ElasticsearchDocumentResult(hit, geoContextMapper);
        //			}
        //		});

        return null
    }

    private fun toSpatialOp(relation: String): ShapeRelation? {
        if (GEOF.SF_INTERSECTS.stringValue() == relation) {
            return ShapeRelation.INTERSECTS
        }
        if (GEOF.SF_DISJOINT.stringValue() == relation) {
            return ShapeRelation.DISJOINT
        }
        return if (GEOF.EH_COVERED_BY.stringValue() == relation) {
            ShapeRelation.WITHIN
        } else null
    }

    /**
     * Evaluates the given query and returns the results as a TopDocs instance.
     */
    fun search(request: SearchRequestBuilder, query: QueryBuilder): SearchHits {
        val types = types
        val nDocs: Int
        if (maxDocs > 0) {
            nDocs = maxDocs
        } else {
            val docCount = client!!.prepareSearch(indexName)
                    .setTypes(*types)
                    .setSource(SearchSourceBuilder().size(0).query(query))
                    .get()
                    .hits
                    .getTotalHits()
            nDocs = Math.max(Math.min(docCount, Integer.MAX_VALUE.toLong()).toInt(), 1)
        }
        val response = request.setIndices(indexName!!)
                .setTypes(*types)
                .setVersion(true)
                .setQuery(query)
                .setSize(nDocs)
                .execute()
                .actionGet()
        return response.hits
    }

    private fun prepareQuery(propertyURI: IRI?, query: QueryStringQueryBuilder): QueryStringQueryBuilder {
        // check out which query parser to use, based on the given property URI
        if (propertyURI == null)
        // if we have no property given, we create a default query parser which
        // has the TEXT_FIELD_NAME as the default field
            query.defaultField(SearchFields.TEXT_FIELD_NAME).analyzer(queryAnalyzer)
        else
        // otherwise we create a query parser that has the given property as
        // the default field
            query.defaultField(toPropertyFieldName(SearchFields.getPropertyField(propertyURI))).analyzer(queryAnalyzer)
        return query
    }

    /**
     * @param contexts
     * @throws SailException
     */
    @Synchronized
    @Throws(IOException::class)
    override fun clearContexts(vararg contexts: Resource) {

        // logger.warn("Clearing contexts operation did not change the index: contexts are not indexed at the moment");

        logger.debug("deleting contexts: {}", Arrays.toString(contexts))
        // these resources have to be read from the underlying rdf store
        // and their triples have to be added to the luceneindex after deletion of
        // documents
        // HashSet<Resource> resourcesToUpdate = new HashSet<Resource>();

        // remove all contexts passed
        for (context in contexts) {
            // attention: context can be NULL!
            val contextString = SearchFields.getContextID(context)
            // IndexReader reader = getIndexReader();

            // now check all documents, and remember the URI of the resources
            // that were in multiple contexts
            // TermDocs termDocs = reader.termDocs(contextTerm);
            // try {
            // while (termDocs.next()) {
            // Document document = readDocument(reader, termDocs.doc());
            // // does this document have any other contexts?
            // Field[] fields = document.getFields(CONTEXT_FIELD_NAME);
            // for (Field f : fields)
            // {
            // if
            // (!contextString.equals(f.stringValue())&&!f.stringValue().equals("null"))
            // // there is another context
            // {
            // logger.debug("test new contexts: {}", f.stringValue());
            // // is it in the also contexts (lucky us if it is)
            // Resource otherContextOfDocument =
            // getContextResource(f.stringValue()); // can return null
            // boolean isAlsoDeleted = false;
            // for (Resource c: contexts){
            // if (c==null) {
            // if (otherContextOfDocument == null)
            // isAlsoDeleted = true;
            // } else
            // if (c.equals(otherContextOfDocument))
            // isAlsoDeleted = true;
            // }
            // // the otherContextOfDocument is now eihter marked for deletion or
            // not
            // if (!isAlsoDeleted) {
            // // get ID of document
            // Resource r = getResource(document);
            // resourcesToUpdate.add(r);
            // }
            // }
            // }
            // }
            // } finally {
            // termDocs.close();
            // }

            // now delete all documents from the deleted context
            DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
                    .source(indexName)
                    .filter(QueryBuilders.termQuery(SearchFields.CONTEXT_FIELD_NAME, contextString))
                    .get()
        }

        // now add those again, that had other contexts also.
        // SailConnection con = sail.getConnection();
        // try {
        // // for each resource, add all
        // for (Resource resource : resourcesToUpdate) {
        // logger.debug("re-adding resource {}", resource);
        // ArrayList<Statement> toAdd = new ArrayList<Statement>();
        // CloseableIteration<? extends Statement, SailException> it =
        // con.getStatements(resource, null, null, false);
        // while (it.hasNext()) {
        // Statement s = it.next();
        // toAdd.add(s);
        // }
        // addDocument(resource, toAdd);
        // }
        // } finally {
        // con.close();
        // }

    }

    /**
     *
     */
    @Synchronized
    @Throws(IOException::class)
    override fun clear() {
        doAcknowledgedRequest(client!!.admin().indices().prepareDelete(indexName))
        createIndex()
    }

    companion object {

        /**
         * Set the parameter "indexName=" to specify the index to use.
         */
        val INDEX_NAME_KEY = "indexName"

        /**
         * Set the parameter "documentType=" to specify the document type to use. By default, the document type is
         * "resource".
         */
        val DOCUMENT_TYPE_KEY = "documentType"

        /**
         * Set the parameter "transport=" to specify the address of the cluster to use (e.g. localhost:9300).
         */
        val TRANSPORT_KEY = "transport"

        /**
         * Set the parameter "waitForStatus=" to configure if [initialization][.initialize]
         * should wait for a particular health status. The value can be one of "green" or "yellow". Does not wait by
         * default.
         */
        val WAIT_FOR_STATUS_KEY = "waitForStatus"

        /**
         * Set the parameter "waitForNodes=" to configure if [initialization][.initialize] should
         * wait until the specified number of nodes are available. Does not wait by default.
         */
        val WAIT_FOR_NODES_KEY = "waitForNodes"

        /**
         * Set the parameter "waitForActiveShards=" to configure if [initialization][.initialize]
         * should wait until the specified number of shards to be active. Does not wait by default.
         */
        val WAIT_FOR_ACTIVE_SHARDS_KEY = "waitForActiveShards"

        /**
         * Set the parameter "waitForRelocatingShards=" to configure if [ initialization][.initialize] should wait until the specified number of nodes are relocating. Does not wait by default.
         *
         */
        @Deprecated("use {@link #WAIT_FOR_NO_RELOCATING_SHARDS_KEY} in elastic search >= 5.x")
        val WAIT_FOR_RELOCATING_SHARDS_KEY = "waitForRelocatingShards"

        /**
         * Set the parameter "waitForNoRelocatingShards=true|false" to configure if [ initialization][.initialize] should wait until the are no relocating shards. Defaults to false, meaning the operation does not
         * wait on there being no more relocating shards. Set to true to wait until the number of relocating shards in the
         * cluster is 0.
         */
        val WAIT_FOR_NO_RELOCATING_SHARDS_KEY = "waitForNoRelocatingShards"

        val DEFAULT_INDEX_NAME = "elastic-search-sail"

        val DEFAULT_DOCUMENT_TYPE = "resource"

        val DEFAULT_TRANSPORT = "localhost"

        val DEFAULT_ANALYZER = "standard"

        val ELASTICSEARCH_KEY_PREFIX = "elasticsearch."

        val PROPERTY_FIELD_PREFIX = "p_"

        val ALL_PROPERTY_FIELDS = "p_*"

        val GEOPOINT_FIELD_PREFIX = "_geopoint_"

        val GEOSHAPE_FIELD_PREFIX = "_geoshape_"

        /**
         * Filters the given list of fields, retaining all property fields.
         */
        fun getPropertyFields(fields: Set<String>): Set<String> {
            val result = HashSet<String>(fields.size)
            for (field in fields) {
                if (SearchFields.isPropertyField(field))
                    result.add(field)
            }
            return result
        }

        internal fun toPropertyFieldName(prop: String): String {
            return PROPERTY_FIELD_PREFIX + encodeFieldName(prop)
        }

        internal fun toPropertyName(field: String): String {
            return decodeFieldName(field.substring(PROPERTY_FIELD_PREFIX.length))
        }

        internal fun toGeoPointFieldName(prop: String): String {
            return GEOPOINT_FIELD_PREFIX + encodeFieldName(prop)
        }

        internal fun toGeoShapeFieldName(prop: String): String {
            return GEOSHAPE_FIELD_PREFIX + encodeFieldName(prop)
        }

        internal fun encodeFieldName(s: String): String {
            return s.replace('.', '^')
        }

        internal fun decodeFieldName(s: String): String {
            return s.replace('^', '.')
        }

        @Throws(IOException::class)
        private fun doAcknowledgedRequest(request: ActionRequestBuilder<*, out AcknowledgedResponse, *>) {
            val ok = request.execute().actionGet().isAcknowledged
            if (!ok) {
                throw IOException("Request not acknowledged: " + request.get().javaClass.name)
            }
        }

        @Throws(IOException::class)
        private fun doIndexRequest(request: ActionRequestBuilder<*, out IndexResponse, *>): Long {
            val response = request.execute().actionGet()
            val ok = response.status() == RestStatus.CREATED
            if (!ok) {
                throw IOException("Document not created: " + request.get().javaClass.name)
            }
            return response.version
        }

        @Throws(IOException::class)
        private fun doUpdateRequest(request: ActionRequestBuilder<*, out UpdateResponse, *>): Long {
            val response = request.execute().actionGet()
            val isUpsert = response.status() == RestStatus.CREATED
            if (isUpsert) {
                throw IOException("Unexpected upsert: " + request.get().javaClass.name)
            }
            return response.version
        }
    }
}
