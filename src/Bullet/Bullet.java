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
    public boolean move() {
        double distance = Math.sqrt(Math.pow((x - target.getX()), 2) + Math.pow((y - target.getY()), 2));
        if (distance <= speed) {
            target.getDamage(damage);
            return true;
        }
        double directionX = (target.getX() - x) / distance;
        double directionY = (target.getY() - y) / distance;
        x += (int)(speed * directionX);
        y += (int)(speed * directionY);
        return false;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}