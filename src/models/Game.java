package models;

import debug.Debug;
import javafx.stage.Stage;

import view.GUI;
import controller.Controller;

public class Game {
    private GUI gui;
    private Controller controller;
    private PlayableArea playableArea;

    public Game(Stage primaryStage) {
        Debug.trace("Game::<constructor>");
        this.playableArea = new PlayableArea(600, 600);
        this.controller = new Controller(this); // create the controller and passing the game instance
        this.gui = new GUI(primaryStage, this.playableArea, this.controller);

    }
}
