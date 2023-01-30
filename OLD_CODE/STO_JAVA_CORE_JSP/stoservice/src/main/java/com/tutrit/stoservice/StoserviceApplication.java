package com.tutrit.stoservice;

import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.provider.DemoDataLoader;
import com.tutrit.stoservice.provider.SendMessageJob;
import com.tutrit.stoservice.service.MenuService;
import com.tutrit.stoservice.settings.ArgsSetup;
import com.tutrit.stoservice.settings.Configurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.tutrit.stoservice.context.ApplicationContext.get;

@SpringBootApplication
public class StoserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoserviceApplication.class, args);
        ApplicationContextLoader.run();
        if (args.length > 0) get(ArgsSetup.class).readingFlags(args);
        if (get(Configurations.class).isLoadDataDemo()) new DemoDataLoader().run();
        new MenuService().start();
        new SendMessageJob().start();
    }
}
