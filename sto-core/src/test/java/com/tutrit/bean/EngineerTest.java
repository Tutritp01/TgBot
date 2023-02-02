package com.tutrit.bean;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

class EngineerTest {

    @Test
    void engineerBeanTest() {
        new BeanTester().testBean(Engineer.class);
    }
}
