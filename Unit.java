import com.fasterxml.jackson.annotation.JsonProperty;

public class Unit{

    @JsonProperty("name")
    String name;
    @JsonProperty("lore")
    String lore;
    @JsonProperty("health_points")
    int hp;
    @JsonProperty("damage")
    int atk;
    @JsonProperty("attack_cooldown")
    double atk_cd;

    

    public Unit(int atk, int hp)
    {
        this.atk=atk;
        this.hp=hp;
        
    }
    public Unit(){
        
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
    public String getName(){
        return this.name;
    }
}
