package controller;



import javafx.scene.input.KeyEvent;

import debug.Debug;

public class Controller {
    public Controller(){
        Debug.trace("Controller::<constructor>");
    }

    public void userKeyInput(KeyEvent event){
        Debug.trace("Controller::userKeyInput = " + event.getCode());

    }
}
