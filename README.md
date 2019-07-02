# Scylla RDF

An RDF store (aka [Triplestore](https://en.wikipedia.org/wiki/Triplestore)) built using [Eclipse RDF4J](http://rdf4j.org/) and [ScyllaDB](http://scylladb.com/). Full-text search is supported with Elasticsearch.

> Warning: It's still in an early stage of development, so if you have any trouble or question, please, create an issue.


Docker Image: [![](https://images.microbadger.com/badges/image/datafabricrus/scylla-rdf:0.0.1.svg)](https://hub.docker.com/r/datafabricrus/scylla-rdf "Get your own image badge on microbadger.com") [![](https://images.microbadger.com/badges/version/datafabricrus/scylla-rdf:0.0.1.svg)](https://hub.docker.com/r/datafabricrus/scylla-rdf "Get your own version badge on microbadger.com")


## Deployment

For testing purposes deploy ScyllaDB, Elasticsearch and Scylla-RDF using [docker-compose-dev.yml](https://github.com/DataFabricRus/scylla-rdf/blob/master/docker/docker-compose-dev.yml).

For production, you have to deploy ScyllaDB and Elasticsearch separately. And use [docker-compose-prod.yml](https://github.com/DataFabricRus/scylla-rdf/blob/master/docker/docker-compose-prod.yml) to deploy Scylla-RDF.

## Bulk Loading

We use Apache Beam to bulk load RDF data to ScyllaDB. The repository with the pipelines: https://github.com/DataFabricRus/scylla-beam-pipelines.

## Benchmarks

We benchmark new features, the results available in https://github.com/DataFabricRus/scylla-rdf-benchmark.

## Build from sources

The code depends on the SNAPSHOT versions of some libraries, so you need to build them locally and make sure their 
artifacts end up into the local Maven repository. The libraries:

  * ScyllaDB Java Driver (the fork of Cassandra Java Driver). Use the [3.7.1-scylla](https://github.com/scylladb/java-driver/tree/3.7.1-scylla) branch.
  * Eclipse RDF4J (i.e. [rdf4j](https://github.com/eclipse/rdf4j), [rdf4j-storage](https://github.com/eclipse/rdf4j-storage) and [rdf4j-tools](https://github.com/eclipse/rdf4j-tools)). Use the `develop` branch.

After that you need to build Scylla-RDF with:

```bash
$ mvn clean install
$ docker-compose -f docker-compose-dev.yml build
```

## License

MIT License
