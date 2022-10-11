package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Customer;
import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.repository.CustomerRepository;
import com.tutrit.stoservice.utility.ParseCommand;

import java.util.*;

public class CustomerService {

    public static Map<String, String> parseBody() {
        List<Integer> positions = new ArrayList<>();
        String body = ApplicationContext.get(ParseCommand.class).getBody();
        int i = 0;
        while (i != -1) {
            Integer index = body.indexOf("-", i);
            if (index != -1) {
                positions.add(index);
                i = index + 1;
            } else {
                i = index;
            }
        }

        Map<String, String> parameters = new HashMap<>();
        for (int k = 0; k < positions.size(); k++) {
            int pos = positions.get(k);
            if (k == positions.size() - 1) {
                parameters.put(
                        body.substring(pos + 1, pos + 2),
                        body.substring(pos + 3));
            } else {
                parameters.put(
                        body.substring(pos + 1, pos + 2),
                        body.substring(pos + 3, positions.get(k + 1) - 1));
            }
        }
        return parameters;
    }

    public static void saveCustomer() {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setName(parseBody().get("n"));
        customer.setCity(parseBody().get("c"));
        customer.setPhoneNumber(parseBody().get("p"));
        customer.setEmail(parseBody().get("e"));
        ApplicationContext.get(CustomerRepository.class).save(customer);
    }
}
