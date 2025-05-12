package Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import Game.CardSwitcher;
public abstract class Panel extends JPanel{
    CardSwitcher cardSwitcher;
    public Panel(CardSwitcher cardSwitcher){
        this.cardSwitcher = cardSwitcher;//设置回调函数
        setSize(1200, 800);
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
    }
    abstract void handleMouseClicked(MouseEvent e);//处理鼠标点击事件
    abstract void handleMouseMoved(MouseEvent e);//处理鼠标移动事件
}