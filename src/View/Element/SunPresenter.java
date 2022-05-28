package View.Element;

import View.Game.GamePanel;
import View.Game.GameFrame;
import View.Element.Sun;
import View.Element.SunView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SunPresenter { 
    private Timer moveTimer;
    private SunView sunView;
    private Sun sun;

    public SunPresenter(SunView sunView, Sun sun){
        this.sunView = sunView;
        this.sun = sun;
        moveTimer = new Timer(60,(ActionEvent e) -> move());
    }

    public void mouseReleased(){
        sunView.remove();
    }

    public void start(){
        moveTimer.start();
    }
    
    public void move(){
        sun.action();
        setSunViewLocation();
        if(sun.getDestructTime() <= 0){
            sunView.remove();  
        }
    }

    public void setSunViewLocation(){
        sunView.setLocation(sun.getXPosition(), sun.getYPosition());
    }
}