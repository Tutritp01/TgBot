package com.tutrit.stoservice.context;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private static final Map<Class<?>, Object> context = new HashMap<>();

    private ApplicationContext() {
        throw new IllegalStateException("Utility class");
    }

    public static void put(Class<?> clazz, Object object) {
        context.put(clazz, object);
    }

    public static <T> T get(Class<T> clazz) {
        return (T) context.get(clazz);
    }
}
