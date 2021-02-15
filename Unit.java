public class Unit{
   
    int atk;
    int hp;

    public Unit(int atk, int hp)
    {
        this.atk=atk;
        this.hp=hp;
    }

    public boolean isAlive(Unit focus) //focus = akit épp vizsgálunk hogy él-e
    {
        if(focus.hp>0){ return true;} else{return false;}        
    }

    public void attack(Unit defender){
        int defenderHp = defender.getHealth();
        int myAttack = getAtk();
        int newHp = defenderHp - myAttack;
        
        defender.setHealth(newHp);
    }

    public int getHealth(){
        return hp;
    }
    
    public int getAtk(){
        if(this.isAlive(this)==true){
        return atk;
        }
        else{
            return 0;
        }
    }

    private void setHealth(int hp) {
        this.hp = hp;
    }
}
