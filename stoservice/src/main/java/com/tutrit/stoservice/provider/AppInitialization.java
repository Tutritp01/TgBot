package com.tutrit.stoservice.provider;

public class AppInitialization {

    public AppInitialization(DemoDataProvider... providers) {
        init(providers);
    }

    public void init(DemoDataProvider... providers) {
        for (final DemoDataProvider provider : providers) {
            provider.getInstances();
        }
    }
}
