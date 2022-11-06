package com.tutrit.stoservice.parser;

import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapper {

    public static <T> T mapTo(Class<T> clazz, Map<String, String> objectValues) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            final Map<String, Field> fieldMap = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toMap(Field::getName, f -> f));
            fieldMap.values().forEach(f -> f.setAccessible(true));
            fieldMap.values().forEach(f -> setValueSneaky(obj, f, objectValues));
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    private static void setValueSneaky(final Object obj, final Field f, Map<String, String> objectValues) {
        try {
            switch (f.getType().getSimpleName()) {
                case "String" -> f.set(obj, objectValues.get(f.getName()));
                case "int" -> f.setInt(obj, Integer.valueOf(objectValues.get(f.getName())));
                default -> f.set(obj, null);
            }

        } catch (Exception e) {
            LoggerFactory.getLogger(UserInput.class).warn("Cant set value: {}", e.getMessage());
        }
    }
}
