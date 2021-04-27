package com.rais.abstractfactory2;

import com.rais.abstractfactory2.factory.ProfessionFactory;

public class ProfessionApplication {


    public static void main(String[] args) {
        ProfessionFactory factory=new ProfessionFactory();

        factory.getProfession("Doctor");
    }



}
