package com.tutrit.stoservice.settings;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class ArgsSetup {
    public void readingFlags(String[] args) {
        for (String arg : args) {
            if (arg.equals("-eld")) get(Configurations.class).setLoadDataDemo(true);
            if (arg.equals("-dld")) get(Configurations.class).setLoadDataDemo(false);
        }
    }
}
