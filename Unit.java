

public class Unit{
   
    int atk;
    int hp;

    public Unit(int atk, int hp)
    {
        this.atk=atk;
        this.hp=hp;
    }

    public boolean isAlive()
    {    
        return (this.hp > 0) ;
    }

    public void attack(Unit defender){

        defender.hp -= getAtk();
    }

    public int getHealth(){
        return hp;
    }
    
    public int getAtk(){
        return this.isAlive() ? atk : 0;
    }
}
