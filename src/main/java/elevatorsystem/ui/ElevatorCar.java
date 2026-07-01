package elevatorsystem.ui;

import elevatorsystem.Elevator;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ElevatorCar extends StackPane {

    private final Elevator elevator;

    public ElevatorCar(Elevator elevator) {

        this.elevator = elevator;

        Rectangle body = new Rectangle(55, 30);
        body.setArcHeight(8);
        body.setArcWidth(8);
        body.setFill(Color.DODGERBLUE);

        Text id = new Text(String.valueOf(elevator.id));

        getChildren().addAll(body, id);
    }

    public Elevator getElevator() {
        return elevator;
    }
}