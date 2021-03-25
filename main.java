import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class Main{
    
    public static void main(String[] args) {

        if(args.length==2){
        battle(JsonToUnit(args[0]), JsonToUnit(args[1]));           
        }
        
        else{
        System.out.println("Give attack for Knigh1");
        int Knight1ATK=ReadLine();
        System.out.println("Now hp");
        int Knight1HP=ReadLine();

        System.out.println("Give attack for Knigh2");
        int Knight2ATK=ReadLine();
        System.out.println("Now hp");
        int Knight2HP=ReadLine();

        Unit Knight1 = new Unit(Knight1ATK,Knight1HP); // FIGYELJ ERRE HOGY NINCS BEHÚZVA SEMMI
        Unit Knight2 = new Unit(Knight2ATK,Knight2HP);

        battle(Knight1, Knight2);
    }
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
        String winner = Knight1.isAlive() ? Knight1.getName() : Knight2.getName();
        System.out.println(winner);
    }
    public static int ReadLine (){
        return Integer.parseInt(System.console().readLine());
    }
    public static Unit JsonToUnit(String arg){

        ObjectMapper objectMapper= new ObjectMapper();
           
        Unit unit=new Unit();

            try{
            unit = objectMapper.readValue(new File("./"+arg), Unit.class);
            } catch (JsonProcessingException e){
                System.out.println("JsonProcessingException");
                System.out.println(e.getMessage());
            } catch (IOException io){
                System.out.println("fájlolvalási hiba");
            } 
            return unit;
    }
}