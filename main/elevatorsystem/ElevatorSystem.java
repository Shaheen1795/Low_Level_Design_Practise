package main.elevatorsystem;

public class ElevatorSystem {

    SchedulingStrategy schedulingStrategy;
    ElevatorSystem(SchedulingStrategy strategy){
        schedulingStrategy = strategy;
    }
}
