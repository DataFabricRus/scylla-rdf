/*******************************************************************************
 * Copyright (c) 2015 Eclipse RDF4J contributors, Aduna, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package cc.datafabric.scyllardf.elasticsearch

import org.eclipse.rdf4j.sail.elasticsearch.ElasticsearchDocument
import org.eclipse.rdf4j.sail.lucene.BulkUpdater
import org.eclipse.rdf4j.sail.lucene.SearchDocument
import org.elasticsearch.action.bulk.BulkRequestBuilder
import org.elasticsearch.client.Client
import org.elasticsearch.script.Script
import org.elasticsearch.script.ScriptType
import java.io.IOException

/**
 * Extends the original [BulkUpdater] with the following methods:
 *
 *   * [scriptedPartialUpdateInsert]
 *   * [scriptedPartialUpdateDelete]
 */
class ModifiedElasticsearchBulkUpdater(private val client: Client) : BulkUpdater {

    companion object {
        /*
            http://pek-soi2.sigma-it.local:9200/elastic-search-sail/resource/http%3A%2F%2Ftrinidata.ru%2Fsigma%2F%D0%95%D0%91_%D0%A2%D0%9F%D0%9E_99960277%7Chttp%3A%2F%2Ftrinidata.ru%2Fsigma%2F%D0%95%D0%91_%D0%AD%D0%9E_2492762815
            {
                "_index": "elastic-search-sail",
                "_type": "resource",
                "_id": "http://trinidata.ru/sigma/ЕБ_ТПО_99960277|http://trinidata.ru/sigma/ЕБ_ЭО_2492762815",
                "_score": 1,
                "_source": {
                    "p_http://trinidata^ru/sigma/ИдентификаторОбъектаВСистемеИсточникеПСК": "99960277",
                    "context": "http://trinidata.ru/sigma/ЕБ_ЭО_2492762815",
                    "text": [
                        "99960277",
                        "19.79",
                        "",
                        "1"
                    ],
                    "uri": "http://trinidata.ru/sigma/ЕБ_ТПО_99960277",
                    "p_http://trinidata^ru/sigma/МаксимальнаяМощность": "19.79",
                    "p_http://trinidata^ru/sigma/ОписаниеКонтактногоСоединения": "",
                    "p_http://trinidata^ru/sigma/НомерТочкиПоставки": "1"
                }
            }
         */
        private const val PARTIAL_UPDATE_INSERT_SCRIPT = """
            if(ctx._source.text instanceof List) {
                if(!ctx._source.text.contains(params.text)) {
                    ctx._source.text.add(params.text)
                }
            } else if(ctx._source.text != params.text) {
                ctx._source.text = [ctx._source.text, params.text]
            }
            if(ctx._source.containsKey(params.property)) {
                if(ctx._source[params.property] instanceof List) {
                    if(!ctx._source[params.property].contains(params.text)) {
                        ctx._source[params.property].add(params.text)
                    }
                } else if(ctx._source[params.property] != params.text) {
                    ctx._source[params.property] = [ctx._source[params.property], params.text]
                }
            } else {
                ctx._source[params.property] = params.text
            }
        """
        private const val PARTIAL_UPDATE_DELETE_SCRIPT = """
            if(ctx._source.text instanceof List) {
                int idx = ctx._source.text.indexOf(params.text);
                if(idx >= 0) {
                    ctx._source.text.remove(idx)
                }
            } else if(ctx._source.text == params.text) {
                ctx._source.text = []
            }
            if(ctx._source.containsKey(params.property)) {
                if(ctx._source[params.property] instanceof List) {
                    int idx = ctx._source[params.property].indexOf(params.text);
                    if(idx >= 0) {
                        ctx._source[params.property].remove(idx)
                    }
                } else if(ctx._source[params.property] == params.text) {
                    ctx._source.remove(params.property)
                }
            }
        """
    }

    private val bulkRequest: BulkRequestBuilder = client.prepareBulk()

    @Throws(IOException::class)
    override fun add(doc: SearchDocument) {
        val esDoc = doc as ElasticsearchDocument
        bulkRequest.add(
                client.prepareIndex(esDoc.index, esDoc.type, esDoc.id).setSource(esDoc.source))
    }

    @Throws(IOException::class)
    override fun update(doc: SearchDocument) {
        val esDoc = doc as ElasticsearchDocument
        bulkRequest.add(client.prepareUpdate(esDoc.index, esDoc.type, esDoc.id)
                .setVersion(esDoc.version)
                .setDoc(esDoc.source))
    }

    /**
     * Performs a [scripted update](https://www.elastic.co/guide/en/elasticsearch/reference/6.5/docs-update.html#_scripted_updates)
     * to insert a new value to the index.
     *
     * @param doc
     * @param propertyName
     */
    fun scriptedPartialUpdateInsert(doc: SearchDocument, propertyName: String) {
        val esDoc = doc as ElasticsearchDocument
        val fieldName = ModifiedElasticsearchIndex.toPropertyFieldName(propertyName)

        val fieldValue = esDoc.source[fieldName]
        if (fieldValue != null) {
            val update = client.prepareUpdate(esDoc.index, esDoc.type, esDoc.id)
                    .setVersion(esDoc.version)
                    .setScript(
                            Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, PARTIAL_UPDATE_INSERT_SCRIPT,
                                    mapOf(
                                            Pair("text", fieldValue),
                                            Pair("property", fieldName)
                                    )
                            ))
                    .setScriptedUpsert(false)
                    .setUpsert(esDoc.source)
                    .setDetectNoop(false)

            bulkRequest.add(update)
        }
    }

    /**
     * Performs a [scripted update](https://www.elastic.co/guide/en/elasticsearch/reference/6.5/docs-update.html#_scripted_updates)
     * to delete a value from the index.
     *
     * @param doc
     * @param propertyName
     */
    fun scriptedPartialUpdateDelete(doc: SearchDocument, propertyName: String) {
        val esDoc = doc as ElasticsearchDocument
        val fieldName = ModifiedElasticsearchIndex.toPropertyFieldName(propertyName)

        val fieldValue = esDoc.source[fieldName]
        if (fieldValue != null) {
            val update = client.prepareUpdate(esDoc.index, esDoc.type, esDoc.id)
                    .setVersion(esDoc.version)
                    .setScript(
                            Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, PARTIAL_UPDATE_DELETE_SCRIPT,
                                    mapOf(
                                            Pair("text", fieldValue),
                                            Pair("property", fieldName)
                                    )
                            ))
                    .setScriptedUpsert(false)
                    .setDetectNoop(false)

            bulkRequest.add(update)
        }
    }

    @Throws(IOException::class)
    override fun delete(doc: SearchDocument) {
        val esDoc = doc as ElasticsearchDocument
        bulkRequest.add(client.prepareDelete(esDoc.index, esDoc.type, esDoc.id).setVersion(esDoc.version))
    }

    @Throws(IOException::class)
    override fun end() {
        if (bulkRequest.numberOfActions() > 0) {
            val response = bulkRequest.execute().actionGet()
            if (response.hasFailures()) {
                throw IOException(response.buildFailureMessage())
            }
        }
    }
}
