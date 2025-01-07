package models;

import javafx.scene.paint.Color;

public class PlayableArea {
    private int posX = 0;
    private int posY = 0;
    private int width;
    private int height;
    private Color background = Color.rgb(91, 98, 95);
    
    public PlayableArea(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public PlayableArea(int width, int height, Color background) {
        this.background = background;
        this.width = width;
        this.height = height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getBackground() {
        return background;
    }
}
