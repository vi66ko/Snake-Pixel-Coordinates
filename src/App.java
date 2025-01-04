import debug.Debug;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Set up debugging and print initial debugging message
        Debug.setState(true);
        Debug.trace("Main::start: Snake Pixel Coordinate");
    }
    public static void main(String[] args) throws Exception {
        launch(args);
        System.out.println("Hello, World!");
    }
}
