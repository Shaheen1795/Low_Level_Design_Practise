package elevatorsystem;



import elevatorsystem.elevatormode.ElevatorMode;
import elevatorsystem.elevatormode.NormalElevator;
import elevatorsystem.request.DropOffRequest;
import elevatorsystem.request.PickUpRequest;

import java.util.TreeSet;

enum DoorState{
    OPEN, CLOSE
}

public class Elevator implements  ElevatorOperations{
    public int id;
    public int currentFloor;
    public Direction direction;
    TreeSet<Integer> upRequests;
    TreeSet<Integer> downRequests;
    DoorState doorState;
    public int currentLoad;
    public ElevatorState elevatorState;
    public int capacity ;
    private ElevatorMode elevatorMode = new NormalElevator();

    public Elevator(int id, int capacity){
        this.id = id;
        currentFloor = 0 ;
        direction = Direction.UP;
        upRequests = new TreeSet<>();
        downRequests = new TreeSet<>();
        doorState = DoorState.CLOSE;
        elevatorState = ElevatorState.IDLE;
        currentLoad = 0;
        this.capacity = capacity;
    }

    public void changeMode(ElevatorMode mode){
        this.elevatorMode = mode ;
    }

    public  boolean isFull(){
        return currentLoad == capacity;
    }

    public void addQueue(int floor){
        if(direction == Direction.UP){

            if(floor > currentFloor){
                upRequests.add(floor);
            }
            else{
                downRequests.add(floor);
            }
        }
        else{
            if(floor < currentFloor){
                downRequests.add(floor);
            }
            else upRequests.add(floor);
        }

    }

    public void addStop(int floor){
        addQueue(floor);
        if(elevatorState == ElevatorState.IDLE){
            changeDirection();
            elevatorState = ElevatorState.BUSY;
            System.out.println("Elevator busy");
        }
    }

    public Integer getNextStop(){

        if(direction == Direction.UP){

            if(upRequests.isEmpty()){
                return null;
            }
            else{
                return upRequests.first();
            }
        }
        else{

            if(downRequests.isEmpty()){
                return null ;
            }
            else return downRequests.last();
        }
    }

    void changeDirection(){

        if(direction.equals(Direction.UP) && upRequests.isEmpty() && !downRequests.isEmpty()){
            direction = Direction.DOWN;
            System.out.println("Direction changed. Moving down.");
        }
        else if(direction.equals(Direction.DOWN) && downRequests.isEmpty() && !upRequests.isEmpty()){
            direction = Direction.UP;
        }
    }

    void processCurrentFloor(){

        System.out.println("Elevator stopped at "+currentFloor);

        if(direction == Direction.UP){
            upRequests.remove(currentFloor);
        }
        else downRequests.remove(currentFloor);

        if(upRequests.isEmpty() && downRequests.isEmpty()){
            System.out.println("Changing Elevator state to IDLE");
            elevatorState = ElevatorState.IDLE;
            return ;
        }
        changeDirection();

    }

    public void tick(){
        elevatorMode.tick(this);
    }

    public void addPickUpRequest(PickUpRequest pickUpRequest){
        elevatorMode.addPickupRequest(this, pickUpRequest);
    }

    public void addDropOffRequest(DropOffRequest dropOffRequest){
        elevatorMode.addDropOffRequest(this, dropOffRequest);
    }

    public  void moveOneStep(){
        Integer nextStop = getNextStop();

        if(nextStop == null){
            elevatorState = ElevatorState.IDLE;
            System.out.println("Elevator idle");
            return ;
        }
        if(currentFloor < nextStop){
            currentFloor++;
            System.out.println("CURRENT FLOOR "+currentFloor+" Elevator moving  "+direction.name()+" Elevator ID : "+id);

        }
        else if(currentFloor > nextStop){
            currentFloor--;
            System.out.println("CURRENT FLOOR "+currentFloor+" Elevator moving  "+direction.name()+" Elevator ID : "+id);
        }
        else{
            processCurrentFloor();
        }
    }

    public int getMaxUpFloor(){
        if(upRequests.isEmpty()) return -1 ;
        return upRequests.getLast();
    }

    public int getMinFloor(){
        if(downRequests.isEmpty()) return -1 ;
        return downRequests.getFirst();
    }


    @Override
    public void start() {
        while(elevatorState == ElevatorState.BUSY){
            tick();
        }
    }


    @Override
    public void stop() {

    }
}
