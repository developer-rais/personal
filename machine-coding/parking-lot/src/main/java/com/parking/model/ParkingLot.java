package com.parking.model;

import com.parking.exception.InValidSlotException;
import com.parking.exception.SlotNotAvailableException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ParkingLot {

    public int capacity;
    public int currentCapacity;
    Map<Integer, ParkingSlot> parkingSlotMap;

    public ParkingLot(final int capacity) {
        this.capacity = capacity;
        this.parkingSlotMap = new HashMap<>();
        this.currentCapacity = 0;
    }

    public ParkingSlot getParkingSlot(final Integer slotNumber) {
        if (slotNumber <= 0 || slotNumber > capacity) {
            return null;
        }
        ParkingSlot parkingSlot = this.parkingSlotMap.get(slotNumber);
        if (parkingSlot == null) {
            parkingSlot = new ParkingSlot(slotNumber);
            parkingSlotMap.put(slotNumber, parkingSlot);
        }
        return parkingSlot;
    }

    public ParkingSlot parkVehicle(Vehicle vehicle, final Integer slotNumber) {
        try {
            if (slotNumber <= 0 || slotNumber > capacity) {
                throw new InValidSlotException();
            }
            ParkingSlot parkingSlot = parkingSlotMap.get(slotNumber);
            if (!parkingSlot.isSlotAvailable()) {
                throw new SlotNotAvailableException();
            }
            parkingSlot.parkVehicle(vehicle);
            return parkingSlot;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public ParkingSlot markSlotFree(final Integer slotNumber) {
        ParkingSlot parkingSlot = parkingSlotMap.get(slotNumber);
        if (parkingSlot != null) {
            parkingSlot.makeSlotAvailable();
        }
        return parkingSlot;
    }


}
