package elevatorsystem.elevatormode;

import elevatorsystem.Elevator;
import elevatorsystem.request.DropOffRequest;
import elevatorsystem.request.PickUpRequest;


public class MaintainenceElevator implements ElevatorMode{
    @Override
    public void addPickupRequest(Elevator elevator, PickUpRequest pickUpRequest) {
        System.out.println("Elevator under maintenance, cannot accept pick up request");
    }

    @Override
    public void addDropOffRequest(Elevator elevator, DropOffRequest dropOffRequest) {

        System.out.println("Elevator under maintenance, cannot accept drop off request");

    }

    @Override
    public void tick(Elevator elevator) {
        System.out.println("Elevator under maintenance");
    }

    @Override
    public String getName() {
        return "MAINTENANCE";
    }
}
