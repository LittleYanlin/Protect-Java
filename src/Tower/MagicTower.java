package Tower;
import java.util.ArrayList;
import Enemy.Enemy;
import Bullet.Bullet;
public class MagicTower extends Tower{
    public MagicTower(int x,int y){
        super(x,y);
        attackDamage=20;
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
        Bullet bullet=new Bullet(x, y, enemy, attackDamage, 10, getAttackType(),100+level*10);
        bullets.add(bullet);
    }
    public void setLevel(int level){
        this.level=level;
        attackDamage=attackDamage+level*50;
        attackDealy=attackDealy-level*15;
    }
}