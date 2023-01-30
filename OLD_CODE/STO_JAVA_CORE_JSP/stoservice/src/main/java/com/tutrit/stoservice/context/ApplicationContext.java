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

    static <T> T loadClass(Class<T> clazz) {
        return (T) context.get(clazz);
    }

    public static <T> T get(Class<T> clazz) {
        T obj = (T) context.get(clazz);
        if (obj == null) {
            ApplicationContextLoader.run();
        }
        obj = (T) context.get(clazz);
        if (obj == null) {
            throw new RuntimeException("Class not loaded: " + clazz.getName());
        }
        return obj;
    }
}
