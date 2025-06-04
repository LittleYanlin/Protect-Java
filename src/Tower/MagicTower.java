package Tower;
import java.util.ArrayList;
import Enemy.Enemy;
import Bullet.Bullet;
/*
 * 法师塔类
 * 基础伤害：35
 * 伤害增长：每级增加25
 */
public class MagicTower extends Tower{
    public MagicTower(int x,int y){
        super(x,y);
        attackDamage=35;
        attackDealy=100;
        pastAttack=0;
        attackRange=350;
    }
    public int getTowerType(){
        return 2;
    }
    public int getAttackType(){
        return 2;
    }
    public void spawnBullet(ArrayList<Bullet> bullets, Enemy enemy) {
        Bullet bullet=new Bullet(x+63,y,enemy,attackDamage,10,getAttackType(),80+level*20);
        bullets.add(bullet);
    }
    public void setLevel(int level){
        this.level=level;
        attackDamage=35+level*25;
        attackDealy=Math.max(40,100-level*10);//不让延迟过低
    }
}