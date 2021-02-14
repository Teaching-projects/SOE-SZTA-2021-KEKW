public class Egyseg{
    int atk;
    int def;
    public Egyseg(int atk, int def)
    {
        this.atk=atk;
        this.def=def;
    }
    public boolean isAlive(Egyseg focus)
    {
        if(focus.def>0)
        {
            return false;
        }
        else{return true;}
    }
    public  Egyseg attack(Egyseg attacker, Egyseg deffender){
            if(isAlive(deffender)==true){
            deffender.def-=attacker.atk;}
            else{System.out.println("It's already dead")}
        return deffender;
    }
}
