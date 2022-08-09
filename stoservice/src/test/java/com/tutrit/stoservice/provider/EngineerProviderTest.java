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
        Engineer[] engineers = new Engineer[3];

        engineers[0] = new Engineer("1","1","1","1","1","1",1,1);
        engineers[1] = new Engineer("2","2","2","2","2","2",2,2);
        engineers[2] = new Engineer("3","3","3","3","3","3",3,3);

        assertArrayEquals(engineers, engineerProvider.getEngineers());
    }
}
