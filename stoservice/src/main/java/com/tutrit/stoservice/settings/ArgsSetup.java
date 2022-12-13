package com.tutrit.stoservice.settings;

public class ArgsSetup {
    Configurations configurations;

    public ArgsSetup(Configurations configurations) {
        this.configurations = configurations;
    }

    public void readingFlags(String[] args) {
        for (String arg : args) {
            if (arg.equals("-eld")) configurations.setLoadDataDemo(true);
            if (arg.equals("-dld")) configurations.setLoadDataDemo(false);
        }
    }
}
