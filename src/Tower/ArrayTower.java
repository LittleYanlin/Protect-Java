package Tower;
import java.util.ArrayList;
import Enemy.Enemy;
import Bullet.Bullet;
/*
 * 箭塔类
 * 基础伤害：40
 * 伤害增长：每级增加30
 */
public class ArrayTower extends Tower {
    public ArrayTower(int x, int y){
        super(x, y);
        attackDamage=40;
        attackDealy=60;
        pastAttack=0;
        attackRange=500;
    }
    public int getTowerType(){
        return 1;
    }
    public int getAttackType(){
        return 1;
    }
    public void spawnBullet(ArrayList<Bullet> bullets, Enemy enemy){
        Bullet bullet=new Bullet(x, y, enemy, attackDamage,20,getAttackType(),-1);
        bullets.add(bullet);
    }
    public void setLevel(int level){
        this.level=level;
        attackDamage=40+level*30;
        attackDealy=Math.max(30, 60-level*7);//不让延迟过低
    }
}
