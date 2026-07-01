package elevatorsystem.request;

import elevatorsystem.Direction;

public class PickUpRequest extends Request{
    public Direction direction;
    public int users;
    public PickUpRequest(int f, Direction direction, int users){
        floor = f;
        this.direction = direction;
        this.users = users;
    }
}
