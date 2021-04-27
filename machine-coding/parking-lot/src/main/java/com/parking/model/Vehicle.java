package com.parking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract  class Vehicle {
    private final String registrationNumber;
    private final String colour;

}
