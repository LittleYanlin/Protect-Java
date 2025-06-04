package Player;
import java.awt.Image;
import java.awt.Toolkit;
/*
 * 所有图片的集合类，供其他类调用
 */
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
    public static Image[] BuildMagicTower=new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/buildMagicTower1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/buildMagicTower2.png"),
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
    public static Image[] MagicTower1 = new Image[]{//以下三个为法师塔的图标
            Toolkit.getDefaultToolkit().getImage("./img/fireTower11.png"),
            Toolkit.getDefaultToolkit().getImage("./img/fireTower12.png"),
    };
    public static Image[] MagicTower2 = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/fireTower21.png"),
            Toolkit.getDefaultToolkit().getImage("./img/fireTower22.png"),
    };
    public static Image[] MagicTower3 = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/fireTower31.png"),
            Toolkit.getDefaultToolkit().getImage("./img/fireTower32.png"),
        };  
    public static Image[] StartButton = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/start1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/start2.png"),
    };
    public static Image[] StartGame = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/StartGame1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/StartGame2.png"),
            Toolkit.getDefaultToolkit().getImage("./img/StartGame3.png"),
    };
    public static Image[] Enemy = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/Xiaobing.png"),
            Toolkit.getDefaultToolkit().getImage("./img/GunCar.png"),
            Toolkit.getDefaultToolkit().getImage("./img/Boss.png"),
            Toolkit.getDefaultToolkit().getImage("./img/FrozenXiaobing.png"),
            Toolkit.getDefaultToolkit().getImage("./img/FrozenGunCar.png"),
            Toolkit.getDefaultToolkit().getImage("./img/FrozenBoss.png"),
    };
    public static Image[] Bullet = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/bullet.png"),
    };
    public static Image[] Levelup = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/levelUpButtonOff160_1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/levelUpButtonOff160_2.png"),
    };
    public static Image[] Introduction = new Image[]{
            Toolkit.getDefaultToolkit().getImage("./img/IntroductionButton1.png"),
            Toolkit.getDefaultToolkit().getImage("./img/IntroductionButton2.png"),
            Toolkit.getDefaultToolkit().getImage("./img/introduction.png"),
    };
    public static Image[] AttackButton = new Image[]{
        Toolkit.getDefaultToolkit().getImage("./img/attack1.png"),
        Toolkit.getDefaultToolkit().getImage("./img/attack2.png"),
    };
    public static Image[] LockButton = new Image[]{
        Toolkit.getDefaultToolkit().getImage("./img/lock1.png"),
        Toolkit.getDefaultToolkit().getImage("./img/lock2.png"),
    };
    public static Image[] x = new Image[]{
        Toolkit.getDefaultToolkit().getImage("./img/x1.png"),
        Toolkit.getDefaultToolkit().getImage("./img/x2.png"),
    };
}
