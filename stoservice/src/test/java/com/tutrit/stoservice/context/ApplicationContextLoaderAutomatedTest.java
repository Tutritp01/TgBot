package com.tutrit.stoservice.context;

import com.tutrit.stoservice.repository.CarRepository;
import com.tutrit.stoservice.repository.OrderRepository;
import com.tutrit.stoservice.service.CarService;
import com.tutrit.stoservice.service.OrderService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextLoaderAutomatedTest {
    Class clazz[] = {OrderService.class, CarRepository.class, CarService.class, OrderRepository.class};
    @Test
    void createClass() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // Now that should work with 1 class.
        ApplicationContextLoaderAutomated loader = new ApplicationContextLoaderAutomated();
        loader.getInstance(CarService.class);
    }

    @Test
    void getFields() {
        ApplicationContextLoaderAutomated loader = new ApplicationContextLoaderAutomated();
        loader.getFields(CarService.class);
    }

    @Test
    void loadContextText() {
        ApplicationContextLoaderAutomated loader = new ApplicationContextLoaderAutomated();
        loader.setClazz(clazz);
        loader.loadContext();
        assertEquals(4, ApplicationContext.context.size());
    }
}