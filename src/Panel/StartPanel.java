package Panel;
import Game.CardSwitcher;
import Player.ImageGather;
import java.awt.event.MouseEvent;
/*
 * 开始面板类
 * 用于显示欢迎界面（保卫JAVA）
 */
public class StartPanel extends Panel{
    int m=0;
    public StartPanel(CardSwitcher cardSwitcher){
        super(cardSwitcher);
        super.gameTimer.start();
    }
    public void paint(java.awt.Graphics g){//重写paint方法
        super.paint(g);
        g.drawImage(ImageGather.LoadingBackground[1], 0, 0, 1200, 800, this);//背景图
        g.drawImage(ImageGather.StartButton[m], 580, 545, 200, 200, this);
    }
    void handleMouseClicked(MouseEvent e){
        if (e.getX()>580&&e.getX()<780&&e.getY()>545&&e.getY()<745){//点击了开始按钮
            super.cardSwitcher.switchCard("LOADING");
        }
        if(e.getX()>1088&&e.getX()<1155&&e.getY()>725&&e.getY()<788){//点击了退出按钮
            System.exit(0);
        }
    }
    void handleMouseMoved(MouseEvent e){
        if (e.getX()>580&&e.getX()<780&&e.getY()>545&&e.getY()<745){//鼠标移动到开始按钮上
            m=1;
        }
        else{
            m=0;
        }
    }
}
