package Tower;

public class MagicTower extends Tower{
    public MagicTower(int x,int y){
        super(x,y);
        attackDamage=8;
        attackDealy=66;
        pastAttack=0;
        attackRange=100;
    }
    public int getTowerType(){
        return 2;
    }
    public int getAttackType(){
        return 2;
    }
}
