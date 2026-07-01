package elevatorsystem.elevatormode;

import elevatorsystem.Elevator;
import elevatorsystem.request.DropOffRequest;
import elevatorsystem.request.PickUpRequest;


import java.util.List;

public interface ElevatorMode {

    void addPickupRequest(Elevator elevator, PickUpRequest pickUpRequest);

    void addDropOffRequest(Elevator elevator, DropOffRequest dropOffRequest);

    void tick(Elevator elevator);

    String getName();
}
