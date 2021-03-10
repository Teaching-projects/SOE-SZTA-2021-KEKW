import java.math.BigDecimal; 
import java.math.RoundingMode;

class Main{

    public static void main(String[] args) {
        
        System.out.println("Give attack for Knigh1");
        int Knight1ATK = (int) ReadLine();
        System.out.println("Now hp");
        int Knight1HP = (int) ReadLine();
        System.out.println("Now an attack speed");
        double Knight1AttackSpeed = ReadLine();

        System.out.println("Give attack for Knigh2");
        int Knight2ATK = (int) ReadLine();
        System.out.println("Now hp");
        int Knight2HP = (int) ReadLine();
        System.out.println("Now an attack speed");
        double Knight2AttackSpeed = ReadLine();

        Unit Knight1 = new Unit(Knight1ATK, Knight1HP, Knight1AttackSpeed);
        Unit Knight2 = new Unit(Knight2ATK, Knight2HP, Knight2AttackSpeed);

        battle(Knight1, Knight2);
    }

    public static void battle(Unit Knight1, Unit Knight2) {
        int i = 1; //körök száma
        
        double defAsKN1 = Knight1.attackSpeed;
        double defAsKN2 = Knight2.attackSpeed;

        while (Knight1.isAlive() && Knight2.isAlive()) {
            
            if (i == 1) { //az első körben mindkét lovag megüti egymást
                System.out.println(Knight1.getHealth() + "hp-ja van az első lovagnak, " + Knight1.getAtk() + " sebzést tud okozni");
                System.out.println(Knight2.getHealth() + "hp-ja van az második lovagnak, " + Knight2.getAtk() + " sebzést tud okozni");
    
                System.out.println(i + ". kör");
    
                Knight1.attack(Knight2); 
                Knight2.attack(Knight1);
                
                System.out.println("Mindkét lovag megütötte egymást az első körben");
                i++;
            }

            System.out.println(i + ". kör");

            double lowerAS = Math.min(Knight1.getAs(), Knight2.getAs());
            Knight1.setAs(Knight1.getAs()-lowerAS);
            Knight2.setAs(Knight2.getAs()-lowerAS);

            if(Knight1.getAs() == 0){
                Knight1.attack(Knight2);
                System.out.println("Knight1 megtámadja Knight2: " + Knight1.getAtk() + " sebzést okoz. " + Knight2.getHealth() + " élete marad Knight2-nek");
                Knight1.setAs(defAsKN1);
            }
            if(Knight2.getAs() == 0){
                Knight2.attack(Knight1);
                System.out.println("Knight2 megtámadja Knight1: " + Knight2.getAtk() + " sebzést okoz. " + Knight1.getHealth() + " élete marad Knight1-nek");
                Knight2.setAs(defAsKN2);
            }
            i++;
        }
        String winner = Knight1.isAlive() ? "Knight1 nyert" : "Knight2 nyert";
        System.out.println(winner);
    }
    public static double ReadLine (){
        return Double.parseDouble(System.console().readLine());
    }    
}