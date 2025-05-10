package Game;
import javax.swing.*;
import java.awt.*;
import Panel.*;
public class App extends JFrame implements CardSwitcher {
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);
    MenuPanel loadingPanel;
    Mission1 gamePanel1;
    public App() {
        setTitle("保卫JAVA");
        setSize(1200, 800);
        setResizable(false);//设置窗口不可缩放
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口时退出程序
        setLocationRelativeTo(null);//设置窗口居中
        setLayout(new BorderLayout());//设置布局为BorderLayout
        loadingPanel = new MenuPanel(this);
        gamePanel1= new Mission1(this);
        cardPanel.add(loadingPanel, "LOADING");
        cardPanel.add(gamePanel1, "GAME1");
        add(cardPanel, BorderLayout.CENTER);//将卡片面板添加到窗口中
        cardLayout.show(cardPanel, "LOADING");
    }
    public void switchCard(String cardName) {//设置回调函数
        cardLayout.show(cardPanel, cardName);
    }
    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}