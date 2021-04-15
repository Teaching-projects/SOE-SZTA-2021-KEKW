import com.fasterxml.jackson.annotation.JsonProperty;

public class Player_Unit extends Unit {

    int lvl=0;
    int xp=0;
    double dmg_inflicted=0;
    double dmg_required_to_lvlup=100;
    @JsonProperty("xp_per_level")
    int xp_per_lvl;
    @JsonProperty("dmg_increase_per_level")
    int dmg_per_lvl;
    @JsonProperty("hp_increase_per_level")
    int hp_per_lvl;
    @JsonProperty("cooldown_multiplier_per_level")
    float cd_mp_per_lvl;

    public Player_Unit(int atk, int hp, double attackSpeed){
        super( atk,  hp,  attackSpeed);
    }

    public Player_Unit(){
        
    }
    

    public void lvl_up(){
        lvl+=1;
        xp=xp+xp_per_lvl;
        hp=hp+hp_per_lvl;
        atk=atk+dmg_per_lvl;
        atk_cd=atk_cd*cd_mp_per_lvl;
    }

    public void attack(Unit defender){
        defender.hp -= getAtk();
        dmg_inflicted += getAtk();
        if(dmg_inflicted/dmg_required_to_lvlup>lvl){

            int lvlup_number = (int) (dmg_inflicted/dmg_required_to_lvlup)-lvl;

            for(int i=0; i<lvlup_number;i++){
                lvl_up();
            }        
        }
    
    }
}
