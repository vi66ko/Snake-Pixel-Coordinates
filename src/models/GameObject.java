package models;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;

public class GameObject {
   private static int numOfInstance = 0;
   private static ArrayList<GameObject> instances = new ArrayList<>();

   private int size = 25; // Adding default size of the object
   private int posX, postY;
   private int width = this.size;
   private int height = this.size;
   private Color color;
   private int velocityX = 0;
   private int velocityY = 0;
   private int speed = 1;
   private PlayableArea playableArea;

    public GameObject( int size, Color color, PlayableArea playableArea) {
      this.setPlayableArea(playableArea);
      this.setSize(size);;
      this.setWidth(size);
      this.setHeight(size);
      this.setColor(color);
      GameObject.addInstance(this);
    }

    public GameObject(int width, int height, Color color, PlayableArea playableArea) {
      this.setPlayableArea(playableArea);
      this.setSize(width);
      this.setWidth(width);
      this.setHeight(height);
      this.setColor(color);
      GameObject.addInstance(this);
    }
    public PlayableArea getPlayableArea() { 
      return this.playableArea; 
    }
    public void setPlayableArea(PlayableArea playableArea) {
      this.playableArea = playableArea;
    }
    public void setPos(int x, int y){
      this.posX = x;
      this.postY = y;
    }
    public int getPosX() {
      return this.posX;
    }

    public void setPosX(int posX) { 
      this.posX = posX;
    }

    public int getPosY() {
      return this.postY;
    }

    public void setPosY(int postY) {
      this.postY = postY;
    }
    public int getSize() {
      return this.size;
    }
    public void setSize(int size){
      this.size = size;
    }
    public int getWidth() {
      return this.width;
    }

    public void setWidth(int width) {
      this.width = width;
    }

    public int getHeight() {
      return this.height;
    }

    public void setHeight(int height) {
      this.height = height;
    }
    public Color getColor() {
      return this.color;
    }

    public void setColor(Color color) {
      this.color = color;
    }

    public int getVelocityX() {
      return this.velocityX;
    }

    public void setVelocityX(int velocityX) {    
      this.velocityX = velocityX;
    }

    public int getVelocityY() {
      return this.velocityY;
    }

    public void setVelocityY(int velocityY) {
      this.velocityY = velocityY;
    }

    public int getSpeed() {
      return this.speed;
    }

    public void setSpeed(int speed) {    
      this.speed = speed;
    }

    private static void addInstance(GameObject instance) {
      GameObject.instances.add(instance);
      GameObject.numOfInstance++;
    }

    public void setRandomPos() {
        Random random = new Random();
        int x = random.nextInt(this.getPlayableArea().getWidth() / this.getWidth());
        int y = random.nextInt(this.getPlayableArea().getHeight() / this.getHeight());

        this.setPos(x, y);
    }
}
