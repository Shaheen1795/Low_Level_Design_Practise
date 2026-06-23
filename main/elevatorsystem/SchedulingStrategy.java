package main.elevatorsystem;

import main.elevatorsystem.request.PickUpRequest;

import java.util.List;

public interface SchedulingStrategy {

    public Elevator assignElevators(List<Elevator> elevatorList, PickUpRequest request);
}
