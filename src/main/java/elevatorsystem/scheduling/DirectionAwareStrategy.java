package elevatorsystem.scheduling;

import elevatorsystem.Direction;
import elevatorsystem.Elevator;
import elevatorsystem.ElevatorState;
import elevatorsystem.SchedulingStrategy;
import elevatorsystem.cost.functions.WeightedCostFunction;
import elevatorsystem.request.PickUpRequest;


import java.util.List;

public class DirectionAwareStrategy implements SchedulingStrategy {

    WeightedCostFunction weightedCostFunction;
    public DirectionAwareStrategy(){
        weightedCostFunction = new WeightedCostFunction();
    }


    @Override
    public Elevator assignElevators(List<Elevator> elevatorList, PickUpRequest request) {

        int minDistance = Integer.MAX_VALUE;
        Elevator elevatorSelected = null ;

        for(Elevator elevator : elevatorList){
             int calculateCost = weightedCostFunction.calculateCost(elevator, request);
             if(minDistance > calculateCost){
                 minDistance = calculateCost;
                 elevatorSelected = elevator;
             }

        }

        if(elevatorSelected == null) {
            for (Elevator elevator : elevatorList) {
                if (elevator.elevatorState == ElevatorState.IDLE) return elevator;
            }
        }

        assert elevatorSelected != null;
        System.out.println("Weighted score: "+minDistance+" Selected Elevator: "+elevatorSelected.id);

        return elevatorSelected;

    }
}
