package com.marklogic.support;

import com.marklogic.contentpump.ContentPump;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import static com.marklogic.support.Configuration.loadContent;

public class TestMLCP {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());




    public static void main(String[] args) {
        try {
            ContentPump.runCommand(loadContent("/turtle/fulldump.ttl"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


        //LOG.info("Path : " + Paths.get(String.format("%s%s", Configuration.RESOURCES, "foo.rdf")));
        //String inputFilePath = System.getProperty("user.dir") + "/" + String.valueOf(Paths.get(String.format("%s%s", Configuration.RESOURCES, "/rdfxml/geospecies.rdf")));
        //String inputFilePath = System.getProperty("user.dir") + "/" + String.valueOf(Paths.get(String.format("%s%s", Configuration.RESOURCES, "/turtle/fulldump.ttl")));



        /*cmd = "COPY -input_host localhost"
                + " -input_username admin -input_password admin"
                + " -output_host localhost"
                + " -output_username admin -output_password admin"
                + " -output_uri_suffix .suffix"
                + " -output_uri_prefix prefix/"
                + " -input_port " + Constants.port + " -input_database " + Constants.testDb
                + " -output_port " + Constants.port + " -output_database " + Constants.copyDst;


        String[] arguments = new String[]{
                "import",
                "-username", "admin",
                "-password", "admin",
                "-host", "localhost",
                "-port", "8000",
                "-database", "marklogic-rdf4j-test-content",
                "-mode", "local",
                "-input_file_type", "rdf", //"RDF",
                "-input_file_path", inputFilePath,
                "-thread_count", "64",
                "-batch_size", "500"
                //String.format("input_file_path %s", inputFilePath)
        };*/
// -rdf_streaming_memory_threshold " + threshold

        //Utils.clearDB(Utils.getTestDbXccUri(), Constants.testDb);


