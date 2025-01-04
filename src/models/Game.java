package models;

import debug.Debug;
import javafx.stage.Stage;

import view.GUI;
import controller.Controller;

public class Game {
    private GUI gui;
    private Controller controller;

    public Game(Stage primaryStage) {
        Debug.trace("Game::<constructor>");
        this.controller = new Controller();

        this.gui = new GUI(primaryStage, this.controller);

    }
}
