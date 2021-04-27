package com.parking.strategy;


import java.util.TreeSet;

public class NaturalParkingStrategy implements  ParkingStrategy{


    TreeSet<Integer> slotTreeSet;

    public NaturalParkingStrategy()
    {
        this.slotTreeSet=new TreeSet<>();
    }
    @Override
    public void addSlot(Integer slotNumber) {

        slotTreeSet.add(slotNumber);

    }

    @Override
    public void removeSlot(Integer slotNumber) {
        slotTreeSet.remove(slotNumber);

    }

    @Override
    public Integer getNextSlot() {
        if(slotTreeSet.isEmpty())
        {
            return null;
        }
        return slotTreeSet.first();
    }
}
