package Panel;
import java.util.ArrayList;
import Game.CardSwitcher;
import Tower.Tower;
import Enemy.*;
public class GamePanel extends Panel{
    boolean isBuilding=false,isStart=false;
    int level=0;
    Tower[] towers;
    int[][] map;
    int[][] enemyNum;
    int ememyNotSpawn;
    ArrayList<Enemy> enemies=new ArrayList<>();
    public GamePanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        gameTimer = new javax.swing.Timer(16, e -> {
            updategame();
            repaint();
        });
    }
    public void updategame(){}
}