package com.tutrit.tgbot.example.repository;

import com.tutrit.tgbot.example.bean.UserEmployee;
import org.apache.commons.lang3.ArrayUtils;

public class RepositoryUserEmployee {

    public static Object[] arrayEmployee = new Object[1];

    public static Object[] createEmployee(UserEmployee userEmployee) {
        ArrayUtils.insert(0,arrayEmployee, userEmployee);
        return arrayEmployee;
    }


}
