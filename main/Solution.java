package main;

import main.elevatorsystem.Elevator;
import main.parklinglot.*;
import main.tictactoe.Game;
import main.tictactoe.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] str){

        Elevator elevator = new Elevator(0);

        elevator.addStop(5);
        elevator.addStop(7);
        elevator.addStop(2);

        elevator.start();

        elevator.addStop(1);

        elevator.start();

    }
}
