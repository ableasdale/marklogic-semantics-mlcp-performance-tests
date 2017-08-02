package com.marklogic.support;

import com.marklogic.contentpump.ContentPump;
import com.marklogic.support.annotations.Benchmark;
import com.marklogic.support.annotations.MarkLogicMLCP;
import com.marklogic.support.providers.MarkLogicReSTApiClientProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

import java.io.IOException;

import static com.marklogic.support.Configuration.loadContent;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Tag("turtle")
@MarkLogicMLCP
@DisplayName("Benchmarking performance when loading Turtle (.ttl) files using MarkLogic Content Pump (MLCP)")
public class MLCPTurtleTest {

    /*

      @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using the ReST API to load a 596Kb x-turtle file (charging-stations-export-20170530-095533.ttl)")
    void testLoadingSmallXTurtleFile() {
        ClientResponse res = assertTimeoutPreemptively(ofSeconds(5), () -> MarkLogicReSTApiClientProvider.createPostForTurtle("turtle/charging-stations-export-20170530-095533.ttl"));
        assertEquals(201, res.getStatus());
        assertEquals(8900, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using the ReST API to load a 779K Turtle file (units.ttl)")
    void testLoadingSmallTurtleFile() {
        ClientResponse res = assertTimeoutPreemptively(ofSeconds(5), () -> MarkLogicReSTApiClientProvider.createPostForTurtle("turtle/units.ttl"));
        assertEquals(201, res.getStatus());
        assertEquals(23485, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using the ReST API to load a 3.3MB Turtle file (unescothes.ttl)")
    void testLoadingMediumSizeTurtleFile() {
        ClientResponse res = assertTimeoutPreemptively(ofSeconds(10), () -> MarkLogicReSTApiClientProvider.createPostForTurtle("turtle/unescothes.ttl"));
        assertEquals(201, res.getStatus());
        assertEquals(75202, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }
     */

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 51MB Turtle file (history.ttl)")
    void testLoadingTurtleFile() throws IOException {
        assertTimeoutPreemptively(ofSeconds(30), () -> ContentPump.runCommand(loadContent("/turtle/history.ttl")));
        assertEquals(391351, MarkLogicReSTApiClientProvider.getTripleCount()); // TODO - This value is different!
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 130MB Turtle file (fulldump.ttl)")
    void testLoadingAnotherLargeTurtleFile() throws IOException {
        assertTimeoutPreemptively(ofSeconds(45), () -> ContentPump.runCommand(loadContent("/turtle/fulldump.ttl")));
        assertEquals(204122, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }
}
