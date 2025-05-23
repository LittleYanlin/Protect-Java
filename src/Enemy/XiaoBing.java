package Enemy;
public class XiaoBing extends Enemy{
    public XiaoBing(int x,int y,int level) {
        super(x,y,150+level*80);
        this.pastMove=0;
        this.Speed=2;
    }
    public int getType(){
        return 0;
    }
}