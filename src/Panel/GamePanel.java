package Panel;
import Game.CardSwitcher;
import Player.Tower;
public class GamePanel extends Panel{
    boolean isBuilding=false,isStart=false;
    Tower[] towers;
    public GamePanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        gameTimer = new javax.swing.Timer(16, e -> {
            updategame();
            repaint();
        });
    }
    public void updategame(){}
}