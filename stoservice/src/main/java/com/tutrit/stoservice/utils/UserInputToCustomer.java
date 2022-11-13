package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Customer;

import java.util.HashMap;

public class UserInputToCustomer {

    private UserInputToCustomer() {
        throw new IllegalStateException("Utility class");
    }

    public static Customer getCustomer(String inputMsg) {
        HashMap<String, String> map = GetMap.getMap(inputMsg);
        return makeCustomer(map);
    }

    private static Customer makeCustomer(HashMap<String, String> map) {
        var customer = new Customer();
        if (!map.isEmpty()) {
            customer.setId("temp");
            customer.setCity(map.get("city"));
            customer.setEmail(map.get("email"));
            customer.setName(map.get("name"));
            customer.setPhoneNumber(map.get("phoneNumber"));
            return customer;
        }
        return null;
    }
}
