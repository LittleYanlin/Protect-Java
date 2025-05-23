package Enemy;
/*
 * Boss类
 * 生命值：初始值1000，随着关卡增加每关增加250
 * 速度：1
 */
public class Boss extends Enemy{
    public Boss(int x,int y,int level) {
        super(x,y,1000+level*250);
        this.pastMove=0;
        this.Speed=1;
    }
    public int getType(){
        return 2;
    }
}
