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

@Tag("trig")
@MarkLogicMLCP
@DisplayName("Benchmarking performance when loading TriG (.trig) files using MarkLogic Content Pump (MLCP)")
class MLCPLoadTriGTest {

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 502Kb TriG file (charging-stations-export-20170530-095530.trig)")
    void testLoadingSmallTriGFile() {
        assertTimeoutPreemptively(ofSeconds(5), () -> ContentPump.runCommand(loadContent("/trig/charging-stations-export-20170530-095530.trig")));
        assertEquals(8900, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 1.9MB TriG file (example.trig)")
    void testLoadingAnotherSmallTriGFile() {
        assertTimeoutPreemptively(ofSeconds(10), () -> ContentPump.runCommand(loadContent("/trig/example.trig")));
        assertEquals(13671, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(1807, MarkLogicReSTApiClientProvider.getGraphCount());  // TODO - why is this different?
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 62.3MB TriG file (wp-monthy_all.trig)")
    void testLoadingLargeTriGFile() {
        assertTimeoutPreemptively(ofSeconds(150), () -> ContentPump.runCommand(loadContent("/trig/wp-monthy_all.trig")));
        assertEquals(668367, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

}
