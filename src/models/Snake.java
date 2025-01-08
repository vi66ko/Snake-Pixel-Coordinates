package models;

import javafx.scene.paint.Color;

public class Snake extends GameObject{

    public Snake( int size, PlayableArea playableArea) {
        super(size, Color.rgb(146, 255, 127), playableArea);
        this.setRandomPos();
    }
    public void move(PlayableArea playableArea) {
        this.setPos( this.getPosX() + this.getVelocityX(), this.getPosY() + this.getVelocityY());
        int x = (this.getPosX() + playableArea.getWidth() / this.getSize()) % (playableArea.getWidth() / this.getSize());
        int y = (this.getPosY() + playableArea.getHeight() / this.getSize()) % (playableArea.getHeight() / this.getSize());
        this.setPos(x, y);
    }
    public void moveUp(){
        this.setVelocityY(-1);
        this.setVelocityX(0);
    }
    public void moveRight(){
        this.setVelocityX(1);
        this.setVelocityY(0);
    }
    public void moveDown(){
        this.setVelocityY(1);
        this.setVelocityX(0);
    }
    public void moveLeft(){
        this.setVelocityX(-1);
        this.setVelocityY(0);
    }
}
