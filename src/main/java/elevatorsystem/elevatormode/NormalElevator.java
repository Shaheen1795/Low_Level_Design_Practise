package elevatorsystem.elevatormode;

import elevatorsystem.Elevator;
import elevatorsystem.request.DropOffRequest;
import elevatorsystem.request.PickUpRequest;


import java.util.List;

public class NormalElevator implements ElevatorMode{
    @Override
    public void addPickupRequest(Elevator elevator, PickUpRequest pickUpRequest) {
        elevator.addStop(pickUpRequest.floor);
    }

    @Override
    public void addDropOffRequest(Elevator elevator, DropOffRequest dropOffRequest) {
        elevator.addStop(dropOffRequest.floor);
    }

    @Override
    public void tick(Elevator elevator) {
        elevator.moveOneStep();
    }

    @Override
    public String getName() {
        return Mode.NORMAL.name();
    }
}
