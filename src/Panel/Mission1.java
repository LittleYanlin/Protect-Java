package Panel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import Player.ImageGather;
import Game.CardSwitcher;
public class Mission1 extends JPanel {
    int m=0;
    CardSwitcher cardSwitcher;
    public Mission1(CardSwitcher cardSwitcher) {
        this.cardSwitcher = cardSwitcher;
        setSize(1200, 800);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                handleMouseClicked(e);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                handleMouseMoved(e);
            }
        });
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(ImageGather.Background[0], 0, 0, 1200, 800, this);
        g.drawImage(ImageGather.Back[m], 10, 10, 100, 100, this);
    }
    private void handleMouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
        if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100) {
            cardSwitcher.switchCard("LOADING");
        }
    }
    private void handleMouseMoved(MouseEvent e) {
        if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100) {
            m=1;
            repaint();
        }
        else{
            m=0;
            repaint();
        }
    }
}