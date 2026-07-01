package elevatorsystem.ui;

import elevatorsystem.Elevator;
import elevatorsystem.ElevatorSystem;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class BuildingView extends BorderPane {

    private final ElevatorSystem system;

    private final GridPane grid = new GridPane();

    private final int FLOORS = 20;

    private final Map<Elevator, Rectangle> cars = new HashMap<>();

    public BuildingView(ElevatorSystem system) {

        this.system = system;

        createBuilding();

        setCenter(grid);
    }

    private void createBuilding() {

        grid.setHgap(20);
        grid.setVgap(4);
        grid.setAlignment(Pos.CENTER);

        // Draw floor labels
        for (int floor = FLOORS; floor >= 0; floor--) {

            Label label = new Label(String.valueOf(floor));

            grid.add(label, 0, FLOORS - floor);

            int column = 1;

            for (Elevator elevator : system.getElevators()) {

                Rectangle shaft = new Rectangle(50, 25);

                shaft.setStroke(Color.BLACK);
                shaft.setFill(Color.WHITE);

                grid.add(shaft, column++, FLOORS - floor);
            }
        }

        refresh();
    }

    public void refresh() {



        grid.getChildren().removeIf(node -> node instanceof Rectangle &&
                ((Rectangle) node).getFill() == Color.DODGERBLUE);

        int column = 1;

        for (Elevator elevator : system.getElevators()) {

            Rectangle car = new Rectangle(50,25);

            car.setFill(Color.DODGERBLUE);

            int row = FLOORS - elevator.currentFloor;

            grid.add(car,column,row);

            column++;
        }
    }

}