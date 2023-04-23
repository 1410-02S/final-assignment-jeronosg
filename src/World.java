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
    int randomFoodSpawn;
    int[][] createCreatures = new int[6][5];

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
        randomFoodSpawn = rand.nextInt(10) + 1;
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
    public void initializeCreatures(){
        for (int i = 0; i <= amountOfCreatures; i++){
            Creature creature = new Creature();
            createCreatures[i][0] = creature.creatureType();
            createCreatures[i][1] = creature.reproductionRate();
            createCreatures[i][2] = creature.chanceOfDeath();
            createCreatures[i][3] = creature.eat(0);
            createCreatures[i][4] = creature.status();
        }
        printData();
    }

    public void printData() {
        System.out.println("Day: " + gameDay);
        for (int i = 1; i < amountOfCreatures + 1; i++){
            // Set Game Day Modifier For Hunger
            createCreatures[i][3] = createCreatures[i][3] - 1;
            boolean alive = true;
            while (createCreatures[i][3] != 0){
                if (createCreatures[i][3] <= 0){
                    alive = false;
                    break;
                } else {
                    alive = true;
                    break;
                }
            }
            // Creature Number
            System.out.println("Creature Number: " + i);
            // Creature Type
            if (createCreatures[i][0] == 1){
                System.out.print("Creature Type: Mammal");
            } else {
                System.out.print("Creature Type: Reptile");
            }
            // Reproduction Rate
            System.out.print("  Reproduction Rate: " + createCreatures[i][1]);
            // Chance of Death
            System.out.print("  Chance of Death: " + createCreatures[i][2]);
            // Amount Eaten
            System.out.print("  Amount Eaten: " + createCreatures[i][3]);
            // Alive or Dead
            System.out.print("  Alive or Dead: " + alive);
            System.out.println(" ");
            System.out.println(" ");
        }
        gameDay = gameDay + 1;
    }

    public void consumeFood(){
        if (randomFoodSpawn > 0) {
            for (int i = 1; i < amountOfCreatures + 1; i++){
                if (createCreatures[i][3] > 0){
                    createCreatures[i][3] = createCreatures[i][3] + 1;
                    randomFoodSpawn = randomFoodSpawn - 1;
                } else {
                    System.out.println("Creature Number: " + i + " is dead. Therefore did not recieve food.");
                }
            }
            System.out.println("One Day Later...");
            System.out.println("Food Remaining: " + randomFoodSpawn);
            printData();
        } else {
            System.out.println("There is no food to consume.");
        }
    }

    public void gatherFood(){
        Random rand = new Random();
        int randomFoodModifer = rand.nextInt(5) + 1;
        randomFoodSpawn = randomFoodSpawn + randomFoodModifer;
        System.out.println("One Day Later...");
        System.out.println("Food Gathered: " + randomFoodModifer);
        System.out.println("Food Remaining: " + randomFoodSpawn);
        printData();
    }
}