package main.elevatorsystem;

import java.util.List;

public interface SchedulingStrategy {

    public Elevator assignElevators(List<Elevator> elevatorList, int floor);
}
