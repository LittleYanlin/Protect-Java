package Panel;
import java.awt.event.MouseEvent;
import Game.CardSwitcher;
import Player.ImageGather;
/*
 * 说明书类，显示游戏说明
 */
public class IntroductionPanel extends Panel{
    int n=0;
    public IntroductionPanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        super.gameTimer.start();
    }
    public void paint(java.awt.Graphics g){//重写paint方法
        super.paint(g);
        g.drawImage(ImageGather.Introduction[2], 0, 0, 1200, 800, this);//背景图
        g.drawImage(ImageGather.Back[n], 10, 10, 100, 100, this);//返回按钮
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){//点击了返回按钮
            cardSwitcher.switchCard("LOADING");
        }
    }
    void handleMouseMoved(MouseEvent e){
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){//鼠标移动到返回按钮上
            n=1;
        }
        else{
            n=0;
        }
    }
}
