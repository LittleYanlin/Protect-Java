package Bullet;
import Enemy.*;
public class Bullet{
    int x,y;
    int damage;
    Enemy target;
    int speed;
    public Bullet(int x,int y,Enemy target,int damage,int speed){
        this.x=x;
        this.y=y;
        this.target=target;
        this.damage=damage;
        this.speed=speed;
    }
    public boolean move(){
        double distance=Math.sqrt(Math.pow((x-target.getX()),2)+Math.pow((y-target.getY()),2));
        double directionX=(target.getX()-x)/distance;
        double directionY=(target.getY()-y)/distance;
        int speedX=(speed*directionX);
        int speedY=(speed*directionY);
        if(Math.abs(x-target.getX())<speedX && Math.abs(y-target.getY())<speedY){
            target.getDamage(damage);
            return true;
        }
        x+=speedX;
        y+=speedY;
        return false;
    }
}