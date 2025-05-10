package Panel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import Player.ImageGather;
import Game.CardSwitcher;
public class MenuPanel extends JPanel{
    CardSwitcher cardSwitcher;
    int m=0,n=0;
    public MenuPanel(CardSwitcher cardSwitcher){
        this.cardSwitcher = cardSwitcher;//接收回调函数
        setSize(1200, 800);
        addMouseListener(new MouseAdapter() {//设置鼠标点击监听器
            public void mouseClicked(MouseEvent e){
                handleMouseClicked(e);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {//设置鼠标移动监听器
            public void mouseMoved(MouseEvent e){
                handleMouseMoved(e);
            }
        });
    }
    public void paint(Graphics g){//重写paint方法
        super.paint(g);
        g.drawImage(ImageGather.LoadingBackground[0], 0, 0, 1200, 800, this);//背景图
        g.drawImage(ImageGather.Back[n], 10, 10, 100, 100, this);//返回按钮
        g.drawImage(ImageGather.Mission[m], 300, 510, 45, 75, this);//第一关按钮
    }
    private void handleMouseClicked(MouseEvent e){
        if (e.getX()>0&&e.getX()<50&&e.getY()>0&&e.getY()<50){//点击了返回按钮
            cardSwitcher.switchCard("GAME");
        }
        if (e.getX()>250&&e.getX()<470&&e.getY()>450&&e.getY()<600) {//点击了第一关按钮
            cardSwitcher.switchCard("GAME1");
        }
    }
    private void handleMouseMoved(MouseEvent e){
        if (e.getX()>250&&e.getX()<470&&e.getY()>450&&e.getY()<600){//鼠标移动到第一关按钮上
            m=1;//把图片变为高亮的
            repaint();//重绘
        }
        else{
            m=0;
            repaint();
        }
        if (e.getX()>0&&e.getX()<100&&e.getY()>0&&e.getY()<100){//鼠标移动到返回按钮上
            n=1;
            repaint();
        }
        else{
            n=0;
            repaint();
        }
    }
}