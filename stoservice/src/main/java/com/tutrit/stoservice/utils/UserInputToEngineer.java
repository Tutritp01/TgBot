package com.tutrit.stoservice.utils;

import com.tutrit.stoservice.bean.Engineer;

import java.util.HashMap;

public class UserInputToEngineer {

    private UserInputToEngineer() {
        throw new IllegalStateException("Utility class");
    }

    public static Engineer getEngineer(String inputMsg) {
        HashMap<String, String> map = GetMap.getMap(inputMsg);
        return makeEngineer(map);
    }

    private static Engineer makeEngineer(HashMap<String, String> map) {
        var engineer = new Engineer();
        if (!map.isEmpty()) {
            engineer.setIdEngineer("temp");
            engineer.setFirstName(map.get("firstName"));
            engineer.setLastName(map.get("lastName"));
            engineer.setFunction(map.get("function"));
            engineer.setCategory(map.get("category"));
            engineer.setEducation(map.get("education"));
            engineer.setExperience(Integer.parseInt(map.get("experience")));
            engineer.setGeneralExperience(Integer.parseInt(map.get("generalExperience")));
            return engineer;
        }
        return null;
    }
}
