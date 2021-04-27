package com.parking.service;

import com.parking.model.ParkingLot;
import com.parking.model.Vehicle;
import com.parking.strategy.ParkingStrategy;

import java.util.List;

public class ParkingLotService {

    private final ParkingStrategy parkingStrategy;
    private final ParkingLot parkingLot;

    public ParkingLotService(final ParkingStrategy parkingStrategy,final ParkingLot parkingLot)
    {
        this.parkingStrategy=parkingStrategy;
        this.parkingLot=parkingLot;
    }

    public Integer addVehicle(final Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
        final Integer findNextSpot = parkingStrategy.getNextSlot();
        parkingLot.parkVehicle(vehicle, findNextSpot);
        parkingStrategy.removeSlot(findNextSpot);
        return findNextSpot;
    }

    public void makeSlotAvailable(Integer slotNumber)
    {
        parkingLot.markSlotFree(slotNumber);
        parkingStrategy.addSlot(slotNumber);
    }

    public List<ParkingLot> getOccupiedSlots()
    {
        return null;
    }

}
