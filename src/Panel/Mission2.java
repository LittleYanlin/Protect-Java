package Panel;
import Game.*;
import Tower.Tower;
/*
 * 第二关，继承自游戏面板类
 */
public class Mission2 extends GamePanel{
    public Mission2(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        missionNum=2;
        towers=new Tower[]{
            new Tower(100, 180),
            new Tower(100,580),
            new Tower(310,320),
            new Tower(490,520),
            new Tower(490,240),
            new Tower(700,320),
            new Tower(900,580),
            new Tower(900,210)
        };
        map=new int[][]{//map中。右是1，下是2，左是3，上是4
            {-53,130,1},{22,130,2},{22,423,1},{240,423,4},{240,131,1},{425,131,2},{425,528,3},{329,528,2},{329,624,1},{726,624,4},{726,532,3},
            {633,532,4},{633,126,1},{838,126,2},{838,426,1},{1033,426,4},{1033,214,1},{1125,214,2},{1128,350,2}
        };        enemyNum=new int[][]{
            {5,0,0},{8,3,0},{20,10,2},{30,20,5},{50,30,10}
        };
        towerUpdateMoney=new int[][]{
            {300,600,1000},
            {200,500,1200}
        };
        MouseMoveToTower=new int[towers.length];
        MouseMoveToBuilding=new int[2];
        enemynotSpawn=new int[enemyNum.length];
    }
}