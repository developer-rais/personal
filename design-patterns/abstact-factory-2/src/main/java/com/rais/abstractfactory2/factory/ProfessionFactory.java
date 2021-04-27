package com.rais.abstractfactory2.factory;

import com.rais.abstractfactory2.model.Doctor;
import com.rais.abstractfactory2.model.Engineer;
import com.rais.abstractfactory2.model.Profession;
import com.rais.abstractfactory2.model.Teacher;

public class ProfessionFactory {

    public Profession getProfession(String profession) {
        if ("teacher".equals(profession)) {
            return new Teacher();
        } else if ("doctor".equals(profession)) {
            return new Doctor();
        } else if ("engineer".equals(profession)) {
            return new Engineer();
        }
        return null;
    }
}
