package Model.Pea;

import Model.Zombie.Zombie;
import View.Game.GamePanel;

import java.awt.*;

/**
 * Created by Armin on 6/28/2016.
 */
public class FreezePea extends Pea {

    public FreezePea(GamePanel parent, int lane, int startPositionX) {
        super(parent, lane, startPositionX);
    }

    @Override
    public void advance() {
        Rectangle peaRectangle = new Rectangle(getPositionX(), 130 + getMyLane() * 120, 28, 28);
        for (int i = 0; i < gamePanel.getLaneZombies().get(getMyLane()).size(); i++) {
            Zombie zombie = gamePanel.getLaneZombies().get(getMyLane()).get(i);
            Rectangle zombieRectangle = new Rectangle(zombie.getPosX(), 109 + getMyLane() * 120, 400, 120);
            if (peaRectangle.intersects(zombieRectangle)) {
                zombie.setHealth(zombie.getHealth() - 300);
                zombie.slow();
                boolean exit = false;
                if (zombie.getHealth() < 0) {
                    System.out.println("ZOMBIE DIE");
                    GamePanel.setProgress(10);
                    gamePanel.getLaneZombies().get(getMyLane()).remove(i);
                    exit = true;
                }
                gamePanel.getLanePeas().get(getMyLane()).remove(this);
                if (exit) break;
            }
        }
        /*if(posX > 2000){
            gp.lanePeas.get(myLane).remove(this);
        }*/
        setPositionX(getPositionX() - 15);
    }

}
