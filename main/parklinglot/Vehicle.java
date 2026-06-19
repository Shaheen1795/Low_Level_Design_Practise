package main.parklinglot;

 enum VehicleType{
    TWOWHEELER,
    FOURWHEELER,
    SIXWHEELER

}

public class Vehicle {

    private final VehicleType type;
    private final String vehicleNumber ;

    public Vehicle(String vehicleNumber, VehicleType type){
        this.type = type ;
        this.vehicleNumber = vehicleNumber;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getType() {
        return type;
    }
}
