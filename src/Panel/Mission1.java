package Panel;
import Game.*;
import Tower.Tower;
public class Mission1 extends GamePanel{
    public Mission1(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        towers=new Tower[]{
            new Tower(200, 413)
        };
        map=new int[][]{//map中。右是1，下是2，左是3，上是4
            {-53,123,1},{123,123,2},{123,528,1},{421,528,4},{421,318,1},{720,318,4},{720,218,1},{1007,218,1}
        };
        enemyNum=new int[][]{
            {10},{20},{30}
        };
        towerUpdateMoney=new int[][]{
            {100,200,300},{100,200,300}
        };
        MouseMoveToTower=new int[towers.length];
        MouseMoveToBuilding=new int[2];
    }
}