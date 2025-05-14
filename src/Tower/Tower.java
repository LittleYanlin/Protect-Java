package Tower;
public class Tower {
    int x,y,level=0,attackDealy,attackRange,attackDamage,pastAttack;
    public Tower(int x,int y){
        this.x=x;
        this.y=y;
        level=0;
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
}
