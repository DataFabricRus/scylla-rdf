# Scylla RDF

An RDF store (aka [Triplestore](https://en.wikipedia.org/wiki/Triplestore)) built using [Eclipse RDF4J](http://rdf4j.org/) and [ScyllaDB](http://scylladb.com/). Full-text search is supported with Elasticsearch.

> Warning: It's still in an early stage of development, so if you have any trouble or question, please, create an issue.


[![](https://images.microbadger.com/badges/version/datafabricrus/scylla-rdf:0.0.1.svg)](https://hub.docker.com/r/datafabricrus/scylla-rdf "Get your own version badge on microbadger.com")
[![Build Status](https://travis-ci.org/DataFabricRus/scylla-rdf.svg?branch=master)](https://travis-ci.org/DataFabricRus/scylla-rdf)


## Deployment

For testing purposes deploy ScyllaDB, Elasticsearch and Scylla-RDF locally using [docker-compose-dev.yml](./docker-compose-dev.yml):

```bash
$ docker-compose -f docker-compose-dev.yml up -d
```

For production, you need to deploy ScyllaDB and Elasticsearch separately. And use 
[docker-compose-prod.yml](./docker-compose-prod.yml) to deploy Scylla-RDF. Scylla-RDF were tested with:

  * ScyllaDB 3.0.8
  * Elasticsearch 6.5.4
  
In both cases, after the deployment, you need to create a repository via the RDF4J Workbench Console which'll be available 
on 80th port of the machine where Scylla-RDF was deployed, e.g. `http://localhost`. The default login/password: `admin`/`scylla-rdf`.

## Bulk Loading

We use [Apache Beam](http://beam.apache.org/) to bulk load RDF data to ScyllaDB. The repository with the source code and instructions: 
https://github.com/DataFabricRus/scylla-beam-pipelines.

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
