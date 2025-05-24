package Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import Game.CardSwitcher;
/*
 * 所有窗口的超类，继承自JPanel
 * 设置窗口的大小和定时器
 * 同时添加鼠标点击和移动事件的监听器
 */
public class Panel extends JPanel{
    javax.swing.Timer gameTimer;
    CardSwitcher cardSwitcher;
    public Panel(CardSwitcher cardSwitcher){
        this.cardSwitcher = cardSwitcher;//设置回调函数
        setSize(1200, 800);
        gameTimer = new javax.swing.Timer(16,e->{//设置定时器，每16毫秒触发一次，每秒大约62.5帧
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
        addComponentListener(new java.awt.event.ComponentAdapter(){//添加组件监听器（不在顶层的面板计时器不运作，节约资源）
            public void componentShown(java.awt.event.ComponentEvent e){// 面板显示时启动定时器
                gameTimer.start();
            }
            public void componentHidden(java.awt.event.ComponentEvent e){// 面板隐藏时停止定时器
                gameTimer.stop();
            }
        });
    }
    void handleMouseClicked(MouseEvent e){}//处理鼠标点击事件
    void handleMouseMoved(MouseEvent e){}//处理鼠标移动事件
}