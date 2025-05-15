package Panel;
import java.util.ArrayList;
import Game.CardSwitcher;
import Tower.Tower;
import Enemy.*;
import Bullet.Bullet;
import Player.Player;
public class GamePanel extends Panel{
    boolean isBuilding=false,isStart=false,canStart=true;
    int level=0;
    Tower[] towers;
    int[][] map;
    int[][] enemyNum;
    int ememyNotSpawn;
    Player player=new Player();
    ArrayList<Enemy> enemies=new ArrayList<>();
    ArrayList<Bullet> bullets=new ArrayList<>();
    public GamePanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        gameTimer = new javax.swing.Timer(16, e -> {
            updategame();
            repaint();
        });
    }
    public void updategame(){}
}