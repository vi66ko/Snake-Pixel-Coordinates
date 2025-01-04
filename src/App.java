
import javafx.application.Application;
import javafx.stage.Stage;

import debug.Debug;
import models.Game;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Set up debugging and print initial debugging message
        Debug.setState(true);
        Debug.trace("Main::start: Snake Pixel Coordinate");

        new Game(primaryStage);
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
