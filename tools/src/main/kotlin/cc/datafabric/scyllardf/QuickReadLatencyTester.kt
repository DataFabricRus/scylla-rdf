package cc.datafabric.scyllardf

import com.datastax.driver.core.Cluster
import com.datastax.driver.core.ResultSetFuture
import com.google.common.util.concurrent.Futures
import java.util.stream.Collectors

object QuickReadLatencyTester {

    private val SUBJECTS = arrayListOf<String>(
        "http://example.com/legalentity/001a1d86-278b-523b-b3b0-fcfb7518dc60",
        "http://example.com/legalentity/001def1b-0920-5937-bdd2-7b9b72b0d858",
        "http://example.com/legalentity/00399240-787e-5d22-a091-e3f13bd08363",
        "http://example.com/legalentity/00399af6-7ddf-5260-a8a1-48948d10e016",
        "http://example.com/legalentity/003b93fc-100b-5e0d-95fa-4ffd74193702",
        "http://example.com/legalentity/00629632-0e62-5373-bef9-832d6773bb7c",
        "http://example.com/legalentity/00791729-66c0-58ac-b32a-ff3666345eff",
        "http://example.com/legalentity/0079e39d-f7d3-53d0-95b5-a0d5dc6df05b",
        "http://example.com/legalentity/00c0868b-0e7a-5913-9726-25ed2e5bcd02",
        "http://example.com/legalentity/00cfed45-aa18-5e47-bb3b-bd757a908a6d"
    )
    private val PREDICATES = arrayListOf(
        "https://spec.edmcouncil.org/fibo/ontology/FND/Relations/Relations/hasLegalName",
        "https://spec.edmcouncil.org/fibo/ontology/FND/Relations/Relations/hasAlias",
        "https://w3id.org/datafabric.cc/ontologies/fibo-ru#hasRegistrationIdentifier"
    )

    @JvmStatic
    fun main(args: Array<String>) {
        var cluster: Cluster? = null

        try {
            cluster = Cluster.builder()
                .addContactPoints("10.132.0.29", "10.132.0.40")
                .build()

            val session = cluster.connect("triplestore")

            var globalStart = System.currentTimeMillis()
            var cumulativeSum: Long = 0
            SUBJECTS.forEach { subject ->
                val eachStart = System.currentTimeMillis()

                session
                    .execute("SELECT predicate, object FROM spo WHERE subject = ?", subject)
                    .all()

                cumulativeSum += (System.currentTimeMillis() - eachStart)
            }
            println("Sequentially executed " + SUBJECTS.size + " star-shaped patterns in " +
                (System.currentTimeMillis() - globalStart) + "ms")
            println("Average per pattern time is " + (cumulativeSum / SUBJECTS.size) + "ms")

            globalStart = System.currentTimeMillis()
            cumulativeSum = 0
            SUBJECTS.forEach { subject ->
                PREDICATES.forEach { predicate ->
                    val eachStart = System.currentTimeMillis()

                    session
                        .execute("SELECT object FROM spo WHERE subject = ? AND predicate = ?", subject, predicate)
                        .all()

                    cumulativeSum += (System.currentTimeMillis() - eachStart)
                }
            }
            println("Sequentially executed " + SUBJECTS.size * PREDICATES.size + " selective patterns in " +
                (System.currentTimeMillis() - globalStart) + "ms")
            println("Average per pattern time is " + (cumulativeSum / (SUBJECTS.size * PREDICATES.size)) + "ms")

            globalStart = System.currentTimeMillis()
            cumulativeSum = 0
            var results: List<ResultSetFuture> = SUBJECTS.stream().map { subject ->
                session.executeAsync("SELECT predicate, object FROM spo WHERE subject = ?", subject)
            }.collect(Collectors.toList())
            Futures.allAsList(results).get()

            println("Executed in parallel " + SUBJECTS.size + " star-shaped patterns in " +
                (System.currentTimeMillis() - globalStart) + "ms")

            globalStart = System.currentTimeMillis()
            cumulativeSum = 0
            results = SUBJECTS.stream().flatMap { subject ->
                PREDICATES.stream().map { predicate ->
                    session
                        .executeAsync("SELECT object FROM spo WHERE subject = ? AND predicate = ?", subject, predicate)
                }
            }.collect(Collectors.toList())
            Futures.allAsList(results).get()

            println("Executed in parallel " + SUBJECTS.size * PREDICATES.size + " selective patterns in " +
                (System.currentTimeMillis() - globalStart) + "ms")
        } finally {
            cluster?.close()
        }
    }

}