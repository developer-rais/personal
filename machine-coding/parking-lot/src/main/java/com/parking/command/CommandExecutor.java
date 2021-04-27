package com.parking.command;

import com.parking.model.Command;
import com.parking.output.OutputWriter;
import com.parking.service.ParkingLotService;

public abstract  class CommandExecutor {

    private ParkingLotService parkingLotService;
    private OutputWriter outputWriter;
   public  CommandExecutor(final ParkingLotService parkingLotService,final OutputWriter outputWriter)
   {
       this.parkingLotService=parkingLotService;
       this.outputWriter=outputWriter;
   }

   public  abstract  boolean validate(Command command);

    public  abstract  void execute(Command command);



}
