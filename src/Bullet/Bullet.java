package Bullet;
import Enemy.*;
public class Bullet{
    int x,y;
    int damage;
    Enemy target;
    int speed,type,range;
    public Bullet(int x,int y,Enemy target,int damage,int speed,int type,int range){
        this.x=x;
        this.y=y;
        this.target=target;
        this.damage=damage;
        this.speed=speed;
        this.type=type;
        this.range=range;
    }
    public boolean move() {
        double distance = Math.sqrt(Math.pow((x-target.getX()),2)+Math.pow((y-target.getY()),2));
        if (distance<=speed){//如果到达敌人就消失
            return true;
        }
        double directionX=(target.getX()-x)/distance;
        double directionY=(target.getY()-y)/distance;
        x+=(int)(speed*directionX);
        y+=(int)(speed*directionY);
        return false;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Enemy getTarget(){
        return target;
    }
    public int getType(){
        return type;
    }
    public int getDamage(){
        return damage;
    }
    public int getRange(){
        return range;
    }
}