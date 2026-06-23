package main.elevatorsystem.scheduling;

import main.elevatorsystem.Direction;
import main.elevatorsystem.Elevator;
import main.elevatorsystem.ElevatorState;
import main.elevatorsystem.SchedulingStrategy;
import main.elevatorsystem.request.PickUpRequest;
import main.elevatorsystem.request.Request;

import java.util.List;

public class DirectionAwareStrategy implements SchedulingStrategy {

    private boolean canServe(Elevator elevator, PickUpRequest request){

        if(elevator.elevatorState == ElevatorState.IDLE){
            return true ;
        }
        if(elevator.direction!=request.direction){
            return false;
        }
        if(elevator.direction == Direction.UP){
            return elevator.currentFloor<= request.floor;
        }
        return elevator.currentFloor>= request.floor;
    }

    @Override
    public Elevator assignElevators(List<Elevator> elevatorList, PickUpRequest request) {

        int minDistance = Integer.MAX_VALUE;
        Elevator elevatorSelected = null ;

        for(Elevator elevator : elevatorList){
              if(canServe(elevator, request)){
                  if(minDistance > Math.abs(request.floor - elevator.currentFloor)){
                      minDistance = Math.abs(request.floor - elevator.currentFloor);
                      elevatorSelected = elevator;
                  }
              }
        }

        if(elevatorSelected == null) {
            for (Elevator elevator : elevatorList) {
                if (elevator.elevatorState == ElevatorState.IDLE) return elevator;
            }
        }

        return elevatorSelected;

    }
}
