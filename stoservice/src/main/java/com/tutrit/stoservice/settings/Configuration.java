package com.tutrit.stoservice.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static boolean loadDataDemo;
    private static final String PATH_TO_PROPERTIES = "stoservice/src/main/resources/config.properties";

    private Configuration() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isLoadDataDemo() {
        return loadDataDemo;
    }

    public static void getProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties.load(fileInputStream);
            String loadDemoProp = properties.getProperty("LoadDemoData");
            if (loadDemoProp.equals("Yes")) loadDataDemo = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
