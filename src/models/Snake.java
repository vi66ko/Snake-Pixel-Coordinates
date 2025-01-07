package models;

import javafx.scene.paint.Color;

public class Snake extends GameObject{

    public Snake( int size) {
        super(size, Color.rgb(146, 255, 127));
    }
    public void move(PlayableArea playableArea) {
        this.setPos( this.getPosX() + this.getVelocityX(), this.getPosY() + this.getVelocityY());
        int x = (this.getPosX() + playableArea.getWidth() / this.getSize()) % (playableArea.getWidth() / this.getSize());
        int y = (this.getPosY() + playableArea.getHeight() / this.getSize()) % (playableArea.getHeight() / this.getSize());
        this.setPos(x, y);
    }
}
