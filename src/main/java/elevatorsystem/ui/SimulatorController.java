package elevatorsystem.ui;

import elevatorsystem.Direction;
import elevatorsystem.Elevator;
import elevatorsystem.ElevatorSystem;
import elevatorsystem.request.DropOffRequest;
import elevatorsystem.request.PickUpRequest;
import elevatorsystem.ui.BuildingView;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SimulatorController {

    private final ElevatorSystem elevatorSystem;
    private final BuildingView buildingView;

    private Timeline timeline;
    int time = 0;
    Elevator E1 = null ;
    Elevator E2;
    Elevator E3;


    public SimulatorController(ElevatorSystem elevatorSystem,
                               BuildingView buildingView) {

        this.elevatorSystem = elevatorSystem;
        this.buildingView = buildingView;

        timeline = new Timeline(

                new KeyFrame(
                        Duration.millis(50),
                        e -> {

                            buildingView.refresh();

                        }
                ),

                new KeyFrame(
                        Duration.seconds(1),
                        e -> {

                            elevatorSystem.tick();

                        }
                )

        );

        timeline.setCycleCount(Animation.INDEFINITE);
    }

    void startSimulation(){


        Timeline timeline =
                new Timeline(


                        new KeyFrame(
                                Duration.seconds(0.5),

                                e->{


                                    time++;


                                    simulateRequests();



                                    elevatorSystem.tick();



                                    buildingView.refresh();


                                }

                        )

                );



        timeline.setCycleCount(
                Animation.INDEFINITE
        );



        timeline.play();

    }



    private void simulateRequests(){

        // passenger arrives at floor 3

        if(time == 4){

            System.out.println("Pickup request at floor 14");
            E1 = elevatorSystem.assignPickUpRequest(new PickUpRequest(14, Direction.DOWN, 1));
        }

        if(time == 12){
            if(E1!=null){
                System.out.println("ADDED DROP OFF REQUEST FOR "+E1.id);
                elevatorSystem.assignDropOffRequest(E1, new DropOffRequest(2));
            }
        }
        if(time ==15){

            E2 = elevatorSystem.assignPickUpRequest(new PickUpRequest(7, Direction.UP, 1));
        }
        if(time == 17){
            E3 = elevatorSystem.assignPickUpRequest(new PickUpRequest(1, Direction.UP, 1));
        }

        if(time == 20){

            if(E2!=null){
                System.out.println("ADDED DROP OFF REQUEST FOR "+E2.id);
                elevatorSystem.assignDropOffRequest(E2, new DropOffRequest(14));
            }
        }
        if(time == 25){
            if(E3!=null){
                System.out.println("ADDED DROP OFF REQUEST FOR "+E3.id);
                elevatorSystem.assignDropOffRequest(E3, new DropOffRequest(7));
            }
        }

        if(time == 45){
            stopSimulation();
        }

    }


    public void pauseSimulation() {
        timeline.pause();
    }

    public void stopSimulation() {
        timeline.stop();
    }

    public void requestElevator(int floor, Direction direction) {
        elevatorSystem.assignPickUpRequest(
                new PickUpRequest(floor, direction, 1)
        );
    }

    public void addDropOffRequest(Elevator elevator, int floor) {

        DropOffRequest request =
                new DropOffRequest(floor);

        elevatorSystem.assignDropOffRequest(elevator, request);
    }

}