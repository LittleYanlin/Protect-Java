package Panel;
import Game.*;
import Tower.Tower;
/*
 * 第二关，继承自游戏面板类
 */
public class Mission3 extends GamePanel{
    public Mission3(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        missionNum=3;
        towers=new Tower[]{
            new Tower(200, 413),
            new Tower(517,486),
            new Tower(555,202)
        };
        map=new int[][]{//map中。右是1，下是2，左是3，上是4
            {-53,123,1},{123,123,2},{123,528,1},{421,528,4},{421,318,1},{720,318,4},{720,218,1},{1007,218,1}
        };
        enemyNum=new int[][]{
            {5,0,0},{8,3,0},{20,10,2}
        };
        towerUpdateMoney=new int[][]{
            {150,300,500}, // 箭塔：建造150，升级到2级300，升级到3级500
            {200,350,600}  // 魔法塔：建造200，升级到2级350，升级到3级600
        };
        MouseMoveToTower=new int[towers.length];
        MouseMoveToBuilding=new int[2];
        enemynotSpawn=new int[enemyNum.length];
    }
}