package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.context.ApplicationContextLoader;
import com.tutrit.stoservice.mock.CustomerControllerSpy;
import com.tutrit.stoservice.mock.CustomerRepositoryMock;
import com.tutrit.stoservice.mock.CustomerRepositoryUUIDMock;
import com.tutrit.stoservice.mock.CustomerServiceMock;
import com.tutrit.stoservice.repository.CustomerRepository;
import com.tutrit.stoservice.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerControllerTest {

    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        ApplicationContextLoader.run();
        customerController = get(CustomerController.class);
        ApplicationContext.get(CustomerRepository.class).clean();
    }

    @Test
    void doCommandIntegrationTest() {
        CustomerRepository customerRepository = new CustomerRepositoryUUIDMock();
        CustomerServiceMock customerService = new CustomerServiceMock(customerRepository);
        Request request = new Request("new customer -d name=bob");
        Response response = new Response();
        ApplicationContext.get(CustomerController.class).doCommand(request, response);


        Response expectedResponse = new Response();
        expectedResponse.setResponse("Customer spyValues0is saved");
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

    @Test
    void integrationCarControllerTest() {
        CustomerRepository customerRepository = new CustomerRepositoryUUIDMock();
        CustomerServiceMock customerService = new CustomerServiceMock(customerRepository);
        Response response = new Response();
        Request request = new Request("new customer -d id=zero&name=bob&city=minsk&phoneNumber=923429823&email=1823rew@mail.com");
        customerController.doCommand(request, response);
        assertEquals("Customer spyValues0is saved", response.getResponse());
        request = new Request("get customer -d id=234532");
        customerController.doCommand(request, response);
        assertEquals("Error 404: customer with 234532 not found", response.getResponse());
    }
}
