package Enemy;
public class Boss extends Enemy{
    public Boss(int x,int y,int level) {
        super(x,y,1000+level*300);
        this.pastMove=0;
        this.Speed=1;
    }
    public int getType(){
        return 2;
    }
}
