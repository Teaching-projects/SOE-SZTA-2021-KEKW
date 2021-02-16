public class Unit{
   
    int atk;
    int hp;

    public Unit(int atk, int hp)
    {
        this.atk=atk;
        this.hp=hp;
    }

    public boolean isAlive(Unit focus) //focus = akit épp vizsgálunk hogy él-e
    {    
        return (focus.hp > 0) ;
    }

    public void attack(Unit defender){

        defender.hp -= getAtk();
    }

    public int getHealth(){
        return hp;
    }
    
    public int getAtk(){
        if(this.isAlive(this)==true){
        return atk;
        }
        else{
            return 0;
        }
    }
}
