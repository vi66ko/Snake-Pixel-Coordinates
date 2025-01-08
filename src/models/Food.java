package models;

import javafx.scene.paint.Color;

import models.PlayableArea;

public class Food extends GameObject {
    public Food(int size, PlayableArea playableArea){
        super(size, Color.rgb(255, 0, 0), playableArea);
        this.setRandomPos();
    }
    public Food(int width, int height, Color color, PlayableArea playableArea){ 
        super(width, height, color, playableArea);
        this.setRandomPos();
    }
    
}
