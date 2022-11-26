package com.tutrit.stoservice;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.provider.DemoDataLoader;
import com.tutrit.stoservice.provider.SendMessageJob;
import com.tutrit.stoservice.service.MenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class StoserviceApplication {
    public static final String PATH_TO_PROPERTIES = "stoservice/src/main/resources/config.properties";
    private static boolean loadData;

    public static void main(String[] args) {
        SpringApplication.run(StoserviceApplication.class, args);
        getProperties();
        ApplicationContextLoader.run();
        if (loadData) new DemoDataLoader().run();
        new MenuService().start();
        new SendMessageJob().start();
    }

    private static void getProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties.load(fileInputStream);
            String loadDemoProp = properties.getProperty("LoadDemoData");
            if (loadDemoProp.equals("Yes")) loadData = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
