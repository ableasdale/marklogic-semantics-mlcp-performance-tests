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

@Tag("rdfxml")
@MarkLogicMLCP
@DisplayName("Benchmarking performance when loading Resource Description Framework (.rdf) files using MarkLogic Content Pump (MLCP)")
class MLCPLoadRDFXMLTest {

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 175KB RDF/XML file (countries.rdf)")
    void testLoadingSmallRDFXMLFile() {
        assertTimeoutPreemptively(ofSeconds(5), () -> ContentPump.runCommand(loadContent("/rdfxml/countries.rdf")));
        assertEquals(9330, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 189KB RDF/XML file (currencies.rdf)")
    void testLoadingAnotherSmallRDFXMLFile() {
        assertTimeoutPreemptively(ofSeconds(5), () -> ContentPump.runCommand(loadContent("/rdfxml/currencies.rdf")));
        assertEquals(3231, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }

    @Benchmark
    @RepeatedTest(2)
    @DisplayName("Using MarkLogic Content Pump to load a 21.8MB RDF/XML file (peel.rdf)")
    void testLoadingMediumRDFXMLFile() {
        assertTimeoutPreemptively(ofSeconds(45), () -> ContentPump.runCommand(loadContent("/rdfxml/peel.rdf")));
        assertEquals(271369, MarkLogicReSTApiClientProvider.getTripleCount());
        assertEquals(2, MarkLogicReSTApiClientProvider.getGraphCount());
    }
}
