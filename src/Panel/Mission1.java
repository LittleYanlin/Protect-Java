package Panel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import Player.ImageGather;
import Game.CardSwitcher;
public class Mission1 extends GamePanel{
    boolean isBuilding=false;
    int m=0,a1=0;
    public Mission1(CardSwitcher cardSwitcher){
        super(cardSwitcher);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(ImageGather.Background[0], 0, 0, 1200, 800, this);
        g.drawImage(ImageGather.Back[m], 10, 10, 100, 100, this);
        g.drawImage(ImageGather.NullTower[a1], 200, 413, 127, 100, this);
        if (isBuilding){
            g.drawImage(ImageGather.ArrayTower[a1], 500, 500, 55, 80, this);
        }
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100){
            super.cardSwitcher.switchCard("LOADING");
        }
        if (!isBuilding&&e.getX() > 200 && e.getX() < 327 && e.getY() > 413 && e.getY() < 513){
            isBuilding=true;
        }
        else if(isBuilding&&e.getX() > 500 && e.getX() < 555 && e.getY() > 500 && e.getY() < 580){
            isBuilding=true;
        }
        else{
            isBuilding=false;
        }
    }
    void handleMouseMoved(MouseEvent e) {
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){
            m=1;
        }
        else{
            m=0;
        }
        if (!isBuilding&&e.getX()>200&&e.getX()<327&&e.getY()>413&&e.getY()<513){
            a1=1;
        }
        else{
            a1=0;
        }
    }
}