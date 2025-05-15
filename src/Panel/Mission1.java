package Panel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import Enemy.*;
import Player.ImageGather;
import Tower.Tower;
import Tower.ArrayTower;
import Tower.MagicTower;
import Game.CardSwitcher;
import Bullet.Bullet;
public class Mission1 extends GamePanel{
    boolean isBuilding=false;
    int m=0,buildingnum=-1,MouseMoveToStartButton=0;
    int[] MouseMoveToTower=new int[2];
    int[] MouseMoveToBuilding=new int[2];
    int enemynotSpawn=0,pastSpawn=60;
    public Mission1(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        towers=new Tower[]{
            new Tower(200, 413)
        };
        map=new int[][]{//map中。右是1，下是2，左是3，上是4
            {-53,123,1},{123,123,2},{123,528,1},{421,528,4},{421,318,1},{720,318,4},{720,218,1},{1007,218,1}
        };
        enemyNum=new int[][]{
            {10}
        };
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(ImageGather.Background[0], 0, 0, 1200, 800, this);//背景图
        g.drawImage(ImageGather.Back[m],10, 10, 100, 100, this);//返回按钮
        if(isStart){
            g.drawImage(ImageGather.StartGame[2], 10, 700, 100, 90, this);//开始按钮
        }
        else{
            g.drawImage(ImageGather.StartGame[MouseMoveToStartButton], 10, 700, 100, 90, this);//开始按钮
        }
        for(int i=0;i<enemies.size();i++){//绘画小兵
            g.drawImage(ImageGather.Enemy[0],enemies.get(i).getX(),enemies.get(i).getY(),52,49,this);
        }
        for(int i=0;i<towers.length;i++){//绘画塔
            if(towers[i].getTowerType()==0){
                g.drawImage(ImageGather.NullTower[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 100, this);
            }
            else if(towers[i].getTowerType()==1){//箭塔
                Graphics2D g2 = (Graphics2D) g;
                if(towers[i].getLevel()==1){
                    g.drawImage(ImageGather.ArrayTower1[MouseMoveToTower[i]], towers[i].getX(),towers[i].getY(), 127, 176, this);
                }
                else if(towers[i].getLevel()==2){
                    g.drawImage(ImageGather.ArrayTower2[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 176, this);
                }
                else if(towers[i].getLevel()==3){
                    g.drawImage(ImageGather.ArrayTower3[MouseMoveToTower[i]], towers[i].getX(), towers[i].getY(), 127, 176, this);
                }
                if(isBuilding){
                    g2.setColor(new java.awt.Color(0, 128, 255, 80));
                    g2.fillOval(towers[i].getX()+64-towers[i].getAttackRange()/2,towers[i].getY()+88-towers[i].getAttackRange()/2,towers[i].getAttackRange(),towers[i].getAttackRange());   
                }
            }
            else if(towers[i].getTowerType()==2){//法师塔
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
        if (isBuilding){//显示建造菜单
            g.drawImage(ImageGather.BuildArrayTower[MouseMoveToBuilding[0]], towers[buildingnum].getX()+130, towers[buildingnum].getY()+30, 55, 80, this);
            g.drawImage(ImageGather.BuildMagicTower[MouseMoveToBuilding[1]], towers[buildingnum].getX()+190, towers[buildingnum].getY()+30, 55, 80, this);
        }
        for(int i=0;i<bullets.size();i++){//绘画子弹
            g.drawImage(ImageGather.Bullet[0],bullets.get(i).getX(),bullets.get(i).getY(),8,8,this);
        }
    }
    public void updategame(){
        if(!isStart){//如果游戏没有开始就跳过
            return;
        }
        if(pastSpawn<60){//设置每60ticks生成一个小兵
            pastSpawn++;
        }
        if(enemynotSpawn>0&&pastSpawn==60){//开始生成小兵并重制生成时间
            enemies.add(new Enemy(map[0][0],map[0][1]));
            enemynotSpawn--;
            pastSpawn=0;
        }
        for(int i=0;i<enemies.size();i++){//小兵移动，如果小兵到达JAVA则删除小兵并扣血
            if(!enemies.get(i).move(map[enemies.get(i).getPoint()][2],map[enemies.get(i).getPoint()+1][map[enemies.get(i).getPoint()][2]==1||map[enemies.get(i).getPoint()][2]==3?0:1],map.length)){
                enemies.remove(i);
                player.getDamage();
            }
        }
        for(int i=0;i<towers.length;i++){//如果塔已经建造了就攻击
            if(towers[i].getLevel()!=0){
                towers[i].attack(enemies,bullets);
            }
        }
        for(int i=0;i<bullets.size();i++){//子弹移动，如果子弹到达目标则删除子弹
            if(bullets.get(i).move()){
                bullets.remove(i);
            }
        }
        for(int i=0;i<enemies.size();i++){//如果小兵血量为0则删除小兵并给玩家金钱
            if(enemies.get(i).getHP()<=0){
                enemies.remove(i);
                player.getMoney(100);
            }
        }
        if(enemies.size()==0&&enemynotSpawn==0){//如果小兵全部被消灭则跳转到胜利界面
            isStart=false;
        }
        if(player.getHP()<=0){//如果玩家血量为0则跳转到失败界面
            
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
        if(!isStart&&e.getX()>10&&e.getX()<110&&e.getY()>700&&e.getY()<790){//开始按钮点击
            isStart=true;
            enemynotSpawn=enemyNum[level][0];
        }
    }
    void handleMouseMoved(MouseEvent e) {
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){
            m=1;
        }
        else{
            m=0;
        }
        for(int i=0;i<towers.length;i++){//鼠标移动到塔上
            if (e.getX()>towers[i].getX()&&e.getX()<towers[i].getX()+127&&e.getY()>towers[i].getY()&&e.getY()<towers[i].getY()+(towers[i].getLevel()==0?100:176)){
                MouseMoveToTower[0]=1;
            }
            else{
                MouseMoveToTower[0]=0;
            }
        }
        //鼠标移动到建造按钮上
        if (isBuilding&&e.getX()>towers[buildingnum].getX()+130&&e.getX()<towers[buildingnum].getX()+185&&e.getY()>towers[buildingnum].getY()+30&&e.getY()<towers[buildingnum].getY()+110){//箭塔
            MouseMoveToBuilding[0]=1;
        }
        else{
            MouseMoveToBuilding[0]=0;
        }
        //鼠标移动到建造按钮上
        if (isBuilding&&e.getX()>towers[buildingnum].getX()+190&&e.getX()<towers[buildingnum].getX()+245&&e.getY()>towers[buildingnum].getY()+30&&e.getY()<towers[buildingnum].getY()+110){//箭塔
            MouseMoveToBuilding[1]=1;
        }
        else{
            MouseMoveToBuilding[1]=0;
        }
        //鼠标移动到开始按钮上
        if(e.getX()>10&&e.getX()<110&&e.getY()>700&&e.getY()<790){//开始按钮
            MouseMoveToStartButton=1;
        }
        else{
            MouseMoveToStartButton=0;
        }
    }
}