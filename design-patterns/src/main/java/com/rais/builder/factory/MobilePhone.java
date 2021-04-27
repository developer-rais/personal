package com.rais.builder.factory;

import phone.OS;
import phone.OperatingSystemFactory;

public class MobilePhone {

    public  static void  main(String args[])
    {
        OperatingSystemFactory operatingSystemFactory=new OperatingSystemFactory();
        OS os= operatingSystemFactory.getOperatingSystemInstance("ios");
        os.spec();
    }
}
