package View.Element;

import View.Game.GamePanel;
import View.Element.SunPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SunView extends JPanel {
    private Image sunImage;

    public SunView(int x, int y){
        setSize(80, 80);
        setOpaque(false);
        setLocation(x,y);
        sunImage = new ImageIcon(this.getClass().getResource("../../images/sun.png")).getImage();
    }

    public void init(SunPresenter sunPresenter){
        bindTo(sunPresenter);
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(sunImage,0,0,null);
    }

    private void bindTo(final SunPresenter p){
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                p.mouseReleased();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void remove(){
        GamePanel.getInstance().remove(this);
    }
}