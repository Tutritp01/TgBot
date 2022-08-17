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
        Engineer[] engineersActual = engineerProvider.getEngineers(3);
        Engineer[] engineersExpected = new Engineer[engineersActual.length];
        engineersExpected[0] = new Engineer("id0","firstName0","lastName0","function0","category0","education0",0,0);
        engineersExpected[1] = new Engineer("id1","firstName1","lastName1","function1","category1","education1",1,1);
        engineersExpected[2] = new Engineer("id2","firstName2","lastName2","function2","category2","education2",2,2);

        assertArrayEquals(engineersExpected, engineersActual);
    }
}
