package Tower;

public class ArrayTower extends Tower {
    public ArrayTower(int x, int y) {
        super(x, y);
        attackDamage = 10;
        attackDealy = 60;
        pastAttack = 0;
    }
    public int getTowerType(){
        return 1;
    }
}
