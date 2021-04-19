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
    double attackSpeed;



    public Unit(int atk, int hp, double attackSpeed)
    {
        this.atk=atk;
        this.hp=hp;
        this.attackSpeed = attackSpeed;
    }
    
    public Unit(){
        //ez kell a Json beolvasáshoz elvileg
    }

    public boolean isAlive(){    
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

    public String getName(){
        return this.name;
    }

    public double getAs(){
        return attackSpeed;
    }

    public double setAs(double value){
        return this.attackSpeed = value;

    }
}
