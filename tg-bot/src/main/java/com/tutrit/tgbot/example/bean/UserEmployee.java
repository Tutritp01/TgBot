package com.tutrit.tgbot.example.bean;

import java.util.Objects;

public class UserEmployee {

    private String firstName;
    private String lastName;
    private String function;
    private String category;
    private String education;
    private int experience;
    private int generalExperience;

    public UserEmployee(String firstName, String lastName, String function, String category, String education, int experience, int generalExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.function = function;
        this.category = category;
        this.education = education;
        this.experience = experience;
        this.generalExperience = generalExperience;
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
        if (!(o instanceof UserEmployee that)) return false;
        return experience == that.experience && generalExperience == that.generalExperience && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(function, that.function) && Objects.equals(category, that.category) && Objects.equals(education, that.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, function, category, education, experience, generalExperience);
    }

    @Override
    public String toString() {
        return "UserEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", function='" + function + '\'' +
                ", category='" + category + '\'' +
                ", education='" + education + '\'' +
                ", experience=" + experience +
                ", generalExperience=" + generalExperience +
                '}';
    }
}
