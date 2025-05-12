package Panel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import Player.ImageGather;
import Game.CardSwitcher;
public class Mission1 extends Panel{
    int m=0;
    public Mission1(CardSwitcher cardSwitcher){
        super(cardSwitcher);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(ImageGather.Background[0], 0, 0, 1200, 800, this);
        g.drawImage(ImageGather.Back[m], 10, 10, 100, 100, this);
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100){
            super.cardSwitcher.switchCard("LOADING");
        }
    }
    void handleMouseMoved(MouseEvent e) {
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){
            m=1;
            repaint();
        }
        else{
            m=0;
            repaint();
        }
    }
}