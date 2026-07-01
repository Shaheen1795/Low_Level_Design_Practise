package elevatorsystem.cost;

import elevatorsystem.Elevator;
import elevatorsystem.request.PickUpRequest;

public interface CostFunction {

    int calculateCost(Elevator elevator, PickUpRequest pickUpRequest);
}
