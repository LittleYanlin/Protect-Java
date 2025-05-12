package Enemy;
public class Enemy{
    int HP;
    int Speed;
    int x,y;
    boolean IsDied;
    boolean IsAchieve;
    int Endx,Endy;

    
    public Enemy(int HP,int Speed,int Endx,int Endy){
        this.HP=HP;
        this.Speed=Speed;
    }


    public void Move_Y(int Speed){
        y=y+Speed;
    }


    public void Move_X(int Speed){
        x=x+Speed;
    }


    public boolean LiveOrDied(boolean IsDied){
        return IsDied;
    }


    public boolean AchieveOrNot(boolean IsAchieve){
        IsAchieve=(Math.abs(x-this.Endx)<=50)&&(Math.abs(y-this.Endy)<=50);
        return IsAchieve;
    }


    public void BeAttacted(int HP,int Attack){
        this.HP=this.HP-Attack;
        this.IsDied=HP<=0;
    }


}
