/*
 * Final Assignment - CS 1010.
 * @author jeronosg
 * @version CS 1410
 * 
 */

 // Import Statements
import java.util.Random;

// Stat of Progam
public class World {
    // Variables 
    String biome = "";
    int biomeModifier = 0;
    int amountOfCreatures = 0;
    int gameDay = 0;

    // Amount of Creatures Spawned
    public int randomCreature(){
        Random rand = new Random();
        int randomCreatureSpawn = rand.nextInt(5) + 1;
        amountOfCreatures = randomCreatureSpawn;
        return randomCreatureSpawn;
    }

    // Amount of Food Spawned Based on Biome
    public int randomFoodSpawn(){
        Random rand = new Random();
        int randomFoodSpawn = rand.nextInt(10) + 1;
        if (biome() == "Desert") {
            biomeModifier = -2;
            return randomFoodSpawn + biomeModifier;
            // If the biome is a desert, there will be 2 less food spawn.
        } else if (biome() == "Forest"){
            biomeModifier = 2;
            return randomFoodSpawn + biomeModifier;
            // If the biome is a forest, there will be 2 more food spawn.
        } else if (biome() == "Tundra"){
            biomeModifier = -1;
            return randomFoodSpawn + biomeModifier;
            // If the biome is a tundra, there will be 1 less food spawn.
        } else if (biome() == "Jungle"){
            biomeModifier = 1;
            return randomFoodSpawn + biomeModifier;
            // If the biome is a jungle, there will be 1 more food spawn.
        } else if (biome() == "Ocean"){
            biomeModifier = 0;
            return randomFoodSpawn + biomeModifier;
            // If the biome is a ocean, there will be no change in food spawn.
        } else {
            biomeModifier = 0;
            return randomFoodSpawn;
            // Fail Safe. Defualt: 0
        }
    }

    public String biome(){
        Random rand = new Random();
        int biomeType = rand.nextInt(5) + 1;
        if (biomeType == 1){
            biome = "Forest";
            return "Forest";
        } else if (biomeType == 2){
            biome = "Desert";
            return "Desert";
        } else if (biomeType == 3){
            biome = "Tundra";
            return "Tundra";
        } else if (biomeType == 4){
            biome = "Jungle";
            return "Jungle";
        } else if (biomeType == 5){
            biome = "Ocean";
            return "Ocean";
        } else {
            return "Forest";
        }
    }

    public void printData() {
        System.out.println("Day: " + gameDay);
        for (int i = 1; i < amountOfCreatures + 1; i++){
            Creature creature = new Creature();
            System.out.println("Creature Number: " + i);
            System.out.print("Creature Type: " + creature.creatureType());
            System.out.print("  Reproduction Rate: " + creature.reproductionRate());
            System.out.print("  Chance of Death: " + creature.chanceOfDeath());
            System.out.print("  Amount Eaten: " + creature.eat(0));
            System.out.print("  Alive: " + creature.status());
            System.out.println(" ");
            System.out.println(" ");
        }
        gameDay = gameDay + 1;
    }
}