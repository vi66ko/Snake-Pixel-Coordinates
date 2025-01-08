package view;


import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import models.Food;
import models.GameObject;
import models.PlayableArea;
import models.Snake;
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
    private GraphicsContext graphicsContext;
    
    // Game details    
    private PlayableArea playableArea;
    private Label scores;
    private Label coordinates;
    private int canvasOffset;

    public GUI(Stage primaryStage, PlayableArea playableArea, Controller controller, int canvasOffset){
        Debug.trace("GUI::<constructor>");
        this.controller = controller;
        this.primaryStage = primaryStage;
        this.playableArea = playableArea;
        this.canvasOffset = canvasOffset;
        this.pane = new Pane();
        this.pane.setId("snake-pane");
        
        
        this.canvas = new Canvas(playableArea.getWidth(), playableArea.getHeight());
        this.canvas.setLayoutY(canvasOffset);
        this.canvas.setLayoutX(50);
        this.graphicsContext = canvas.getGraphicsContext2D();

        this.paintCanvas();

        this.pane.getChildren().add(canvas);

        this.scene = new Scene(pane, playableArea.getWidth() + 100, playableArea.getHeight() + 200);
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
            Label horizontalLegend = new Label(String.valueOf(i));
            horizontalLegend.setId("grid-legend");
            Label verticalLegend = new Label(String.valueOf(i));
            verticalLegend.setId("grid-legend");

            Debug.trace("" +((i == 0) ? size / 2 : size * i + size / 2));

            Line horizontal = new Line(50, i * size + this.canvasOffset, this.playableArea.getWidth() +50, i * size + this.canvasOffset);
            Line vertical = new Line(i * size + 50 , this.canvasOffset, i * size + 50, this.playableArea.getHeight() + this.canvasOffset);
            
            horizontal.setStroke(Color.rgb(150, 150, 150,  0.7));
            vertical.setStroke(Color.rgb(150, 150, 150,  0.7));
            grid.getChildren().add(horizontal);
            grid.getChildren().add(vertical);

            if( i < this.playableArea.getHeight() / size) {
                horizontalLegend.setTranslateX( size * i + 50 + size / 2);
                horizontalLegend.setTranslateY(40);
    
                verticalLegend.setTranslateX(20);
                verticalLegend.setTranslateY( size * i + 70 + size / 2);
                //horizontalLegend.setTranslateX(50 + ((i == 0) ? size / 2 : size * i));
                //verticalLegend.setTranslateY((i == 0) ? size / 2 : size * i); WHY DOES NOT WORK ???           grid.getChildren().add(horizontalLegend);

                grid.getChildren().add(horizontalLegend);
                grid.getChildren().add(verticalLegend);
            }
        }
        this.pane.getChildren().add(grid);
        
    }
    public void drawScores(int value){
        this.scores = new Label("Score: " + value);
        this.scores.setId("info-text");
        this.scores.setTranslateX(20);
        this.scores.setTranslateY(10);
        this.pane.getChildren().add(scores);
    }
    public void updateScores(int value){
        this.scores.setText("Score: " + value);
    }
    public void paintCanvas(){
        this.graphicsContext.setFill(playableArea.getBackground());
        this.graphicsContext.fillRect(playableArea.getPosX(), playableArea.getPosY(), playableArea.getWidth(), playableArea.getHeight());
    }

    public void drawSnake(Snake snake){
        this.drawRectangularGameObject(snake);
        
        for (GameObject gameObject : snake.getBody()) {
            this.drawRectangularGameObject(gameObject);
        }
    }
    public void drawFood(Food food){
        this.drawRectangularGameObject(food);
    }
    public void drawRectangularGameObject(GameObject gameObject){
        this.graphicsContext.setFill(gameObject.getColor());
        this.graphicsContext.fillRect(gameObject.getPosX() * gameObject.getSize(), gameObject.getPosY() * gameObject.getSize(), gameObject.getWidth(), gameObject.getHeight());
    }

    public void drawCoordinates(GameObject gameObject){
        Debug.trace("drawCoordinates: is running");
        this.coordinates = new Label("Coordinates:                 X = " + gameObject.getPosX() + "       Y = "+ gameObject.getPosY() );
        this.coordinates.setId("coordinates");
        this.coordinates.setTranslateX(100);
        Debug.trace("PlayableArea: " + playableArea.getHeight());
        this.coordinates.setTranslateY(this.canvasOffset + this.playableArea.getHeight() + 10);
        this.pane.getChildren().add(this.coordinates);
    }
    public void updateCoordinates(GameObject gameObject){
        this.coordinates.setText("Coordinates:                 X = " + gameObject.getPosX() + "       Y = "+ gameObject.getPosY() );
    }

}