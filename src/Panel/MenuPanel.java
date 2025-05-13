package Panel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import Player.ImageGather;
import Game.CardSwitcher;
public class MenuPanel extends Panel{
    int m1=0,n=0,m2=0,m3=0;
    public MenuPanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
    }
    public void paint(Graphics g){//重写paint方法
        super.paint(g);
        g.drawImage(ImageGather.LoadingBackground[0], 0, 0, 1200, 800, this);//背景图 this是指当前组件监听状态
        g.drawImage(ImageGather.Back[n], 10, 10, 100, 100, this);//返回按钮
        g.drawImage(ImageGather.Mission[m1], 300, 510, 45, 75, this);//第一关按钮
        g.drawImage(ImageGather.Mission[m2], 450, 400, 45, 75, this);//第二关按钮
        g.drawImage(ImageGather.Mission[m3], 300, 317, 45, 75, this);//第三关按钮
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){//点击了返回按钮
            cardSwitcher.switchCard("START");
        }
        if (e.getX()>300&&e.getX()<345&&e.getY()>510&&e.getY()<585) {//点击了第一关按钮
            cardSwitcher.switchCard("GAME1");
        }
        if (e.getX()>450&&e.getX()<495&&e.getY()>400&&e.getY()<475) {//点击了第二关按钮
            cardSwitcher.switchCard("GAME2");
        }
        if (e.getX()>300&&e.getX()<345&&e.getY()>317&&e.getY()<392) {//点击了第三关按钮
            cardSwitcher.switchCard("GAME3");
        }
    }
    void handleMouseMoved(MouseEvent e){
        if (e.getX()>300&&e.getX()<345&&e.getY()>510&&e.getY()<585){//鼠标移动到第一关按钮上
            m1=1;//把图片变为高亮的
        }
        else{
            m1=0;
        }
        if (e.getX()>450&&e.getX()<495&&e.getY()>400&&e.getY()<475){//鼠标移动到第二关按钮上
            m2=1;
        }
        else{
            m2=0;
        }
        if (e.getX()>300&&e.getX()<345&&e.getY()>317&&e.getY()<392){//鼠标移动到第三关按钮上
            m3=1;
        }
        else{
            m3=0;
        }
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){//鼠标移动到返回按钮上
            n=1;
        }
        else{
            n=0;
        }
    }
}