package Enemy;
/*
 * Enemy类
 * 所有敌人类的超类
 */
public class Enemy{
    int HP,maxHp;
    int Speed;
    int x,y;
    int point;
    boolean IsDied;
    boolean IsAchieve;
    int Endx,Endy;
    boolean Isturning=false;
    int pastMove=0;
    public Enemy(int x,int y,int maxHp){
        this.x=x;
        this.y=y;
        this.HP=maxHp;
        this.maxHp=maxHp;
        this.IsDied=false;
        this.IsAchieve=false;
        point=0;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getHP(){
        return HP;
    }
    public void getDamage(int damage){
        if(this.HP-damage<=0){
            this.HP=0;
        }
        else{
            this.HP-=damage;
        }
    }
    public boolean LiveOrDied(boolean IsDied){
        return IsDied;
    }
    public int getPoint(){
        return point;
    }
    public void setPoint(int point){
        this.point=point;
    }
    public boolean ShouldMove(){
        return pastMove==2;
    }
    public boolean move(int direction,int endpoint,int maplength){
        pastMove++;
        if(pastMove!=2){
            return true;
        }
        if(direction==1){//向右走
            if(x+Speed>=endpoint){
                x=endpoint;
                point++;
            }
            else{
                x+=Speed;
            }
        }
        else if(direction==2){//向下走
            if(y+Speed>=endpoint){
                y=endpoint;
                point++;
            }
            else{
                y+=Speed;
            }
        }
        else if(direction==3){//向左走
            if(x-Speed<=endpoint){
                x=endpoint;
                point++;
            }
            else{
                x-=Speed;
            }
        }
        else if(direction==4){//向上走
            if(y-Speed<=endpoint){
                y=endpoint;
                point++;
            }
            else{
                y-=Speed;
            }
        }
        pastMove=0;
        if(point==maplength-1){
            return false;
        }
        return true;
    }
    public void resetMove(){
        pastMove=0;
    }
    public void BeAttacted(int HP,int Attack){
        this.HP=this.HP-Attack;
        this.IsDied=HP<=0;
    }
    public int getMaxHP(){
        return maxHp;
    }
    public int getType(){
        return -1;
    }
}
