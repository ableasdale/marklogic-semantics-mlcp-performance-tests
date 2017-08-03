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

@Tag("nquads")
@MarkLogicMLCP
@DisplayName("Benchmarking performance when loading N-Quads (.nq) files using MarkLogic Content Pump (MLCP)")
class MLCPLoadNQuadsTest {

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 20.5MB N-Quads file (1_86286.nq)")
    void testLoadingSampleOne() {
        assertTimeoutPreemptively(ofSeconds(20), () -> ContentPump.runCommand(loadContent("/nquads/1_86286.nq")));
        assertEquals(86286, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(12003, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 3.3MB N-Quads file (2_12770.nq)")
    void testLoadingSampleTwo() {
        assertTimeoutPreemptively(ofSeconds(5), () -> ContentPump.runCommand(loadContent("/nquads/2_12770.nq")));
        assertEquals(12770, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2905, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 13.9MB N-Quads file (3_54187.nq)")
    void testLoadingSampleThree() {
        assertTimeoutPreemptively(ofSeconds(15), () -> ContentPump.runCommand(loadContent("/nquads/3_54187.nq")));
        assertEquals(54187, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(12157, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 35.3MB N-Quads file (4_138495.nq)")
    void testLoadingSampleFour() {
        assertTimeoutPreemptively(ofSeconds(30), () -> ContentPump.runCommand(loadContent("/nquads/4_138495.nq")));
        assertEquals(138495, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(25995, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 16MB N-Quads file (5_63578.nq)")
    void testLoadingSampleFive() {
        assertTimeoutPreemptively(ofSeconds(15), () -> ContentPump.runCommand(loadContent("/nquads/5_63578.nq")));
        assertEquals(63578, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(12323, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 31.6MB N-Quads file (6_125268.nq)")
    void testLoadingSampleSix() {
        assertTimeoutPreemptively(ofSeconds(30), () -> ContentPump.runCommand(loadContent("/nquads/6_125268.nq")));
        assertEquals(125268, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(24263, MarkLogicReSTApiClientProvider.getGraphCount());
    }


}
