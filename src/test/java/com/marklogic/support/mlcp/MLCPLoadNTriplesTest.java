package com.marklogic.support.mlcp;

import com.marklogic.contentpump.ContentPump;
import com.marklogic.support.annotations.Benchmark;
import com.marklogic.support.annotations.MarkLogicMLCP;
import com.marklogic.support.providers.MarkLogicReSTApiClientProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

import static com.marklogic.support.Configuration.loadContent;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Tag("ntriples")
@MarkLogicMLCP
@DisplayName("Benchmarking performance when loading N-Triples (.nt) files using MarkLogic Content Pump (MLCP)")
class MLCPLoadNTriplesTest {

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 506Kb N-Triples file (ron.nt)")
    void testLoadingSmallNtFile() {
        assertTimeoutPreemptively(ofSeconds(5), () -> ContentPump.runCommand(loadContent("/nt/ron.nt")));
        assertEquals(3348, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 801Kb N-Triples file (rmn.nt)")
    void testLoadingAnotherSmallNtFile() {
        assertTimeoutPreemptively(ofSeconds(5), () -> ContentPump.runCommand(loadContent("/nt/rmn.nt")));
        assertEquals(5069, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load an 11.8MB N-Triples file (dbpedia60k.nt)")
    void testLoadingMediumNtFile() {
        assertTimeoutPreemptively(ofSeconds(10), () -> ContentPump.runCommand(loadContent("/nt/dbpedia60k.nt")));
        assertEquals(58514, MarkLogicReSTApiClientProvider.getTripleCount());  // TODO - why different?
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load an 18.2MB N-Triples file (ron-data.nt)")
    void testLoadingMedNtFile() {
        assertTimeoutPreemptively(ofSeconds(10), () -> ContentPump.runCommand(loadContent("/nt/ron-data.nt")));
        assertEquals(109672, MarkLogicReSTApiClientProvider.getTripleCount());  // TODO - why different?
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 18.2MB N-Triples file (rmn-data.nt)")
    void testLoadingAnotherMedNtFile() {
        assertTimeoutPreemptively(ofSeconds(10), () -> ContentPump.runCommand(loadContent("/nt/rmn-data.nt")));
        assertEquals(113904, MarkLogicReSTApiClientProvider.getTripleCount());  // TODO - why different?
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }
}
