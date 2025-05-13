package Player;
import java.awt.Image;
import java.awt.Toolkit;
public class ImageGather {
    public static Image[] Background = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/map1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/map2.png"),
            Toolkit.getDefaultToolkit().getImage("./img/map3.png"),
    };
    public static Image[] LoadingBackground = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/loadingmap.png"),
            Toolkit.getDefaultToolkit().getImage("./img/ProtectJAVA.png"),
    };
    public static Image[] Mission = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/mission1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/mission2.png"),
    };
    public static Image[] Back = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/back1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/back2.png"),
    };
    public static Image[] BuildArrayTower = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/buildArrowTower1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/buildArrowTower2.png"),
    };
    public static Image[] NullTower = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/nullTower1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/nullTower2.png"),
    };
    public static Image[] ArrayTower1 = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/arrowTower11.png"),
            Toolkit.getDefaultToolkit().getImage("./img/arrowTower12.png"),
    };
    public static Image[] ArrayTower2 = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/arrowTower21.png"),
            Toolkit.getDefaultToolkit().getImage("./img/arrowTower22.png"),
    };
    public static Image[] ArrayTower3 = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/arrowTower31.png"),
            Toolkit.getDefaultToolkit().getImage("./img/arrowTower32.png"),
        };
    public static Image[] StartButton = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/start1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/start2.png"),
    };
}
