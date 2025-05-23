package Enemy;
public class PaoChe extends Enemy{
    public PaoChe(int x,int y,int level) {
        super(x,y,100+level*50);    
        this.pastMove=0;
        this.Speed=3;
    }
    public int getType(){
        return 1;
    }
}