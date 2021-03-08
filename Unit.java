

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
    //amikor a lovag olyan körbe ér ahol üthet, akkor üt (amikor a támadási értéke osztható maradék nélkül az i-vel)
    public boolean canHit(int i){
        if (i % attackSpeed == 0){
            return true;
        }
        else return false;
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
