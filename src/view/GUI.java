package view;


import javafx.scene.input.KeyEvent;


import controller.Controller;

// interfaces
import javafx.event.EventHandler;

public class GUI implements EventHandler<KeyEvent> {
    private Controller controller;

    public GUI(Controller controller){
        this.controller = controller;
    }

    public void handle(KeyEvent event) {
        controller.userKeyInput(event);
    }
}