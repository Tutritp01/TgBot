package com.tutrit.stoservice;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.provider.DemoDataLoader;
import com.tutrit.stoservice.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.tutrit.stoservice.context.ApplicationContext.get;

@SpringBootApplication
public class StoServiceApplication {
    private static final Logger log = LoggerFactory.getLogger("main");

    public static void main(String[] args) {
        SpringApplication.run(StoServiceApplication.class, args);
        ApplicationContextLoader.run();
        get(DemoDataLoader.class).run();
        while (true) {
            get(MenuService.class).run();
        }
    }
}
