package Panel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import Game.CardSwitcher;
import Tower.ArrayTower;
import Tower.MagicTower;
import Tower.Tower;
import Enemy.*;
import Bullet.Bullet;
import Player.ImageGather;
import Player.Player;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
public class GamePanel extends Panel{
    boolean isBuilding=false,isStart=false,canStart=true;
    int m=0,buildingnum=-1,MouseMoveToStartButton=0;//m是鼠标移动到返回按钮
    int enemynotSpawn=0,pastSpawn=60;
    int level=0;
    Tower[] towers;
    int[][] map;
    int[][] enemyNum;
    int ememyNotSpawn;
    Player player=new Player();
    ArrayList<Enemy> enemies=new ArrayList<>();
    ArrayList<Bullet> bullets=new ArrayList<>();
    int[] MouseMoveToTower;
    int[] MouseMoveToBuilding;
    int[][] towerUpdateMoney;
    public GamePanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        gameTimer = new javax.swing.Timer(16, e -> {
            updategame();
            repaint();
        });
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 32)); //设置字体和字号
        g.setColor(java.awt.Color.WHITE); //设置文字的颜色
        g.drawImage(ImageGather.Background[0], 0, 0, 1200, 800, this);//背景图
        g.drawImage(ImageGather.Back[m],10, 10, 100, 100, this);//返回按钮
        g.drawString(String.valueOf(player.getMoney()),450,60);//金钱
        g.drawString(String.valueOf(player.getHP()),665,60);//血量
        g.drawString("关卡："+String.valueOf(level+1),880,60);//关卡
        if(isStart){
            g.drawImage(ImageGather.StartGame[2], 10, 700, 100, 90, this);//开始按钮
        }
        else{
            g.drawImage(ImageGather.StartGame[MouseMoveToStartButton], 10, 700, 100, 90, this);//开始按钮
        }
        for(int i=0;i<enemies.size();i++){//绘画小兵并绘画小兵血条
            g.drawImage(ImageGather.Enemy[0],enemies.get(i).getX(),enemies.get(i).getY(),52,49,this);
            int red=255*(1-enemies.get(i).getHP()/enemies.get(i).getMaxHP());
            int green=255*(enemies.get(i).getHP()/enemies.get(i).getMaxHP());
            //在血量多的时候显示绿色，血量少的时候显示红色
            Color healthColor = new Color(red,green,0);
            g.setColor(healthColor);
            g.fillRect(enemies.get(i).getX(), enemies.get(i).getY()+10, 50, 5);//绘画小兵血条

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
                if(isBuilding){
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setColor(new java.awt.Color(0, 128, 255, 80));
                    g2.fillOval(towers[i].getX()+64-towers[i].getAttackRange()/2,towers[i].getY()+88-towers[i].getAttackRange()/2,towers[i].getAttackRange(),towers[i].getAttackRange());
                }
            }
        }
        if (isBuilding){//显示建造菜单
            if(towers[buildingnum].getLevel()==0){
                g.drawImage(ImageGather.BuildArrayTower[MouseMoveToBuilding[0]], towers[buildingnum].getX()+130, towers[buildingnum].getY()+30, 55, 80, this);
                g.drawImage(ImageGather.BuildMagicTower[MouseMoveToBuilding[1]], towers[buildingnum].getX()+190, towers[buildingnum].getY()+30, 55, 80, this);
            }
            else if(towers[buildingnum].getLevel()==1||towers[buildingnum].getLevel()==2){
                g.drawImage(ImageGather.Levelup[0],towers[buildingnum].getX()+130,towers[buildingnum].getY()+30, 55, 80, this);
            }
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
            enemies.add(new Enemy(map[0][0],map[0][1],100));
            enemynotSpawn--;
            pastSpawn=0;
        }
        for(int i=0;i<enemies.size();i++){//小兵移动，如果小兵到达JAVA则删除小兵并扣血
            if(!enemies.get(i).move(map[enemies.get(i).getPoint()][2],map[enemies.get(i).getPoint()+1][map[enemies.get(i).getPoint()][2]==1||map[enemies.get(i).getPoint()][2]==3?0:1],map.length)){
                enemies.remove(i);
                player.getDamage(10);
            }
        }
        for(int i=0;i<towers.length;i++){//如果塔已经建造了就攻击
            if(towers[i].getLevel()!=0){
                towers[i].attack(enemies,bullets);
            }
        }
        for(int i=0;i<bullets.size();i++){//子弹移动，如果子弹到达目标则删除子弹
            if(bullets.get(i).move()){
                if(bullets.get(i).getType()==1){//如果是箭塔的子弹
                    bullets.get(i).getTarget().getDamage(bullets.get(i).getDamage());
                }
                else if(bullets.get(i).getType()==2){//如果是法师塔的子弹，会造成范围伤害
                    for(int j=0;j<enemies.size();j++){
                        if(Math.sqrt(Math.pow((bullets.get(i).getX()-enemies.get(j).getX()),2)+Math.pow((bullets.get(i).getY()-enemies.get(j).getY()),2))<=bullets.get(i).getRange()){
                            enemies.get(i).getDamage(bullets.get(i).getDamage());
                        }
                    }
                }
                bullets.remove(i);
            }
        }
        for(int i=0;i<enemies.size();i++){//如果小兵血量为0则删除小兵并给玩家金钱
            if(enemies.get(i).getHP()<=0){
                enemies.remove(i);
                player.setMoney(100);
            }
        }
        if(enemies.size()==0&&enemynotSpawn==0){//如果小兵全部被消灭则跳转到胜利界面
            isStart=false;
            level++;
        }
        if(player.getHP()<=0){//如果玩家血量为0则跳转到失败界面
            canStart=false;
            isStart=false;
            JOptionPane.showMessageDialog(null, "你失败了！", "提示", JOptionPane.INFORMATION_MESSAGE);//弹出失败的提示框
            return;
        }
        if(level>=enemyNum.length){
            isStart=false;
            canStart=false;
            JOptionPane.showMessageDialog(null, "你胜利了！", "提示", JOptionPane.INFORMATION_MESSAGE);//弹出胜利的提示
            return;
        }
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100){//返回按钮点击
            super.cardSwitcher.switchCard("LOADING");
        }
        boolean clickBuilding=false;
        if(isBuilding&&e.getX()>towers[buildingnum].getX()+130&&e.getX()<towers[buildingnum].getX()+185&&e.getY()>towers[buildingnum].getY()+30&&e.getY()<towers[buildingnum].getY()+110){//点击了箭塔建造按钮，升级按钮也在这里
            if (towers[buildingnum].getLevel()==0){
                if(player.getMoney()<towerUpdateMoney[0][0]){
                    JOptionPane.showMessageDialog(null, "你没有足够的金钱！", "提示", JOptionPane.INFORMATION_MESSAGE);//弹出钱不够的提示框
                    return;
                }
                player.setMoney(-towerUpdateMoney[0][0]);
                towers[buildingnum]=new ArrayTower(towers[buildingnum].getX()+30,towers[buildingnum].getY()-76,1007,218);
                towers[buildingnum].setLevel(1);
                isBuilding=false;
            }
            else if(towers[buildingnum].getLevel()==1){
                if(player.getMoney()<towerUpdateMoney[towers[buildingnum].getTowerType()-1][1]){
                    JOptionPane.showMessageDialog(null, "你没有足够的金钱！", "提示", JOptionPane.INFORMATION_MESSAGE);//弹出钱不够的提示框
                    return;
                }
                player.setMoney(-towerUpdateMoney[towers[buildingnum].getTowerType()-1][1]);
                towers[buildingnum].setLevel(2);
                isBuilding=false;
            }
            else if(towers[buildingnum].getLevel()==2){
                if(player.getMoney()<towerUpdateMoney[towers[buildingnum].getTowerType()-1][2]){
                    JOptionPane.showMessageDialog(null, "你没有足够的金钱！", "提示", JOptionPane.INFORMATION_MESSAGE);//弹出钱不够的提示框
                    return;
                }
                player.setMoney(-towerUpdateMoney[towers[buildingnum].getTowerType()-1][2]);
                towers[buildingnum].setLevel(3);
                isBuilding=false;
            }
        }
        if(isBuilding&&e.getX()>towers[buildingnum].getX()+190&&e.getX()<towers[buildingnum].getX()+245&&e.getY()>towers[buildingnum].getY()+30&&e.getY()<towers[buildingnum].getY()+110){//点击了法师塔建造按钮
            if (towers[buildingnum].getLevel()==0){
                if(player.getMoney()<towerUpdateMoney[1][0]){
                    JOptionPane.showMessageDialog(null, "你没有足够的金钱！", "提示", JOptionPane.INFORMATION_MESSAGE);//弹出钱不够的提示框
                    return;
                }
                player.setMoney(-towerUpdateMoney[1][0]);
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
        if(!isStart&&canStart&&e.getX()>10&&e.getX()<110&&e.getY()>700&&e.getY()<790){//开始按钮点击
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