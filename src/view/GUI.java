package view;


import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.canvas.Canvas;

import models.PlayableArea;
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
    private PlayableArea playableArea;
    


    public GUI(Stage primaryStage, PlayableArea playableArea, Controller controller ){
        Debug.trace("GUI::<constructor>");
        this.controller = controller;
        this.primaryStage = primaryStage;
        this.playableArea = playableArea;

        this.pane = new Pane();
        this.pane.setId("snake-pane");
        

        this.canvas = new Canvas(playableArea.getWidth(), playableArea.getHeight());
        this.pane.getChildren().add(canvas);

        this.scene = new Scene(pane, playableArea.getWidth(), playableArea.getHeight() + 100);
        this.scene.getStylesheets().add("./style.css");
        this.scene.setOnKeyPressed(this);

        this.primaryStage.setTitle("Snake Pixel Coordinate");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();

    }

    public void handle(KeyEvent event) {
        controller.userKeyInput(event);
    }


    public void drawGrid(int size){
        Group grid = new Group();
        
        for (int i = 0; i <= this.playableArea.getWidth() / size; i++) {
            Line horizontal = new Line(0, i * size + 50, this.playableArea.getWidth(), i * size + 50);
            Line vertical = new Line(i * size, 50, i * size, this.playableArea.getHeight() + 50);
            
            horizontal.setStroke(Color.rgb(150, 150, 150,  0.7));
            vertical.setStroke(Color.rgb(150, 150, 150,  0.7));
            grid.getChildren().add(horizontal);
            grid.getChildren().add(vertical);
        }
        this.pane.getChildren().add(grid);
    }
}