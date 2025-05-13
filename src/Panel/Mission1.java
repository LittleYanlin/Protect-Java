package Panel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import Player.ImageGather;
import Tower.Tower;
import Tower.ArrayTower;
import Game.CardSwitcher;
public class Mission1 extends GamePanel{
    boolean isBuilding=false;
    int m=0,buildingnum=-1;
    int[] MouseMoveToTower=new int[1];
    int[] MouseMoveToBuilding=new int[1];
    public Mission1(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        towers=new Tower[]{
            new Tower(200, 413)
        };
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(ImageGather.Background[0], 0, 0, 1200, 800, this);//背景图
        g.drawImage(ImageGather.Back[m], 10, 10, 100, 100, this);//返回按钮
        for(int i=0;i<towers.length;i++){
            if(towers[i].getTowerType()==0){
                g.drawImage(ImageGather.NullTower[MouseMoveToTower[0]], towers[i].getX(), towers[i].getY(), 127, 100, this);
            }
            else if(towers[i].getTowerType()==1){
                g.drawImage(ImageGather.ArrayTower[MouseMoveToTower[0]], towers[i].getX(), towers[i].getY(), 127, 100, this);
            }
        }
        if (isBuilding){
            g.drawImage(ImageGather.BuildArrayTower[MouseMoveToBuilding[0]], 877, 716, 55, 80, this);
        }
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100){//返回按钮点击
            super.cardSwitcher.switchCard("LOADING");
        }
        boolean clickBuilding=false;
        for(int i=0;i<towers.length;i++){//如果点击了塔的位置
            if (e.getX()>towers[i].getX()&&e.getX()<towers[i].getX()+127&&e.getY()>towers[i].getY()&&e.getY()<towers[i].getY()+100){
                isBuilding=true;
                buildingnum=i;
                clickBuilding=true;
                break;
            }
        }
        if(!clickBuilding){
            isBuilding=false;
            buildingnum=-1;
        }
        if(isBuilding&&e.getX()>877&&e.getX()<932&&e.getY()>716&&e.getY()<796){//点击了建造按钮
            if (towers[buildingnum].getLevel()==0){
                towers[buildingnum]=new ArrayTower(towers[buildingnum].getX(),towers[buildingnum].getY());
                towers[buildingnum].setLevel(1);
                isBuilding=false;
            }
        }
    }
    void handleMouseMoved(MouseEvent e) {
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){
            m=1;
        }
        else{
            m=0;
        }
        for(int i=0;i<towers.length;i++){
            if (e.getX()>towers[i].getX()&&e.getX()<towers[i].getX()+127&&e.getY()>towers[i].getY()&&e.getY()<towers[i].getY()+100){
                MouseMoveToTower[0]=1;
            }
            else{
                MouseMoveToTower[0]=0;
            }
        }
        if (isBuilding&&e.getX()>877&&e.getX()<932&&e.getY()>716&&e.getY()<796){//箭塔
            MouseMoveToBuilding[0]=1;
        }
        else{
            MouseMoveToBuilding[0]=0;
        }
    }
}