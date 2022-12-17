package com.tutrit.stoservice.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    private String pathToProperties;
    private boolean loadDataDemo;

    public Configurations(String path) {
        setPathToProperties(path);
        getProperties();
    }

    public void setPathToProperties(String pathToProperties) {
        this.pathToProperties = pathToProperties;
    }

    public boolean isLoadDataDemo() {
        return loadDataDemo;
    }

    public void getProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(pathToProperties)) {
            properties.load(fileInputStream);
            String loadDemoProp = properties.getProperty("LoadDemoData");
            if (loadDemoProp.equals("Yes")) {
                loadDataDemo = true;
            } else if (loadDemoProp.equals("No")){
                loadDataDemo = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
