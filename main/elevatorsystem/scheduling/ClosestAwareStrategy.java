package main.elevatorsystem.scheduling;

import main.elevatorsystem.Elevator;
import main.elevatorsystem.SchedulingStrategy;
import main.elevatorsystem.request.PickUpRequest;

import java.util.List;

public class ClosestAwareStrategy implements SchedulingStrategy {
    @Override
    public Elevator assignElevators(List<Elevator> elevatorList, PickUpRequest request) {

        int minDistance = Integer.MAX_VALUE;
        Elevator elevatorSelected = null ;

        for(Elevator elevator : elevatorList){

            int distance = Math.abs(elevator.currentFloor - request.floor);

            if(minDistance > distance){
                minDistance = distance;
                elevatorSelected = elevator;
            }
        }

        return elevatorSelected;

    }
}
