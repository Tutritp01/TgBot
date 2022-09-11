package com.tutrit.stoservice.contex;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private static Map<Class, Object> context = new HashMap<>();

    public static void put(Class clazz, Object obj) {
        context.put(clazz, obj);
    }

    public  static <T> T get(Class<T> clazz) {
        return (T) context.get(clazz);
    }
}
