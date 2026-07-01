package elevatorsystem.ui;


import elevatorsystem.Direction;
import elevatorsystem.Elevator;
import elevatorsystem.ElevatorSystem;
import elevatorsystem.request.PickUpRequest;
import elevatorsystem.scheduling.DirectionAwareStrategy;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SimulatorApp extends Application {


    @Override
    public void start(Stage stage) {

        ElevatorSystem system =
                new ElevatorSystem(new DirectionAwareStrategy());

        system.addElevator(new Elevator(1, 10));
        system.addElevator(new Elevator(2, 13));
        system.addElevator(new Elevator(3, 14));

        BuildingView buildingView =
                new BuildingView(system);

        SimulatorController controller =
                new SimulatorController(system, buildingView);

        Scene scene = new Scene(buildingView, 900, 700);

        stage.setScene(scene);
        stage.setTitle("Elevator Simulator");
        stage.show();
        controller.startSimulation();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
