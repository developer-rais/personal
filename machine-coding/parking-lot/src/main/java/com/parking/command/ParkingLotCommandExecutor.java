package com.parking.command;


import com.parking.model.Command;
import com.parking.service.ParkingLotService;

public class ParkingLotCommandExecutor extends CommandExecutor {
    public ParkingLotCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return false;
    }

    @Override
    public void execute(Command command) {

    }
}
