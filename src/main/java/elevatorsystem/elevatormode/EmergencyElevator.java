package elevatorsystem.elevatormode;

import elevatorsystem.Elevator;
import elevatorsystem.request.DropOffRequest;
import elevatorsystem.request.PickUpRequest;


public class EmergencyElevator implements ElevatorMode{
    @Override
    public void addPickupRequest(Elevator elevator, PickUpRequest pickUpRequest) {
        System.out.println("Cannot accept pickup request");
    }

    @Override
    public void addDropOffRequest(Elevator elevator, DropOffRequest dropOffRequest) {
        System.out.println("Cannot accept drop off request");
    }

    @Override
    public void tick(Elevator elevator) {
        while(elevator.currentFloor > 0){
            elevator.currentFloor--;
        }
    }

    @Override
    public String getName() {
        return Mode.EMERGENCY.name();
    }
}
