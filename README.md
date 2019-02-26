# Scylla RDF

An attempt to build an RDF store using [Eclipse RDF4J](http://rdf4j.org/) on top of [ScyllaDB](http://scylladb.com/).

## Bulk Loading

We use Apache Beam to bulk load RDF data to ScyllaDB. The repository with the pipelines: https://github.com/DataFabricRus/scylla-beam-pipelines.

## Benchmarks

We benchmark new features, the results available in https://github.com/DataFabricRus/scylla-rdf-benchmark.
