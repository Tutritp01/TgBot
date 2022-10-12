package com.tutrit.stoservice.util;

import com.tutrit.stoservice.bean.Engineer;
import com.tutrit.stoservice.controller.NotACommandController;
import com.tutrit.stoservice.controller.Request;
import com.tutrit.stoservice.controller.Response;

import java.util.HashMap;
import java.util.Map;

import static com.tutrit.stoservice.context.ApplicationContext.get;

public class InputStringToMap {

    public static Map<String, String> inputMsg(String inputMsg) throws StringIndexOutOfBoundsException{
        Map<String, String> map = new HashMap<>();
        try {
        if (inputMsg.indexOf('-') > 0) {
            map.put("command", inputMsg.substring(0, inputMsg.indexOf('-')).trim());
            map.put("format", inputMsg.substring(inputMsg.indexOf('-') + 1, inputMsg.indexOf('-') + 2));
            String object = inputMsg.substring(inputMsg.indexOf("-d"));
            object = object.substring(object.indexOf('{') + 1, object.indexOf('}'));
            map.put("object", object);
        } else {
            map.put("command", inputMsg.trim());
        }
        return map;
        } catch (Exception e) {
            map.put("command", "error");
            return map;
        }
    }

    public static Engineer stringToEngineer(String objects) throws ArrayIndexOutOfBoundsException {
        Engineer engineer = new Engineer();
        try {
            Map maps = inputMsg(objects);
            String object = maps.get("object").toString();
            Map<String, String> map = new HashMap<>();
            String[] flagAndArgs = object.split(" ");
            for (String block : flagAndArgs) {
                String[] temp = block.split(":");
                map.put(temp[0], temp[1]);
            }
            engineer.setIdEngineer("temp");
            engineer.setFirstName(map.get("FN"));
            engineer.setLastName(map.get("LN"));
            engineer.setFunction(map.get("Fun"));
            engineer.setCategory(map.get("Cat"));
            engineer.setEducation(map.get("Edu"));
            engineer.setExperience(Integer.parseInt(map.get("Exp")));
            engineer.setGeneralExperience(Integer.parseInt(map.get("GExp")));
            return engineer;
        } catch (Exception e) {
            return null;
        }
    }
}
