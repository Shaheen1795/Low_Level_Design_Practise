package parklinglot;

public class ParkingSlot {
    private final int slotNumber;
    Vehicle parkedVehicle;
    private final VehicleType supportedType;
    public ParkingSlot(int slotNumber, VehicleType supportedType){
        this.slotNumber = slotNumber;
        this.supportedType = supportedType;
    }

    public boolean isAvailable(){
        return parkedVehicle == null ;
    }

    public boolean canParkVehicle(Vehicle vehicle){
        return supportedType == vehicle.getType();
    }

    public boolean parkVehicle(Vehicle vehicle){

        if(!isAvailable() || !canParkVehicle(vehicle)){
            return false;
        }

        parkedVehicle = vehicle;

        return true ;
    }

    public void unParkVehicle(){
        parkedVehicle = null ;
    }

    public int getSlotNumber(){
        return slotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
