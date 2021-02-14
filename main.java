public class Main{
    
    public static void main(String[] args) {
        Unit Knight1 = new Unit(5,10);
        Unit Knight2 = new Unit(6,10);

        battle(Knight1, Knight2);
    }

    public static void battle(Unit Knight1, Unit Knight2) {
        int i = 1;
        while (Knight1.isAlive(Knight1) && Knight2.isAlive(Knight2)) {
            System.out.println(i + ". kör");
            
            System.out.println(Knight1.getHealth() + "hp-ja van az első lovagnak, " + Knight1.getAtk() + " sebzést tud okozni");
            System.out.println(Knight2.getHealth() + "hp-ja van az első lovagnak" + Knight2.getAtk() + " sebzést tud okozni");
            
            Knight1.attack(Knight2);
            Knight2.attack(Knight1);


            i++;
        }
        String winner = Knight1.isAlive(Knight1) ? "Knight1 nyert" : "Knight2 nyert";
        System.out.println(winner);
    }
}