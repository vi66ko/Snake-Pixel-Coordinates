package models;

import debug.Debug;
import javafx.stage.Stage;

import view.GUI;
import controller.Controller;
public class Game {
    private GUI gui;
    private Controller controller;
    private PlayableArea playableArea;
    private GameState gameState = GameState.PLAYING;

    public Game(Stage primaryStage) {
        Debug.trace("Game::<constructor>");
        this.playableArea = new PlayableArea(600, 600);
        this.controller = new Controller(this); // create the controller and passing the game instance
        this.gui = new GUI(primaryStage, this.playableArea, this.controller);
        
        
        gameSetup();
        
        
    }
    public void GameLoop(){
        try {
            Debug.trace("Game::GameLoop: Game Loop Started");
            while(gameState == GameState.PLAYING){
                // updating the graphics
                // updating the models
                Thread.sleep( 100);
            }
            Debug.trace("Game::GameLoop: Game Loop Stopped");
        } catch (Exception e){
            Debug.trace("Game::runAsSeparateThread Error: " + e.getMessage());
        }
    }

    private void gameSetup(){
        gui.drawGrid(100);
        gui.drawScores(0);
    }

    
}
