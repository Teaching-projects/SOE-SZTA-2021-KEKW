class Main{
    
    public static void main(String[] args) {
        System.out.println("Give attack for Knigh1");
        int Knight1ATK=ReadLine();
        System.out.println("Now hp");
        int Knight1HP=ReadLine();

        System.out.println("Give attack for Knigh2");
        int Knight2ATK=ReadLine();
        System.out.println("Now hp");
        int Knight2HP=ReadLine();

        Unit Knight1 = new Unit(Knight1ATK,Knight1HP);
        Unit Knight2 = new Unit(Knight2ATK,Knight2HP);

        battle(Knight1, Knight2);
    }

    public static void battle(Unit Knight1, Unit Knight2) {
        int i = 1;
        while (Knight1.isAlive() && Knight2.isAlive()) {
            System.out.println(i + ". kör");
            
            System.out.println(Knight1.getHealth() + "hp-ja van az első lovagnak, " + Knight1.getAtk() + " sebzést tud okozni");
            Knight1.attack(Knight2);
            if(Knight2.isAlive()==true){
            System.out.println(Knight2.getHealth() + "hp-ja van az második lovagnak, " + Knight2.getAtk() + " sebzést tud okozni");
            Knight2.attack(Knight1);
            }

            i++;
        }
        String winner = Knight1.isAlive() ? "Knight1 nyert" : "Knight2 nyert";
        System.out.println(winner);
    }
    public static int ReadLine (){
        return Integer.parseInt(System.console().readLine());
    }
}