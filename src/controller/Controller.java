package controller;



import javafx.scene.input.KeyEvent;
import models.Game;
import debug.Debug;

public class Controller {
    private Game game;
    public Controller(Game game){
        Debug.trace("Controller::<constructor>");
        this.game = game;
    }

    public void userKeyInput(KeyEvent event){
        Debug.trace("Controller::userKeyInput = " + event.getCode());
        switch (event.getCode()) {
            case UP:
                this.game.getSnake().moveUp();
                break;
            case RIGHT:
                this.game.getSnake().moveRight();
                break;
            case DOWN:
                this.game.getSnake().moveDown();
                break;
            case LEFT:
                this.game.getSnake().moveLeft();
            default:
                break;
        }

    }
}
