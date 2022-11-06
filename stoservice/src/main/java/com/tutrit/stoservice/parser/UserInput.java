package com.tutrit.stoservice.parser;

import com.tutrit.stoservice.bean.Car;
import com.tutrit.stoservice.controller.Command;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserInput {

    private Command command;
    private Map<String, String> objectValues;

    public Command getCommand() {
        return null;
    }

    public <T> T getBodyAs(Class<T> clazz) throws Exception {
        T obj = Mapper.mapTo(clazz, objectValues);

        final Map<String, Field> fieldMap = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toMap(Field::getName, f -> f));
        final Map<String, Field> mapToAnnotatedFields = fieldMap.values().stream()
                .filter(f -> isMapToPresent(f))
                .collect(Collectors.toMap(k -> k.getName(), v -> v));

        final Map<String, Map<String, String>> valuesForMapToAnnotatedFields = mapToAnnotatedFields.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> createObjectValuesForMapToAnnotatedField(e.getValue())));

        mapToAnnotatedFields.values().forEach(f -> f.setAccessible(true));
        mapToAnnotatedFields.values().forEach(f -> setValueSneakyToMapToField(obj, f, Mapper.mapTo(f.getType(), valuesForMapToAnnotatedFields.get(f.getName()))));
        return obj;
    }

    private Map<String, String> createObjectValuesForMapToAnnotatedField(final Field field) {
        return objectValues.entrySet().stream()
                .filter(e -> e.getKey().startsWith(field.getName()))
                .collect(Collectors.toMap(e -> e.getKey().substring(e.getKey().indexOf(".")+1), e -> e.getValue()));
    }

    private boolean isMapToPresent(Field field) {
        return Arrays.stream(field.getAnnotations())
                .filter(a -> a.annotationType().equals(MapTo.class))
                .findFirst()
                .isPresent();
    }

    private void setValueSneakyToMapToField(final Object obj, final Field f, Object value) {
        try {
            f.set(obj, value);
        } catch (Exception e) {
            LoggerFactory.getLogger(UserInput.class).warn("Cant set value: {}", e.getMessage());
        }
    }

    public void setCommand(final Command command) {
        this.command = command;
    }

    public Map<String, String> getObjectValues() {
        return objectValues;
    }

    public void setObjectValues(final Map<String, String> objectValues) {
        this.objectValues = objectValues;
    }

    private static Field getField(Class mClass, String fieldName) throws NoSuchFieldException {
        try {
            return mClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = mClass.getSuperclass();
            if (superClass == null) {
                throw e;
            } else {
                return getField(superClass, fieldName);
            }
        }
    }
}
