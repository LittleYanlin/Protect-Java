package Tower;
import java.util.ArrayList;
import Enemy.Enemy;
import Bullet.Bullet;
public class ArrayTower extends Tower {
    public ArrayTower(int x, int y) {
        super(x, y);
        attackDamage=30;
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
    public void spawnBullet(ArrayList<Bullet> bullets, Enemy enemy) {
        Bullet bullet=new Bullet(x, y, enemy, attackDamage, 20, getAttackType(),-1);
        bullets.add(bullet);
    }
    public void setLevel(int level){
        this.level=level;
        attackDamage=attackDamage+level*60;
        attackDealy=attackDealy-level*10;
    }
}
