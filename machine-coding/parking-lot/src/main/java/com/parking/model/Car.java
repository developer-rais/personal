package com.parking.model;

import lombok.Getter;

@Getter
public class Car  extends  Vehicle{
    public Car(String registrationNumber, String colour) {
        super(registrationNumber, colour);
    }
}
