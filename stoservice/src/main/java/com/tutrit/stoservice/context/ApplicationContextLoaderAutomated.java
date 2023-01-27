package com.tutrit.stoservice.context;

import com.tutrit.stoservice.repository.CarRepository;
import com.tutrit.stoservice.service.CarService;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static com.tutrit.stoservice.context.ApplicationContext.get;
import static com.tutrit.stoservice.context.ApplicationContext.put;

public class ApplicationContextLoaderAutomated {

    Class clazz[] = {CarRepository.class, CarService.class}; //this list we will get from file system

    public void setClazz(final Class[] clazz) {
        this.clazz = clazz;
    }

    public void loadContext() {
        Arrays.stream(this.clazz).forEach(clazz -> getInstanceSneaky(clazz));
    }

    public void getInstanceSneaky(Class clazz) {
        try {
            getInstance(clazz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //do nothing
        }
    }

    public Object getInstance(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        if (get(clazz) == null) {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            put(clazz, instance);
            final Map<String, Class> fields = getFields(clazz);
            if (fields.size() > 0) {
                for (Map.Entry<String, Class> entry : fields.entrySet()) {
                    try {
                        Object value = getInstance(entry.getValue());
                        setValueSneaky(instance, clazz.getDeclaredField(entry.getKey()), value);
                    } catch (Exception e) {
                        System.out.println("can't create instance of "+ entry.getKey() + " " + entry.getValue());
                    }
                } //
            }

            return get(clazz);
        }
        return get(clazz);
    }

    public Map<String, Class> getFields(Class clazz) {

        return Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toMap(v -> v.getName(), v -> v.getType()));
    }


    private static void setValueSneaky(final Object obj, final Field f, Object value) {
        try {
            switch (f.getType().getSimpleName()) {
                case "String", "int", "double", "List", "Logger", "Map" -> System.out.println("primitive (and some others, maybe also) types we do not set yet");
                default -> {
                    f.setAccessible(true);
                    f.set(obj, value);
                }
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(ApplicationContextLoaderAutomated.class).warn("Cant set value: {}", e.getMessage());
        }
    }
}
