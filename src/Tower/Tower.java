package Tower;
import java.util.ArrayList;
import Enemy.Enemy;
import Bullet.Bullet;
/*
 * 所有的防御塔的超类，同时也是防御塔没有建造的时候的实例
 */
public class Tower{
    int x,y,level=0,attackDealy,attackRange,attackDamage,pastAttack,javax,javay;
    public Tower(int x,int y){
        this.x=x;
        this.y=y;
        level=0;
        pastAttack=0;
    }
    public int getLevel(){
        return level;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getAttackType(){
        return -1;
    }
    public void setLevel(int level){}
    public int getTowerType(){
        return 0;
    }
    public int getAttackRange(){
        return attackRange;
    }
    public double getRangeToEnemy(Enemy enemy){
        double towerCenterX=x+127.0/2;
        double towerCenterY=y+176.0/2;
        double enemyCenterX=enemy.getX()+52.0/2;
        double enemyCenterY=enemy.getY()+49.0/2;
        return Math.sqrt(Math.pow(towerCenterX-enemyCenterX,2)+Math.pow(towerCenterY-enemyCenterY,2));
    }
    public double getRangeToJava(Enemy enemy){
        return Math.sqrt(Math.pow((x-javax),2)+Math.pow((y-javay),2));
    }
    public void spawnBullet(ArrayList<Bullet> bullets, Enemy enemy){}
    public void attack(ArrayList<Enemy> enemies, ArrayList<Bullet> bullets){
        if (pastAttack < attackDealy) { // 如果攻击延迟没有到就跳过
            pastAttack++;
            return;
        }
        int minHP = Integer.MAX_VALUE;
        // 攻击逻辑：优先攻击范围内血量最少的小兵，如果有多个血量相同的小兵，则攻击离JAVA最近的小兵
        ArrayList<Enemy> enemiesSameHpMin = new ArrayList<>();
        for (int i=0;i<enemies.size();i++){
            if (getRangeToEnemy(enemies.get(i))<=attackRange/2){
                if (enemies.get(i).getHP()<minHP){
                    minHP=enemies.get(i).getHP();
                    enemiesSameHpMin.clear();
                }
                if (enemies.get(i).getHP()==minHP){
                    enemiesSameHpMin.add(enemies.get(i));
                }
            }
        }
        if (enemiesSameHpMin.size()==0) {
            // 没有敌人在范围内，不攻击，也不重置pastAttack
            return;
        }
        // 选择离塔的小兵
        int attacki = 0;
        if (enemiesSameHpMin.size()>1) {
            for (int i = 1; i < enemiesSameHpMin.size(); i++) {
                if (getRangeToJava(enemiesSameHpMin.get(i))<getRangeToJava(enemiesSameHpMin.get(attacki))){
                    attacki=i;
                }
            }
        }
        // 发射子弹
        spawnBullet(bullets, enemiesSameHpMin.get(attacki));
        pastAttack = 0;
    }
}
