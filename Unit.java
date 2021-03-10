

public class Unit{
   
    double atk;
    double hp;
    double attackSpeed;

    public Unit(double atk, double hp, double attackSpeed)
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
    //amikor a lovag olyan körbe ér ahol üthet, akkor üt (amikor a támadási értéke osztható maradék nélkül a szamlaloval)
    public boolean canHit(Unit lovag, double szamlalo){
        return (lovag.attackSpeed == szamlalo);
    }

    public void attack(Unit defender){

        defender.hp -= getAtk();
    }

    public double getHealth(){
        return hp;
    }
    
    public double getAtk(){
        return this.isAlive() ? atk : 0;
    }
}
