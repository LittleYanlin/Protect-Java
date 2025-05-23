package Player;
public class Player{
    int money;
    int HP;
    public Player(){
        money=30000;
        HP=100;
    }
    public int getMoney(){
        return money;
    }
    public int getHP(){
        return HP;
    }
    public void setMoney(int money){
        this.money+=money;
    }
    public void getDamage(int damage){
        HP-=damage;
    }
}