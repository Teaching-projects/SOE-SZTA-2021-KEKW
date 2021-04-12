public class Unit{

    int atk;
    int hp;
    double attackSpeed;

    public Unit(int atk, int hp, double attackSpeed)
    {
        this.atk=atk;
        this.hp=hp;
        this.attackSpeed = attackSpeed;
    }

    public boolean isAlive()
    {    
        return (this.hp > 0) ;
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

    public double getAs(){
        return attackSpeed;
    }

    public double setAs(double value){
        return this.attackSpeed = value;
    }
}