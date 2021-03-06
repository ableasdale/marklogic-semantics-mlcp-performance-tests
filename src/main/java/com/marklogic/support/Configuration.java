package com.marklogic.support;

/**
 * Created by ableasdale on 24/05/2017.
 */
public class Configuration {

    public static final String HOST = "0.0.0.0";
    public static final int PORT = 8000;
    public static final String USERNAME = "q";
    public static final String PASSWORD = "q";
    public static final String AUTH = "DIGEST";
    public static final String DATABASE = "rest-example";
    public static final String FOREST = "rest-example-1";
    public static final String WORKING_DIRECTORY = "/space";
    public static final String RESOURCES = "src/main/resources/";

    // TODO - Configure triple idx (XDMP-TRPLIDXNOTFOUND) AND COLLECTION LEXICON

    public static String[] loadContent(String inputfilename) {
        return new String[]{
                "import",
                "-username", USERNAME,
                "-password", PASSWORD,
                "-host", HOST,
                "-port", String.valueOf(PORT),
                "-database", DATABASE,
                "-mode", "local",
                "-input_file_type", "rdf",
                "-input_file_path",  String.format("%s/%s%s", System.getProperty("user.dir"), Configuration.RESOURCES, inputfilename),
                //"-split_input", "true",
                "-thread_count", "32",
                "-batch_size", "200",
                "-fastload"// will reset to 200
                //String.format("input_file_path %s", inputFilePath)
        };
    };

}
