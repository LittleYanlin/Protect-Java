package Panel;
import java.awt.Graphics;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import Player.ImageGather;
import Tower.Tower;
import Tower.ArrayTower;
import Tower.MagicTower;
import Game.CardSwitcher;
public class Mission1 extends GamePanel{
    boolean isBuilding=false;
    int m=0,buildingnum=-1;
    int[] MouseMoveToTower=new int[2];
    int[] MouseMoveToBuilding=new int[2];
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
                g.drawImage(ImageGather.NullTower[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 100, this);
            }
            else if(towers[i].getTowerType()==1){
                if(towers[i].getLevel()==1){
                    g.drawImage(ImageGather.ArrayTower1[MouseMoveToTower[i]], towers[i].getX(),towers[i].getY(), 127, 176, this);
                }
                else if(towers[i].getLevel()==2){
                    g.drawImage(ImageGather.ArrayTower2[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 176, this);
                }
                else if(towers[i].getLevel()==3){
                    g.drawImage(ImageGather.ArrayTower3[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 176, this);
                }
            }
            else if(towers[i].getTowerType()==2){
                if(towers[i].getLevel()==1){
                    g.drawImage(ImageGather.MagicTower1[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 176, this);
                }
                else if(towers[i].getLevel()==2){
                    g.drawImage(ImageGather.MagicTower2[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 176, this);
                }
                else if(towers[i].getLevel()==3){
                    g.drawImage(ImageGather.MagicTower3[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 176, this);
                }
            }
        }
        if (isBuilding){
            g.drawImage(ImageGather.BuildArrayTower[MouseMoveToBuilding[0]], towers[buildingnum].getX()+130, towers[buildingnum].getY()+30, 55, 80, this);
            g.drawImage(ImageGather.BuildMagicTower[MouseMoveToBuilding[1]], towers[buildingnum].getX()+190, towers[buildingnum].getY()+30, 55, 80, this);
        }
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100){//返回按钮点击
            super.cardSwitcher.switchCard("LOADING");
        }
        boolean clickBuilding=false;
        if(isBuilding&&e.getX()>towers[buildingnum].getX()+130&&e.getX()<towers[buildingnum].getX()+185&&e.getY()>towers[buildingnum].getY()+30&&e.getY()<towers[buildingnum].getY()+110){//点击了建造按钮
            if (towers[buildingnum].getLevel()==0){
                towers[buildingnum]=new ArrayTower(towers[buildingnum].getX()+30,towers[buildingnum].getY()-76);
                towers[buildingnum].setLevel(1);
                isBuilding=false;
            }
        }if(isBuilding&&e.getX()>towers[buildingnum].getX()+190&&e.getX()<towers[buildingnum].getX()+245&&e.getY()>towers[buildingnum].getY()+30&&e.getY()<towers[buildingnum].getY()+110){//点击了建造按钮
            if (towers[buildingnum].getLevel()==0){
                towers[buildingnum]=new MagicTower(towers[buildingnum].getX()+30,towers[buildingnum].getY()-76);
                towers[buildingnum].setLevel(1);
                isBuilding=false;
            }
        }
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
    }
    void handleMouseMoved(MouseEvent e) {
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){
            m=1;
        }
        else{
            m=0;
        }
        for(int i=0;i<towers.length;i++){
            if (e.getX()>towers[i].getX()&&e.getX()<towers[i].getX()+127&&e.getY()>towers[i].getY()&&e.getY()<towers[i].getY()+(towers[i].getLevel()==0?100:176)){
                MouseMoveToTower[0]=1;
            }
            else{
                MouseMoveToTower[0]=0;
            }
        }
        if (isBuilding&&e.getX()>towers[buildingnum].getX()+130&&e.getX()<towers[buildingnum].getX()+185&&e.getY()>towers[buildingnum].getY()+30&&e.getY()<towers[buildingnum].getY()+110){//箭塔
            MouseMoveToBuilding[0]=1;
        }
        else{
            MouseMoveToBuilding[0]=0;
        }
        if (isBuilding&&e.getX()>towers[buildingnum].getX()+190&&e.getX()<towers[buildingnum].getX()+245&&e.getY()>towers[buildingnum].getY()+30&&e.getY()<towers[buildingnum].getY()+110){//箭塔
            MouseMoveToBuilding[1]=1;
        }
        else{
            MouseMoveToBuilding[1]=0;
        }
    }
}