package main.elevatorsystem.scheduling;

import main.elevatorsystem.Direction;
import main.elevatorsystem.Elevator;
import main.elevatorsystem.ElevatorState;
import main.elevatorsystem.SchedulingStrategy;

import java.util.List;

public class DirectionAwareStrategy implements SchedulingStrategy {

    private boolean isMovingTowards(Elevator elevator, int floor){

        if(elevator.direction == Direction.UP){
            return elevator.currentFloor<=floor;
        }
        return elevator.currentFloor>=floor;
    }

    @Override
    public Elevator assignElevators(List<Elevator> elevatorList, int floor) {

        int minDistance = Integer.MAX_VALUE;
        Elevator elevatorSelected = null ;

        for(Elevator elevator : elevatorList){

              if(isMovingTowards(elevator, floor)){
                  if(minDistance > Math.abs(floor - elevator.currentFloor)){
                      minDistance = Math.abs(floor - elevator.currentFloor);
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
