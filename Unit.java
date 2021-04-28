import com.fasterxml.jackson.annotation.JsonProperty;

public class Unit{

    @JsonProperty("name")
    protected String name;
    @JsonProperty("lore")
    protected String lore;
    @JsonProperty("health_points")
    protected int hp;
    @JsonProperty("damage")
    protected int atk;
    @JsonProperty("attack_cooldown")
    protected double atk_cd;
    protected double attackSpeed;



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
        return (hp > 0) ;
    }

    public void attack(Unit defender){
        defender.hp -= getAtk();
    }

    public double getHealth(){
        return hp;
    }
    
    public double getAtk(){
        return isAlive() ? atk : 0;
    }

    public String getName(){
        return name;
    }


    public double getAs(){
        return attackSpeed;
    }

    protected void setAs(double value){
       attackSpeed = value;
    }
}
