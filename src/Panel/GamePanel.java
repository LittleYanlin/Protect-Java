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
/*
 * 游戏面板类
 * 实现了游戏的底层逻辑
 * 是所有关卡类的超类
 */
public class GamePanel extends Panel{
    boolean isBuilding=false,isStart=false,canStart=true,isLocking=false,isAttacking=false,attack=false,lock=false;
    int m=0,buildingnum=-1,MouseMoveToStartButton=0,MouseMoveToLock=0,MouseMoveToAttack=0;//m是鼠标移动到返回按钮
    int pastSpawn=60;
    int[] enemynotSpawn;
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
    int missionNum;
    int attackButtonRange=120;
    int lockButtonRange=100;
    int mouseX=0,mouseY=0;
    public GamePanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        gameTimer = new javax.swing.Timer(16,e->{//重写了计时器，因为在游戏面板里还需要更新游戏的方法
            updategame();
            repaint();
        });
    }
    public void paint(Graphics g){
        try{
            super.paint(g);
            g.setFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 32)); //设置字体和字号
            g.setColor(java.awt.Color.WHITE); //设置文字的颜色
            g.drawImage(ImageGather.Background[missionNum-1], 0, 0, 1200, 800, this);//背景图
            g.drawImage(ImageGather.Back[m],10, 10, 100, 100, this);//返回按钮
            g.drawImage(ImageGather.LockButton[MouseMoveToLock],37,678,75,85,this);
            g.drawImage(ImageGather.AttackButton[MouseMoveToAttack],120,678,75,85,this);
            g.drawString(String.valueOf(player.getMoney()),450,60);//金钱
            g.drawString(String.valueOf(player.getHP()),665,60);//血量
            g.drawString("波次："+String.valueOf(level+1),880,60);//关卡
            if(isStart){
                g.drawImage(ImageGather.StartGame[2], 10, 700, 100, 90, this);//开始按钮
            }
            else{
                g.drawImage(ImageGather.StartGame[MouseMoveToStartButton], 10, 700, 100, 90, this);//开始按钮
            }
            for(int i=0;i<enemies.size();i++){//遍历敌人
                g.drawImage(ImageGather.Enemy[enemies.get(i).getType()],enemies.get(i).getX(),enemies.get(i).getY(),52,49,this);//绘画小兵
                double percent=enemies.get(i).getHP()*1.0/enemies.get(i).getMaxHP();//计算血量百分比
                int barWidth = (int)(50*percent);//计算血条长度
                Color healthColor=new Color(255, 0, 0);//设置血条颜色
                g.setColor(healthColor);
                g.fillRect(enemies.get(i).getX(),enemies.get(i).getY()-10, barWidth, 5);//绘制血条
                g.setColor(Color.BLACK);
                g.drawRect(enemies.get(i).getX(),enemies.get(i).getY()-10, 50, 5);//绘制血条边框
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
                    if(isBuilding&&buildingnum==i){
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
                    if(isBuilding&&buildingnum==i){
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
            if(isLocking){
                Graphics2D g2=(Graphics2D) g;
                g2.setColor(new java.awt.Color(0, 128, 255, 80));
                g2.fillOval(mouseX, mouseY, lockButtonRange, lockButtonRange);
            }
            if(isAttacking){
                Graphics2D g2=(Graphics2D) g;
                g2.setColor(new java.awt.Color(0, 128, 255, 80));
                g2.fillOval(mouseX, mouseY, attackButtonRange, attackButtonRange);
            }

        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null,"绘画游戏画面时出现错误！错误详情："+e.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updategame(){
        try{
            if(!isStart){//如果游戏没有开始就跳过
                return;
            }
            if(pastSpawn<60-level*10){//设置每60ticks生成一个小兵，随等级增加而减少
                pastSpawn++;
            }
            if(enemiesNotSpawnSum()>enemynotSpawn[2]&&pastSpawn==60-level*10){//开始生成小兵并重制生成时间
                if(enemynotSpawn[0]>0){
                    enemies.add(new XiaoBing(map[0][0],map[0][1],level));
                    enemynotSpawn[0]--;
                }
                if(enemynotSpawn[1]>0){
                    enemies.add(new PaoChe(map[0][0]-50,map[0][1],level));
                    enemynotSpawn[1]--;
                }
                pastSpawn=0;
            }
            else if(enemiesNotSpawnSum()<=enemynotSpawn[2]&&pastSpawn==60-level*10&&enemiesNotSpawnSum()>0){//在关卡的最后生成Boss
                if(enemynotSpawn[2]>0){
                    enemies.add(new Boss(map[0][0]-100,map[0][1],level));
                    enemynotSpawn[2]--;
                }
                pastSpawn=0;
            }
            for(int i=0;i<enemies.size();i++){//小兵移动，如果小兵到达JAVA则删除小兵并扣血
                if(attack){
                    double r=Math.sqrt(Math.pow(enemies.get(i).getX()-mouseX,2)+Math.pow(enemies.get(i).getY()-mouseY,2));
                        if(r<attackButtonRange){
                            enemies.get(i).getDamage(1000);
                        }
                }
                if(lock){
                    double r=Math.sqrt(Math.pow(enemies.get(i).getX()-mouseX,2)+Math.pow(enemies.get(i).getY()-mouseY,2));
                        if(r<attackButtonRange){
                            enemies.get(i).setLock(120);
                        }
                }
                if(!enemies.get(i).move(map[enemies.get(i).getPoint()][2],map[enemies.get(i).getPoint()+1][map[enemies.get(i).getPoint()][2]==1||map[enemies.get(i).getPoint()][2]==3?0:1],map.length)){
                    enemies.remove(i);
                    player.getDamage(10);
                }
            }
            if(attack){attack=false;}//只完成一次范围攻击
            if(lock){lock=false;}//只完成一次冻结
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
                            double range=Math.sqrt(Math.pow((bullets.get(i).getX()-enemies.get(j).getX()),2)+Math.pow((bullets.get(i).getY()-enemies.get(j).getY()),2));
                            if(range<=bullets.get(i).getRange()){
                                enemies.get(j).getDamage((int)(bullets.get(i).getDamage()*(1-range/bullets.get(i).getRange())));//随着距离的增加，伤害减少
                            }
                        }
                    }
                    bullets.remove(i);
                }
            }
            for(int i=0;i<enemies.size();i++){//如果小兵血量为0则删除小兵并给玩家金钱
                if(enemies.get(i).getHP()<=0){
                    int reward=100; // 默认奖励（如果出现未知bug）
                    if(enemies.get(i).getType()==0){//如果击杀的是小兵
                        reward=80;//小兵击杀奖励
                    } else if(enemies.get(i).getType()==1){//如果击杀的是炮车
                        reward=120;//炮车击杀奖励
                    } else if(enemies.get(i).getType()==2){//如果击杀的是Boss
                        reward=300; //Boss击杀奖励
                    }
                    player.setMoney(reward);
                    enemies.remove(i);
                    i--; // 修正索引，避免跳过下一个敌人
                }
            }
            if(enemies.size()==0&&enemiesNotSpawnSum()==0){//如果小兵全部被消灭则跳转到胜利界面
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
        catch(Exception e){
            JOptionPane.showConfirmDialog(null,"更新游戏状态时发生错误！错误详情："+e.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
        }
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){//返回按钮点击
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
                towers[buildingnum]=new ArrayTower(towers[buildingnum].getX(),towers[buildingnum].getY()-76);
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
                towers[buildingnum]=new MagicTower(towers[buildingnum].getX(),towers[buildingnum].getY()-76);
                towers[buildingnum].setLevel(1);
                isBuilding=false;
            }
        }
        for(int i=0;i<towers.length;i++){//如果点击了塔的位置
            if (e.getX()>towers[i].getX()&&e.getX()<towers[i].getX()+127&&e.getY()>towers[i].getY()&&e.getY()<towers[i].getY()+(towers[i].getLevel()==0?100:176)){
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
            for(int i=0;i<enemyNum[0].length;i++){
                enemynotSpawn[i]=enemyNum[level][i];
            }
            pastSpawn=0;
        }
        if(isAttacking&&isStart){//这里要加上取消按钮的坐标（不在）
            attack=true;
        }
        if(isLocking&&isStart){//这里也要加上取消按钮的坐标（不在）
            lock=true;
        }
        if(!isAttacking&&isStart){//这里要加上点击范围攻击按钮
            isAttacking=true;
        }
        else{
            isAttacking=false;
        }
        if(!isLocking&&isStart){//这里要加上点击冰冻按钮的坐标
            isLocking=true;
        }
        else{
            isLocking=false;
        }
    }
    void handleMouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){
            m=1;
        }
        else{
            m=0;
        }
        for(int i=0;i<towers.length;i++){//鼠标移动到塔上
            if (e.getX()>towers[i].getX()&&e.getX()<towers[i].getX()+127&&e.getY()>towers[i].getY()&&e.getY()<towers[i].getY()+(towers[i].getLevel()==0?100:176)){
                MouseMoveToTower[i]=1;
            }
            else{
                MouseMoveToTower[i]=0;
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
    public int enemiesNotSpawnSum(){
        int sum=0;
        for(int i=0;i<enemynotSpawn.length;i++){
            sum+=enemynotSpawn[i];
        }
        return sum;
    }
}