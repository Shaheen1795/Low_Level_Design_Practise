package main.elevatorsystem.scheduling;

import main.elevatorsystem.Elevator;
import main.elevatorsystem.SchedulingStrategy;

import java.util.List;

public class ClosestAwareStrategy implements SchedulingStrategy {
    @Override
    public Elevator assignElevators(List<Elevator> elevatorList, int floor) {

        int minDistance = Integer.MAX_VALUE;
        Elevator elevatorSelected = null ;

        for(Elevator elevator : elevatorList){

            int distance = Math.abs(elevator.currentFloor - floor);

            if(minDistance > distance){
                minDistance = distance;
                elevatorSelected = elevator;
            }
        }

        return elevatorSelected;

    }
}
