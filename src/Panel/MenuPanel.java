package Panel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import Player.ImageGather;
import Game.CardSwitcher;
public class MenuPanel extends JPanel {
    CardSwitcher cardSwitcher;
    int m=0,n=0;
    public MenuPanel(CardSwitcher cardSwitcher) {
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
        g.drawImage(ImageGather.LoadingBackground[0], 0, 0, 1200, 800, this);
        g.drawImage(ImageGather.Back[n], 10, 10, 100, 100, this);
        g.drawImage(ImageGather.Mission[m], 300, 510, 45, 75, this);
    }
    private void handleMouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
        if (e.getX() > 0 && e.getX() < 50 && e.getY() > 0 && e.getY() < 50) {
            cardSwitcher.switchCard("GAME");
        }
        if (e.getX() > 250 && e.getX() < 470 && e.getY() > 450 && e.getY() < 600) {
            cardSwitcher.switchCard("GAME1");
        }
    }
    private void handleMouseMoved(MouseEvent e) {
        if (e.getX() > 250 && e.getX() < 470 && e.getY() > 450 && e.getY() < 600) {
            m=1;
            repaint();
        }
        else{
            m=0;
            repaint();
        }
        if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100) {
            n=1;
            repaint();
        }
        else{
            n=0;
            repaint();
        }
    }
}