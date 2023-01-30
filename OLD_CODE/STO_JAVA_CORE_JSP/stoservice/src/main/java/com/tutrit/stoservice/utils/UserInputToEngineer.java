package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Engineer;

import java.util.Map;

public class UserInputToEngineer {

    private UserInputToEngineer() {
        throw new IllegalStateException("Utility class");
    }

    public static Engineer getEngineer(String inputMsg) {
        Map<String, String> map = GetMap.getMap(inputMsg);
        return makeEngineer(map);
    }

    private static Engineer makeEngineer(Map<String, String> map) {
        var engineer = new Engineer();
        if (!map.isEmpty()) {
            engineer.setId("temp");
            engineer.setFirstName(map.get("firstName"));
            engineer.setLastName(map.get("lastName"));
            engineer.setFunction(map.get("function"));
            engineer.setCategory(map.get("category"));
            engineer.setEducation(map.get("education"));
            String experience = map.get("experience");
            String generalExperience = map.get("generalExperience");
            if (experience != null) engineer.setExperience(Integer.parseInt(experience));
            if (generalExperience != null) engineer.setGeneralExperience(Integer.parseInt(generalExperience));
            return engineer;
        }
        return null;
    }
}
