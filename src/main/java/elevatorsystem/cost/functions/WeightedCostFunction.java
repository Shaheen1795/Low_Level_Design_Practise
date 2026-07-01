package elevatorsystem.cost.functions;

import elevatorsystem.Elevator;
import elevatorsystem.cost.CostFunction;
import elevatorsystem.request.PickUpRequest;

public class WeightedCostFunction implements CostFunction {

    private final CostFunction etaCostFunction =
            new ETACostFunction();

    @Override
    public int calculateCost(Elevator elevator, PickUpRequest pickUpRequest) {
        if(elevator.isFull()) return Integer.MAX_VALUE;

        int eta = etaCostFunction.calculateCost(elevator, pickUpRequest);

        int loadPenalty = (elevator.currentLoad*100)/elevator.capacity;

        return eta + loadPenalty;
    }
}
