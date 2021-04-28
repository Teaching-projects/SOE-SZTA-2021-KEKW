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
    }

    public static void battle(Unit Knight1, Unit Knight2) {
        int i = 1; //körök száma
        
        

        while (Knight1.isAlive() && Knight2.isAlive()) {
            
            if (i == 1) { //az első körben mindkét lovag megüti egymást
                System.out.println(Knight1.getHealth() + "hp-ja van az első lovagnak, " + Knight1.getAtk() + " sebzést tud okozni");
                System.out.println(Knight2.getHealth() + "hp-ja van az második lovagnak, " + Knight2.getAtk() + " sebzést tud okozni");
    
                System.out.println(i + ". kör");
    
                Knight1.attack(Knight2);
                if(Knight2.isAlive()) Knight2.attack(Knight1);
                
                System.out.println("Mindkét lovag megütötte egymást az első körben");
                i++;
            }

            System.out.println(i + ". kör");

            double lowerAS = Math.min(Knight1.getAs(), Knight2.getAs());
            double defAsKN1 = Knight1.getAs()-lowerAS;
            double defAsKN2 = Knight2.getAs()-lowerAS;

            if(defAsKN1 == 0){
                Knight1.attack(Knight2);
                System.out.println("Knight1 megtámadja Knight2: " + Knight1.getAtk() + " sebzést okoz. " + Knight2.getHealth() + " élete marad Knight2-nek");
                defAsKN1 = Knight1.attackSpeed;
            }
            if(defAsKN2 == 0){
                Knight2.attack(Knight1);
                System.out.println("Knight2 megtámadja Knight1: " + Knight2.getAtk() + " sebzést okoz. " + Knight1.getHealth() + " élete marad Knight1-nek");
                defAsKN2 = Knight2.attackSpeed;
            }
            i++;
        }
        String winner = Knight1.isAlive() ? Knight1.getName() : Knight2.getName();
        System.out.println(winner);
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

    public static Player_Unit JsonToPlayer_Unit(String arg){

        ObjectMapper objectMapper= new ObjectMapper();
           
        Player_Unit player_unit=new Player_Unit();

            try{
            player_unit = objectMapper.readValue(new File("./"+arg), Unit.class);
            } catch (JsonProcessingException e){
                System.out.println("JsonProcessingException");
                System.out.println(e.getMessage());
            } catch (IOException io){
                System.out.println("fájlolvalási hiba");
            } 
            return player_unit;
    }

    public static double ReadLine (){
        return Double.parseDouble(System.console().readLine());
    }    
  
}