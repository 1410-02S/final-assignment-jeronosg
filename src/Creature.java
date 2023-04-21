/*
 * Final Assignment - CS 1010.
 * @author jeronosg
 * @version CS 1410
 * 
 */

 // Import Statements
 import java.util.Random;

 // Start of Progam
 public class Creature {
    public String creatureType() {
        Random rand = new Random();
        int randNum = rand.nextInt(100);
        if (randNum < 50){
            return "Reptile";
            // Return Reptile if the random number is under 50
        } else if (randNum >= 50){
            return "Mammal";
            // Return Mammal if the random number is over 50
        } else {
            return "Reptile";
            // Fail Safe. Defualt: Repitle
        }
    }

    int amountEaten;
    public boolean status() {
        if (eat(amountEaten) == 0){
            return false;
            // Creature will die (false) if it does not eat.
        } else {
            amountEaten = amountEaten - 1;
            return true;
            // Creature lives if it eats. Take away 1 from amountEaten.
        }
    }

    public int reproductionRate() {
        Random rand = new Random();
        int randNum = rand.nextInt(5) + 1;
        return randNum;
    }

    public int chanceOfDeath() {
        Random rand = new Random();
        int randNum = rand.nextInt(5) + 0;
        return randNum;
    }

    public int eat(int amountEaten) {
        Random rand = new Random();
        int randNum = rand.nextInt(5);
        amountEaten = amountEaten + randNum;
        return amountEaten;
    }
 }