package Tower;

public class ArrayTower extends Tower {
    public ArrayTower(int x, int y) {
        super(x, y);
        attackDamage = 10;
        attackDealy = 60;
        pastAttack = 0;
        attackRange=500;
    }
    public int getTowerType(){
        return 1;
    }
    public int getAttackType(){
        return 1;
    }
}
