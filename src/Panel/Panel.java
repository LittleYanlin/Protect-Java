package Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import Game.CardSwitcher;
public class Panel extends JPanel{
    javax.swing.Timer gameTimer;
    CardSwitcher cardSwitcher;
    public Panel(CardSwitcher cardSwitcher){
        this.cardSwitcher = cardSwitcher;//设置回调函数
        setSize(1200, 800);
        gameTimer = new javax.swing.Timer(16, e -> {
            repaint();
        });
        addMouseListener(new MouseAdapter(){//添加鼠标点击监听器
            public void mouseClicked(MouseEvent e){
                handleMouseClicked(e);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter(){//添加鼠标移动监听器
            public void mouseMoved(MouseEvent e){
                handleMouseMoved(e);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                // 面板显示时启动定时器
                gameTimer.start();
            }
            public void componentHidden(java.awt.event.ComponentEvent e) {
                // 面板隐藏时停止定时器
                gameTimer.stop();
            }
        });
    }
    void handleMouseClicked(MouseEvent e){}//处理鼠标点击事件
    void handleMouseMoved(MouseEvent e){}//处理鼠标移动事件
}