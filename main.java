import java.math.BigDecimal; 
import java.math.RoundingMode;

class Main{
    
    public static void main(String[] args) {
        
        System.out.println("Give attack for Knigh1");
        double Knight1ATK=ReadLine();
        System.out.println("Now hp");
        double Knight1HP=ReadLine();
        System.out.println("Now an attack speed");
        double Knight1AttackSpeed = 0.7;

        System.out.println("Give attack for Knigh2");
        double Knight2ATK=ReadLine();
        System.out.println("Now hp");
        double Knight2HP=ReadLine();
        System.out.println("Now an attack speed");
        double Knight2AttackSpeed = 0.5;

        Unit Knight1 = new Unit(Knight1ATK, Knight1HP, Knight1AttackSpeed);
        Unit Knight2 = new Unit(Knight2ATK, Knight2HP, Knight2AttackSpeed);

        battle(Knight1, Knight2);
    }

    public static void battle(Unit Knight1, Unit Knight2) {
        int i = 1;
        double szamlalo = 0.0;

        while (Knight1.isAlive() && Knight2.isAlive()) {
            if (i == 1) {
                System.out.println(Knight1.getHealth() + "hp-ja van az első lovagnak, " + Knight1.getAtk() + " sebzést tud okozni");
                System.out.println(Knight2.getHealth() + "hp-ja van az második lovagnak, " + Knight2.getAtk() + " sebzést tud okozni");

                System.out.println(i + ". kör");

                Knight1.attack(Knight2); //az első körben mindkét lovag megüti egymást
                Knight2.attack(Knight1);
                
                System.out.println("Mindkét lovag megütötte egymást az első körben");
            }
            else{
                System.out.println(i + ". kör");
                System.out.println(szamlalo + " szamlalo értéke a körben");

                if(Knight1.isAlive() && Knight1.canHit(Knight1, szamlalo))
                {
                Knight1.attack(Knight2);
                System.out.println("Knight1 megtámadja Knight2: " + Knight1.getAtk() + " sebzést okoz. " + Knight2.getHealth() + " élete marad Knight2-nek");
                Knight1.attackSpeed = Knight1.attackSpeed * 2;
                System.out.println(Knight1.attackSpeed + " KN1 attackspeed");
                }
                else if(Knight2.isAlive() && Knight2.canHit(Knight2, szamlalo)){
                Knight2.attack(Knight1);
                System.out.println("Knight2 megtámadja Knight1: " + Knight2.getAtk() + " sebzést okoz. " + Knight1.getHealth() + " élete marad Knight1-nek");
                Knight2.attackSpeed = Knight2.attackSpeed * 2;
                System.out.println(Knight2.attackSpeed + " KN2 attackspeed");
                }
                else{
                System.out.println("Egyik lovag sem támadott ebben a körben");
                System.out.println(Knight1.attackSpeed + " KN1 attackspeed");
                System.out.println(Knight2.attackSpeed + " KN2 attackspeed");
                }
            }
            szamlalo += 0.1;
            round(szamlalo, 2);
            i++;
        }
        String winner = Knight1.isAlive() ? "Knight1 nyert" : "Knight2 nyert";
        System.out.println(winner);
    }
    public static double ReadLine (){
        return Double.parseDouble(System.console().readLine());
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
}