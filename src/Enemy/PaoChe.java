package Enemy;
/*
 * 炮车类，继承自Enemy类
 * 生命值：初始值120，随着关卡增加每关增加40
 * 速度：3
 */
public class PaoChe extends Enemy{
    public PaoChe(int x,int y,int level) {
        super(x,y,120+level*40);
        this.pastMove=0;
        this.Speed=3;
    }
    public int getType(){
        return 1;
    }
}