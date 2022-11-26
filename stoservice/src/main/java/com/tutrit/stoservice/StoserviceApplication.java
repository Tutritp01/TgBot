package com.tutrit.stoservice;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.provider.DemoDataLoader;
import com.tutrit.stoservice.provider.SendMessageJob;
import com.tutrit.stoservice.service.MenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.tutrit.stoservice.settings.Configuration.getProperties;
import static com.tutrit.stoservice.settings.Configuration.isLoadDataDemo;

@SpringBootApplication
public class StoserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoserviceApplication.class, args);
        getProperties();
        ApplicationContextLoader.run();
        if (isLoadDataDemo()) new DemoDataLoader().run();
        new MenuService().start();
        new SendMessageJob().start();
    }
}
