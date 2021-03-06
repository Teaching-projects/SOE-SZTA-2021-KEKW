

public class Unit{
   
    int atk;
    int hp;
    int attackSpeed;

    public Unit(int atk, int hp, int attackSpeed)
    {
        this.atk=atk;
        this.hp=hp;
        this.attackSpeed = attackSpeed;
    }

    public boolean isAlive()
    {    
        return (this.hp > 0) ;
    }

    //F3/2 feladathoz tartozó canHit
    //ha a lovag páros számot kap, tud támadni
    public boolean canHit(){
        return (this.attackSpeed % 2 == 0);
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
