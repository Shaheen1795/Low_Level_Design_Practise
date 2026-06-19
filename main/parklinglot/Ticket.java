package main.parklinglot;

public class Ticket {
   private final int floorNumber;
   private final String ticketId;
   private final ParkingSlot slot;
   private final Vehicle vehicle;

   Ticket(String ticketId, ParkingSlot slot, Vehicle vehicle, int floorNumber){
       this.floorNumber = floorNumber;
       this.ticketId = ticketId;
       this.slot = slot;
       this.vehicle = vehicle;
   }


    public int getFloorNumber() {
        return floorNumber;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}