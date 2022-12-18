package com.tutrit.stoservice.bean;

import java.util.Objects;

public class Engineer {
    private String id;
    private String firstName;
    private String lastName;
    private String function;
    private String category;
    private String education;
    private int experience;
    private int generalExperience;

    public Engineer() {
    }

    public Engineer(String id, String firstName, String lastName, String function, String category, String education, int experience, int generalExperience) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.function = function;
        this.category = category;
        this.education = education;
        this.experience = experience;
        this.generalExperience = generalExperience;
    }

    public String getIdEngineer() {
        return id;
    }

    public void setIdEngineer(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGeneralExperience() {
        return generalExperience;
    }

    public void setGeneralExperience(int generalExperience) {
        this.generalExperience = generalExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engineer engineer = (Engineer) o;
        return experience == engineer.experience && generalExperience == engineer.generalExperience && Objects.equals(id, engineer.id) && Objects.equals(firstName, engineer.firstName) && Objects.equals(lastName, engineer.lastName) && Objects.equals(function, engineer.function) && Objects.equals(category, engineer.category) && Objects.equals(education, engineer.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, function, category, education, experience, generalExperience);
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", function='" + function + '\'' +
                ", category='" + category + '\'' +
                ", education='" + education + '\'' +
                ", experience=" + experience +
                ", generalExperience=" + generalExperience +
                '}';
    }
}
