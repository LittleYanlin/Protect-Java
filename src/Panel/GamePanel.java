package Panel;
import Game.CardSwitcher;
public class GamePanel extends Panel{
    boolean isBuilding=false,isStart=false;
    public GamePanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        gameTimer = new javax.swing.Timer(16, e -> {
            updategame();
            repaint();
        });
    }
    public void updategame(){}
}