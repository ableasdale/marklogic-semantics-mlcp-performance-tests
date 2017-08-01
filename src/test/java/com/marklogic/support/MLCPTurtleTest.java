package com.marklogic.support;

import com.marklogic.support.annotations.Benchmark;
import com.marklogic.support.annotations.MarkLogicMLCP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Tag("turtle")
@MarkLogicMLCP
@DisplayName("Benchmarking performance when loading Turtle (.ttl) files using the MarkLogic Java Client API")
public class MLCPTurtleTest {

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using the MarkLogic RDF4J API to load a 130MB Turtle file (fulldump.ttl)")
    void testLoadingAnotherLargeTurtleFile() {
       // assertTimeoutPreemptively(ofSeconds(150), () -> MarkLogicJavaClientProvider.getClient().newGraphManager().write(GraphManager.DEFAULT_GRAPH, getFileHandleForTurtleFile("turtle/fulldump.ttl")));
       // assertEquals(204122, SPARQLUtils.countAllTriples(MarkLogicJavaClientProvider.getClient()));
       // assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }
}
