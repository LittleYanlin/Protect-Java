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
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        loadingPanel = new MenuPanel(this);
        gamePanel1= new Mission1(this);
        cardPanel.add(loadingPanel, "LOADING");
        cardPanel.add(gamePanel1, "GAME1");
        add(cardPanel, BorderLayout.CENTER);
        cardLayout.show(cardPanel, "LOADING");
    }
    public void switchCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }
    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}