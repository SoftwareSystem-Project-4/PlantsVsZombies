package View.Element;

/**
 * Created by Armin on 6/27/2016.
 */

public class Sun {
    private final int positionX;
    private int positionY;
    private final int endPositionY;

    private int destructTime = 200;

    public Sun(int startX, int startY, int endY) {
        this.endPositionY = endY;
        positionX = startX;
        setyPosition(startY);
    }

    public void action() {
        if (getYPosition() < getEndYPosition()) {
            move();
        }
        else{
            reduceDestructTime();
        }
    }

    public void reduceDestructTime() {
        setDestructTime(getDestructTime() - 1);
    }

    public void move() {
        setyPosition(getYPosition() + 4);
    }

    public int getXPosition(){
        return positionX;
    }
    public int getYPosition(){
        return positionY;
    }
    public int getEndYPosition() {
        return endPositionY;
    }


    public int getDestructTime() {
        return destructTime;
    }
    public void setDestructTime(int destructTime) {
        this.destructTime = destructTime;
    }

    public void setyPosition(int yPosition) {
        this.positionY = yPosition;
    }

}
