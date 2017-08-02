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

@Tag("n3")
@MarkLogicMLCP
@DisplayName("Benchmarking performance when loading Notation3 (.n3) files using MarkLogic Content Pump (MLCP)")
class MLCPLoadN3Test {

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 39.5MB Notation 3 (N3) file (event-dump.n3)")
    void testLoadingMediumN3File() {
        assertTimeoutPreemptively(ofSeconds(30), () -> ContentPump.runCommand(loadContent("/n3/event-dump.n3")));
        assertEquals(682466, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 57.8MB Notation 3 (N3) file (sec.n3)")
    void testLoadingLargeN3File() {
        assertTimeoutPreemptively(ofSeconds(65), () -> ContentPump.runCommand(loadContent("/n3/sec.n3")));
        assertEquals(1813135, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

}
