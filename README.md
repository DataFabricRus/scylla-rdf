# Scylla RDF

An attempt to build an RDF store using [Eclipse RDF4J](http://rdf4j.org/) on top of [ScyllaDB](http://scylladb.com/).

## Deployment

For testing purposes deploy ScyllaDB, Elasticsearch and Scylla-RDF using [docker-compose-dev.yml](https://github.com/DataFabricRus/scylla-rdf/blob/master/docker/docker-compose-dev.yml).

For production, you have to deploy ScyllaDB and Elasticsearch separately. And use [docker-compose-prod.yml](https://github.com/DataFabricRus/scylla-rdf/blob/master/docker/docker-compose-prod.yml) to deploy Scylla-RDF.

## Bulk Loading

We use Apache Beam to bulk load RDF data to ScyllaDB. The repository with the pipelines: https://github.com/DataFabricRus/scylla-beam-pipelines.

## Benchmarks

We benchmark new features, the results available in https://github.com/DataFabricRus/scylla-rdf-benchmark.
