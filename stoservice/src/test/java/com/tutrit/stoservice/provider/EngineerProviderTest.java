package com.tutrit.stoservice.provider;

import com.tutrit.stoservice.bean.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerProviderTest {
    EngineerProvider engineerProvider;

    @BeforeEach
    void setUp() {
        engineerProvider = new EngineerProvider();
    }

    @Test
    void getEngineers() {
        Engineer[] engineersActual = engineerProvider.getEngineers();
        Engineer[] engineersExpected = new Engineer[engineersActual.length];
        engineersExpected[0] = new Engineer("1","1","1","1","1","1",1,1);
        engineersExpected[1] = new Engineer("2","2","2","2","2","2",2,2);
        engineersExpected[2] = new Engineer("3","3","3","3","3","3",3,3);

        for (int i =0; i < engineersActual.length; i++) {
            assertEquals(engineersExpected[i], engineersActual[i]);
        }
    }
}
