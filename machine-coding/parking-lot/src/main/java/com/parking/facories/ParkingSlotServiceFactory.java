package com.parking.facories;

import com.parking.model.ParkingLot;
import com.parking.service.ParkingLotService;
import com.parking.strategy.NaturalParkingStrategy;
import com.parking.strategy.ParkingStrategy;

public class ParkingSlotServiceFactory {

    public ParkingLotService getNaturalStrategyParkingLotService(int capacity) {
        ParkingStrategy naturalParkingStrategy = new NaturalParkingStrategy();
        ParkingLot parkingLot = new ParkingLot(capacity);
        for(int i=0;i<=capacity;i++)
        {
            naturalParkingStrategy.addSlot(i);
        }

        return new ParkingLotService(naturalParkingStrategy, parkingLot);
    }
}
