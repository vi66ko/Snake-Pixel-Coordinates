package models;

import java.util.ArrayList;

import debug.Debug;
import javafx.scene.paint.Color;

public class Snake extends GameObject{
    private ArrayList<GameObject> body = new ArrayList<>();
    public Snake( int size, PlayableArea playableArea) {
        super(size, Color.rgb(146, 255, 127), playableArea);
        this.setRandomPos();
    }
    public void move(PlayableArea playableArea) {
        this.setPos( this.getPosX() + this.getVelocityX(), this.getPosY() + this.getVelocityY());
        int x = (this.getPosX() + playableArea.getWidth() / this.getSize()) % (playableArea.getWidth() / this.getSize());
        int y = (this.getPosY() + playableArea.getHeight() / this.getSize()) % (playableArea.getHeight() / this.getSize());
        this.setPos(x, y);
        followHead();
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
    public void grow(){
        GameObject gameObject = new GameObject(this.getSize(), Color.rgb(146, 255, 127), this.getPlayableArea());
        gameObject.setPos(this.getPosX(), this.getPosY());
        body.add(gameObject);
    }
    private void followHead(){
        Debug.trace("Body size: " + this.body.size(), null);

        for(int i=this.body.size() - 1; i>=0; i--){

            if(i==0){
                this.body.get(i).setPos(this.getPosX(), this.getPosY());
            } else {
                GameObject previousBodyPart = this.body.get(i - 1);
                this.body.get(i).setPos(previousBodyPart.getPosX(), previousBodyPart.getPosY());
            }
        }

    }
    public ArrayList<GameObject> getBody() {
        return this.body;
    }
}
