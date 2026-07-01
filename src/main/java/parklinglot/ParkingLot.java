package parklinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {

    private final List<Floor> floors;
    private final Map<String, Ticket> activeTickets;
    public ParkingLot(List<Floor> floors){
        this.floors = floors;
        this.activeTickets = new HashMap<>();

    }

    public Ticket parkVehicle(Vehicle vehicle){

        for(Floor floor: floors){

            ParkingSlot slot = floor.findAvailableParkingSlot(vehicle);
            if(slot!=null){
                slot.parkVehicle(vehicle);
                Ticket ticket = new Ticket(
                        UUID.randomUUID().toString(),
                        slot,
                        vehicle,
                        floor.getFloorNumber()
                );
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }

        }

        return null ;

    }

    public boolean unParkVehicle(String ticketId){

        if(!activeTickets.containsKey(ticketId)){
            return false;
        }
        Ticket ticket = activeTickets.get(ticketId);
        ticket.getSlot().unParkVehicle();
        activeTickets.remove(ticketId);
        return true ;
    }

}
