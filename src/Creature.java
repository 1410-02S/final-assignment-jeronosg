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
    public int creatureType() {
        Random rand = new Random();
        int randNum = rand.nextInt(100);
        if (randNum < 50){
            return 0;
            // Return Reptile if the random number is under 50 (Repitle = 0)
        } else if (randNum >= 50){
            return 1;
            // Return Mammal if the random number is over 50 (Mammal = 1)
        } else {
            return 0;
            // Fail Safe. Defualt: Repitle (Reptile = 0)
        }
    }

    int amountEaten;
    public int status() {
        if (eat(amountEaten) == 0){
            return 0;
            // Creature will die (false) if it does not eat. (False = 0)
        } else {
            amountEaten = amountEaten - 1;
            return 1;
            // Creature lives if it eats. Take away 1 from amountEaten. (True = 1)
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