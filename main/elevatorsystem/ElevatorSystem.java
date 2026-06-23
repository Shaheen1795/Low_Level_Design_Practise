package main.elevatorsystem;

import main.elevatorsystem.request.DropOffRequest;
import main.elevatorsystem.request.PickUpRequest;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {

    SchedulingStrategy schedulingStrategy;
    List<Elevator> elevators;
    public ElevatorSystem(SchedulingStrategy strategy){
        schedulingStrategy = strategy;
        elevators = new ArrayList<>();
    }

    public void addElevator(Elevator elevator){
        elevators.add(elevator);
    }

    public void assignDropOffRequest(Elevator elevator, DropOffRequest dropOffRequest){
        elevator.addStop(dropOffRequest.floor);
    }

    public  void assignPickUpRequest(PickUpRequest pickUpRequest){
        Elevator selectedElevator = schedulingStrategy.assignElevators(elevators, pickUpRequest);
        System.out.println("Selected Elevator: "+selectedElevator.id);
        selectedElevator.addStop(pickUpRequest.floor);
    }
}
