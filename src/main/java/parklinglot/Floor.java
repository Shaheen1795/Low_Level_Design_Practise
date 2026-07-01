package parklinglot;

import java.util.List;

public class Floor {

    private final int floorNumber;
    private final List<ParkingSlot> slots;


    public Floor(int floorNumber, List<ParkingSlot> slots){
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    public ParkingSlot findAvailableParkingSlot(Vehicle vehicle){

        for(ParkingSlot slot : slots){
            if(slot.isAvailable() && slot.canParkVehicle(vehicle)){
                return  slot;
            }

        }

        return  null;
    }

    public int getFloorNumber(){
        return floorNumber;
    }

}
