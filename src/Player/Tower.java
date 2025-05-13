package Player;
public class Tower {
    int x,y,level=0;
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
}
