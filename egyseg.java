public class egyseg{
    int atk;
    int def;
    public egyseg(int atk, int def)
    {
        atk=atk;
        def=def;
    }
    public boolean isAlive(egyseg focus)
    {
        if(focus.def>0)
        {
            return false;
        }
        else{return true;}
    }
    public  egyseg attack(egyseg attacker, egyseg deffender){
            if(isAlive(deffender)==true){
            deffender.def-=attacker.atk;}
            else{System.out.println("It's already dead")}
        return deffender;
    }
}
