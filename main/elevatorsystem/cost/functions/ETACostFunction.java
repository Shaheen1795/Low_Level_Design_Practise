package main.elevatorsystem.cost.functions;

import main.elevatorsystem.Direction;
import main.elevatorsystem.Elevator;
import main.elevatorsystem.cost.CostFunction;
import main.elevatorsystem.request.PickUpRequest;

public class ETACostFunction implements CostFunction {

    private boolean canServeOnCurrentJourney(Elevator elevator,
                                             PickUpRequest request) {

        if (elevator.direction != request.direction) {
            return false;
        }

        if (elevator.direction == Direction.UP) {
            return request.floor >= elevator.currentFloor;
        }

        return request.floor <= elevator.currentFloor;
    }

    private int etaOnCurrentJourney(Elevator elevator,
                                    PickUpRequest request) {

        return Math.abs(request.floor - elevator.currentFloor);
    }

    private int etaAfterDirectionChange(Elevator elevator,
                                        PickUpRequest request) {

        if (elevator.direction == Direction.UP) {

            int highestFloor = elevator.getMaxUpFloor();

            // current -> highest
            int upDistance =
                    highestFloor - elevator.currentFloor;

            // highest -> pickup
            int downDistance =
                    highestFloor - request.floor;

            return upDistance + downDistance;
        }

        int lowestFloor = elevator.getMinFloor();

        // current -> lowest
        int downDistance =
                elevator.currentFloor - lowestFloor;

        // lowest -> pickup
        int upDistance =
                request.floor - lowestFloor;

        return downDistance + upDistance;
    }



    @Override
    public int calculateCost(Elevator elevator, PickUpRequest pickUpRequest) {
        if(canServeOnCurrentJourney(elevator, pickUpRequest)){
            return etaOnCurrentJourney(elevator, pickUpRequest);
        }

        return etaAfterDirectionChange(elevator, pickUpRequest);
    }
}
