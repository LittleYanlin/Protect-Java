package Enemy;
/*
 * 小兵类，继承自Enemy类
 * 生命值：初始值150，随着关卡增加每关增加60
 * 速度：2
 */
public class XiaoBing extends Enemy{
    public XiaoBing(int x,int y,int level) {
        super(x,y,150+level*60);  // 减少血量增长速度
        this.pastMove=0;
        this.Speed=2;
    }
    public int getType(){
        return 0;
    }
}