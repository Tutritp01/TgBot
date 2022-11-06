package com.tutrit.stoservice.bean;

import com.tutrit.stoservice.dto.CarDto;
import com.tutrit.stoservice.parser.MapTo;

import java.util.Objects;

public class Car {

    private String id;
    private String brand;
    private String model;
    private String generation;
    private String modification;
    private String engine;
    private int year;
    @MapTo
    private User user;

    public Car() {
    }

    public Car(String id, String brand, String model, String generation, String modification, String engine, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.generation = generation;
        this.modification = modification;
        this.engine = engine;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(id, car.id) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(generation, car.generation) && Objects.equals(modification, car.modification) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, generation, modification, engine, year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", generation='" + generation + '\'' +
                ", modification='" + modification + '\'' +
                ", engine='" + engine + '\'' +
                ", year=" + year +
                '}';
    }
}
