package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Order;

public class GetOrder {

    private GetOrder() {
        throw new IllegalStateException("Utility class");
    }

    public static Order getOrder(String inputMsg) {
        return new Order();
    }
}
