package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.mock.CustomerControllerSpy;
import com.tutrit.stoservice.mock.CustomerRepositoryMock;
import com.tutrit.stoservice.mock.CustomerServiceMock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerControllerTest {

    @BeforeEach
    public void setUp() {
        ApplicationContextLoader.run();
    }

    @Test
    void doCommandIntegrationTest() {


        Request request = new Request("new customer");
        Response response = new Response();
        ApplicationContext.get(CustomerController.class).doCommand(request, response);


        Response expectedResponse = new Response();
        expectedResponse.setResponse("Customer nullis saved");
        Assertions.assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);

    }

    @Test
    void CustomerControllerSpyTest() {

        CustomerRepositoryMock customerRepositoryMock = new CustomerRepositoryMock();
        CustomerServiceMock customerService = new CustomerServiceMock(customerRepositoryMock);
        CustomerControllerSpy customerControllerSpy = new CustomerControllerSpy(customerService);

        Request request = new Request("new customer");
        Response response = new Response();
        customerControllerSpy.doCommand(request, response);


        assertEquals(1, customerControllerSpy.numSaveCustomerToRepCalled);
    }


}
