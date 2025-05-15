package Tower;
import java.util.ArrayList;
import Enemy.Enemy;
import Bullet.Bullet;
public class Tower {
    int x,y,level=0,attackDealy,attackRange,attackDamage,pastAttack;
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
    public void setLevel(int level){
        this.level=level;
    }
    public int getTowerType(){
        return 0;
    }
    public int getAttackRange(){
        return attackRange;
    }
    public double getRangeToEnemy(Enemy enemy){
        return Math.sqrt(Math.pow((x-enemy.getX()),2)+Math.pow((y-enemy.getY()),2));
    }
    public void attack(ArrayList<Enemy> enemies,ArrayList<Bullet> bullets){
        if(pastAttack<attackDealy){//如果攻击延迟没有到就跳过
            pastAttack++;
            return;
        }
        pastAttack=0;
        //攻击逻辑：优先攻击范围内血量最少的小兵，如果有多个血量相同的小兵，则攻击离JAVA最近的小兵
        ArrayList<Enemy> enemiesSameHpMin=new ArrayList<Enemy>();
        for(int i=0;i<enemies.size();i++){
            if(getRangeToEnemy(enemies.get(i))<=attackRange){
                if(enemies.get(i).getHP()<minHP){
                    minHP=enemies.get(i).getHP();
                    minHPi=i;
                    enemiesSameHpMin=new ArrayList<Enemy>();
                }
                if(enemies.get(i).getHP()==minHP){
                    SameHP=true;
                    enemiesSameHpMin.add(enemies.get(i));
                }
            }
            else{
                continue;
            }
        }
        int attacki=0;
        if(enemiesSameHpMin.size()==1){
            attacki=minHPi;
        }
        else if(enemiesSameHpMin.size()>1){
            for(int i=0;i<enemiesSameHpMin.size();i++){
                if(getRangeToEnemy(enemiesSameHpMin.get(i))<getRangeToEnemy(enemiesSameHpMin.get(attacki))){
                    attacki=i;
                }
            }
        }
        bullets.add(new Bullet(x,y,enemies.get(attacki),attackDamage,20));//发射子弹
    }
}
