

public class Unit{
   
    int atk;
    int hp;
    double attackSpeed;
    String name;
    String lore;

    public Unit(int atk, int hp, double attackSpeed, String name, String lore){
        this.atk=atk;
        this.hp=hp;
        this.attackSpeed = attackSpeed;
        this.name = name;
        this.lore = lore;
    }

    public boolean isAlive(){    
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
