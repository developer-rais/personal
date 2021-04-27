package com.elavator.model;

import lombok.Data;

import java.util.TreeSet;

@Data
public class Elevator {

    private int currentFloor;
    private Direction currentDirection;
    ElevatorState sate;

    // queues
    private TreeSet<Request> currentJobs;
    private TreeSet<Request> upPendingJobs;
    private TreeSet<Request> downPendingJobs;

    public Elevator()
    {
        this.currentFloor=0;
        this.currentDirection=Direction.UP;
        this.sate=ElevatorState.IDLE;

        // queues
         currentJobs=new TreeSet<>();
         upPendingJobs=new TreeSet<>();
        downPendingJobs=new TreeSet<>();

    }

    public void startElevator()
    {
        while(true)
        {
            if(checkIfJob()) {
                if (currentDirection == Direction.UP) {

                Request request = currentJobs.pollFirst();
                processUpRequest(request);
                if (currentJobs.isEmpty()) {
                   //     appendFromPending
                }
            }

            }

        }
    }

    public void  processUpRequest(Request request)
    {
       int startFloor=currentFloor;
       int destinationFloor=request.getExternalRequest().getSourceFloor();
       if(currentFloor<destinationFloor )
       {
           for(int i=startFloor;i<=destinationFloor;i++)
           {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException exception) {
                   exception.printStackTrace();
               }
               currentFloor=i;
               System.out.println("We have reached to floor: "+currentFloor);

           }

       }
        System.out.println("Reached source floor: "+currentFloor);


    }



    public  boolean checkIfJob()
    {
        return !currentJobs.isEmpty();
    }





}
