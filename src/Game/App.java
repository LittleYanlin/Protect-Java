package Game;
import javax.swing.*;
import java.awt.*;
import Panel.*;
/*
 * 主程序类
 * 负责创建窗口和切换卡片
 * 使用卡片布局
 */
public class App extends JFrame implements CardSwitcher {
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);
    public App(){
        setTitle("保卫JAVA");
        setSize(1200, 840);//设置窗口大小
        setResizable(false);//设置窗口不可缩放
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口时退出程序
        setLocationRelativeTo(null);//设置窗口居中
        setLayout(new BorderLayout());//设置布局为BorderLayout
        cardPanel.add(new StartPanel(this), "START");
        add(cardPanel, BorderLayout.CENTER);//将卡片面板添加到窗口中
        cardLayout.show(cardPanel, "START");
    }
    public void switchCard(String cardName) {//设置回调函数
        try{
            switch(cardName){
                case "LOADING":
                    cardPanel.add(new MenuPanel(this), "LOADING");
                    break;
                case "GAME1":
                    cardPanel.add(new Mission1(this), "GAME1");
                    break;
                case "GAME2":
                    cardPanel.add(new Mission2(this), "GAME2");
                    break;
                case "GAME3":
                    cardPanel.add(new Mission3(this), "GAME3");
                    break;
                case "START":
                    cardPanel.add(new StartPanel(this), "START");
                    break;
                case "INTRODUCTION":
                    cardPanel.add(new IntroductionPanel(this),"INTRODUCTION");
            }
            cardLayout.show(cardPanel, cardName);//显示回调函数要求的面板
            cardPanel.remove(0);//切换面板以后把上一个面板删除，位了节约资源·
            cardPanel.revalidate(); //刷新面板（不刷新好像会有bug）
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null,"切换卡片时出现错误！错误详情："+e.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args){
        App app = new App();
        app.setVisible(true);
    }
}