package com.tutrit.tgbot.example.bean;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private String generation;
    private String modification;
    private String engine;
    private long year;
    private String note;

    public Car() {
        this.brand = "";
        this.model = "";
        this.generation = "";
        this.modification = "";
        this.engine = "";
        this.year = 0L;
        this.note = "";
    }

    public Car(String brand, String model, String generation, String modification, String engine, long year, String note) {
        this.brand = brand;
        this.model = model;
        this.generation = generation;
        this.modification = modification;
        this.engine = engine;
        this.year = year;
        this.note = note;
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

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(generation, car.generation) && Objects.equals(modification, car.modification) && Objects.equals(engine, car.engine) && Objects.equals(note, car.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, generation, modification, engine, year, note);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", generation='" + generation + '\'' +
                ", modification='" + modification + '\'' +
                ", engine='" + engine + '\'' +
                ", year=" + year +
                ", note='" + note + '\'' +
                '}';
    }
}
