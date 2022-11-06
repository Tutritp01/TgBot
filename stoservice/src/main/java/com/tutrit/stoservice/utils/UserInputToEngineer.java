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
            engineer.setFirstName(map.get("FirstName"));
            engineer.setLastName(map.get("LastName"));
            engineer.setFunction(map.get("Function"));
            engineer.setCategory(map.get("Category"));
            engineer.setEducation(map.get("Education"));
            engineer.setExperience(Integer.parseInt(map.get("Experience")));
            engineer.setGeneralExperience(Integer.parseInt(map.get("GeneralExperience")));
            return engineer;
        }
        return null;
    }
}
