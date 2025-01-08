package models;

import debug.Debug;
import javafx.application.Platform;
import javafx.stage.Stage;
import states.GameState;
import view.GUI;
import controller.Controller;
public class Game {
    private GUI gui;
    private Controller controller;
    private PlayableArea playableArea;
    private GameState gameState = GameState.PLAYING;
    private int gridSize = 100;
    private Snake snake;
    private Food food;
    private int score = 0;
    private int canvasOffset = 100;
    public Game(Stage primaryStage) {
        Debug.trace("Game::<constructor>");
        this.playableArea = new PlayableArea(600, 600);
        this.controller = new Controller(this); // create the controller and passing the game instance
        this.gui = new GUI(primaryStage, this.playableArea, this.controller, this.canvasOffset);
        

        this.gameSetup();
        
        this.startGame(); 
    }

    private void startGame(){
        Thread t = new Thread(this::gameLoop);
        t.setDaemon(true);
        t.start();
    }
    public void gameLoop(){
        try {
            Debug.trace("Game::GameLoop: Game Loop Started");
            while(gameState == GameState.PLAYING){
                // Debug.trace("Game::GameLoop: Inside Game Loop");
    
                this.updateModels();
                Platform.runLater(this::updateGUI);
                Thread.sleep( 300);
            }
            Debug.trace("Game::GameLoop: Game Loop Stopped");
        } catch (Exception e){
            Debug.trace("Game::runAsSeparateThread Error: " + e.getMessage());
        }
    }

    private void gameSetup(){
        this.food = new Food(this.gridSize, playableArea);
        this.snake = new Snake(this.gridSize, playableArea);
        
        gui.drawCoordinates(food);
        Debug.trace("Coordinates: X=" + this.food.getPosX() + " Y=" + this.food.getPosY());
        gui.drawGrid(this.gridSize);
        gui.drawScores(0);
        gui.drawSnake(snake);
        gui.drawFood(food);

    }
    private void updateModels(){
        hasSnakeEatenFood(snake, food);
        this.snake.move(playableArea);
        //Debug.trace("Snake::move: \n x =" + snake.getPosX() + ", y =" + snake.getPosY() );
    }
    private synchronized void updateGUI(){
        
        gui.paintCanvas();
        gui.updateCoordinates(food);
        gui.updateScores(this.score);
        gui.drawFood(food);
        gui.drawSnake(snake);

    }

    public Snake getSnake() {
        return this.snake;
    }

    private boolean hasCollisionOccurred(GameObject gameObject, GameObject gameObject2){
        if (gameObject.getPosX() == gameObject2.getPosX() && gameObject.getPosY() == gameObject2.getPosY()) {
            return true;
        }
        return false;
    }

    public boolean hasSnakeEatenFood(Snake snake, Food food){
        if (hasCollisionOccurred(snake, food)){
            this.food.setRandomPos();
            this.score += 1;
            this.snake.grow();
            return true;
        }
        return false;
    }

    
}
