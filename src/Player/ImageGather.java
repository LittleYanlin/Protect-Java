package Player;
import java.awt.Image;
import java.awt.Toolkit;
public class ImageGather {
    public static Image[] Background = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/map1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/map2.png"),
            Toolkit.getDefaultToolkit().getImage("./img/map3.png"),
            Toolkit.getDefaultToolkit().getImage("./img/nullTower.png"),
    };
    public static Image[] LoadingBackground = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/loadingmap.png"),
    };
    public static Image[] Mission = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/mission1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/mission2.png"),
    };
    public static Image[] Back = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/back1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/back2.png"),
    };
    public static Image[] ArrayTower = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/arrowTower1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/arrowTower2.png"),
    };
}
