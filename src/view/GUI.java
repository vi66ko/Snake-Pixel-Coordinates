package view;


import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.PlayableArea;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;


import controller.Controller;
import debug.Debug;

// interfaces
import javafx.event.EventHandler;

public class GUI implements EventHandler<KeyEvent> {
    private Controller controller;
    
    private Stage primaryStage;
    private Scene scene;
    private Pane pane;
    private Canvas canvas;

    


    public GUI(Stage primaryStage, PlayableArea playableArea, Controller controller ){
        Debug.trace("GUI::<constructor>");
        this.controller = controller;
        this.primaryStage = primaryStage;

        this.pane = new Pane();
        this.pane.setId("snake-pane");
        

        this.canvas = new Canvas(playableArea.getWidth(), playableArea.getHeight());
        this.pane.getChildren().add(canvas);

        this.scene = new Scene(pane);
        this.scene.getStylesheets().add("./style.css");
        this.scene.setOnKeyPressed(this);

        this.primaryStage.setTitle("Snake Pixel Coordinate");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();

    }

    public void handle(KeyEvent event) {
        controller.userKeyInput(event);
    }
}