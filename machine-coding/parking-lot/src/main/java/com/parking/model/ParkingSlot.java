package com.parking.model;


public class ParkingSlot {
    private Vehicle vehicle;
    private final Integer slotNumber;

    public ParkingSlot(final Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Vehicle getParkedVehicle() {
        return this.vehicle;
    }


    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void makeSlotAvailable() {
        this.vehicle = null;
    }

    public boolean isSlotAvailable() {
        return vehicle == null;
    }


}
