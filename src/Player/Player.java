package Player;
class Player{
    int money;
    int HP;
    public Player(){
        money=300;
        HP=100;
    }
    public int getMoney(){
        return money;
    }
    public int getHP(){
        return HP;
    }
    public void getMoney(int money){
        this.money+=money;
    }
    public void getDamage(){
        HP--;
    }
}