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
    public int randomCreature(){
        Random rand = new Random();
        int randomCreatureSpawn = rand.nextInt(5) + 1;
        return randomCreatureSpawn;
    }

    public int randomFoodSpawn(){
        Random rand = new Random();
        int randomFoodSpawn = rand.nextInt(10) + 1;
        if (biome() == "Desert") {
            return randomFoodSpawn - 2;
            // If the biome is a desert, there will be 1 less food spawn.
        } else if (biome() == "Forest"){
            return randomFoodSpawn + 2;
            // If the biome is a forest, there will be 1 more food spawn.
        } else if (biome() == "Tundra"){
            return randomFoodSpawn - 1;
        } else if (biome() == "Jungle"){
            return randomFoodSpawn + 1;
        } else if (biome() == "Ocean"){
            return randomFoodSpawn;
        } else {
            return randomFoodSpawn;
        }
    }

    public String biome(){
        Random rand = new Random();
        int biomeType = rand.nextInt(5) + 1;
        if (biomeType == 1){
            return "Forest";
        } else if (biomeType == 2){
            return "Desert";
        } else if (biomeType == 3){
            return "Tundra";
        } else if (biomeType == 4){
            return "Jungle";
        } else if (biomeType == 5){
            return "Ocean";
        } else {
            return "Forest";
        }
    }
}