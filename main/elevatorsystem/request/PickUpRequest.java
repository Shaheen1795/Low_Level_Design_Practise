package main.elevatorsystem.request;

import main.elevatorsystem.Direction;

public class PickUpRequest extends Request{
    public Direction direction;
    public PickUpRequest(int f, Direction direction){
        floor = f;
        this.direction = direction;
    }
}
