package main.elevatorsystem.cost;

import main.elevatorsystem.Elevator;
import main.elevatorsystem.request.PickUpRequest;

public interface CostFunction {

    int calculateCost(Elevator elevator, PickUpRequest pickUpRequest);
}
