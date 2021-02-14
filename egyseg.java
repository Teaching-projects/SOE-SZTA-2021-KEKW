public class unit{
    int atk;
    int def;
    public unit(int atk, int def)
    {
        atk=atk;
        def=def;
    }
    public boolean isAlive(unit focus)
    {
        if(focus.def>0)
        {
            return false;
        }
        else{return true;}
    }
    public attack(unti attacker, unit deffender){
            if(isAlive(deffender)==true){
            deffender.def-=attacker.atk;}
            else{system.out.println("It's already dead")}
    }
}
