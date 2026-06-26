package main;

import main.elevatorsystem.Direction;
import main.elevatorsystem.Elevator;
import main.elevatorsystem.ElevatorSystem;
import main.elevatorsystem.request.DropOffRequest;
import main.elevatorsystem.request.PickUpRequest;
import main.elevatorsystem.scheduling.DirectionAwareStrategy;


public class Solution {

    public static void main(String[] str){

        ElevatorSystem system =
                new ElevatorSystem(
                        new DirectionAwareStrategy()
                );


        Elevator e1 = new Elevator(1, 15);
        Elevator e2 = new Elevator(2, 16);


        system.addElevator(e1);
        system.addElevator(e2);


        // External request
        system.assignPickUpRequest(
                new PickUpRequest(
                        7,
                        Direction.DOWN, 1
                )
        );


        // simulate passenger entering e1
        system.assignDropOffRequest(e1,
                new DropOffRequest(0)
        );


        e1.start();

    }
}
