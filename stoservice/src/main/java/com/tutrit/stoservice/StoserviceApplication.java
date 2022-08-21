package com.tutrit.stoservice;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.provider.*;
import com.tutrit.stoservice.repository.*;
import com.tutrit.stoservice.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoserviceApplication {
    private static final Logger log = LoggerFactory.getLogger("main");

    public static void main(String[] args) {
//        SpringApplication.run(StoserviceApplication.class, args);

        new DataProvider().run();

        while (true) {
            new MenuService().run();
        }
    }
}
