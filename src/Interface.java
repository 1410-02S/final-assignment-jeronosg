/*
 * Final Assignment - CS 1010.
 * @author jeronosg
 * @version CS 1410
 * 
 */

// Import Statements
import java.util.Scanner; 

// Start of Progam
public class Interface {
    // Main Method
    public static void main(String[] args) throws Exception {
        // Start of User Interface
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hello to the World of Creatures!");
        System.out.println("Running the program will create a random world that will have a random amount of creatures, food, and a biome.");
        System.out.println("You can run the followng commands:");
        System.out.println("N - New World");
        System.out.println("Q - Quit Simulation");
        System.out.println("LIST - List of Commands");
        System.out.println("");

        String quitSimulation = "";
        while(quitSimulation != "Q"){
            quitSimulation = userInput.next();
            switch (quitSimulation) {
                // Quit Simulation
                case "Q":
                    System.out.println("Quitting Simulation");
                    quitSimulation = "Q";
                    break;
                
                // New World
                case "N":
                    Scanner inGame = new Scanner(System.in);
                    System.out.println("New World Created:");
                    System.out.println("Type D to go to Next Day, Press F to Feed Creatures, Press G to Gather More Food, Press L to Leave");
                    World world = new World();
                    int amountOfCreatures = world.randomCreature();
                    int amountOfFoodSpawned = world.randomFoodSpawn();
                    System.out.println("Amount of Creatures: " + amountOfCreatures);
                    System.out.println("Food Spawned: " + amountOfFoodSpawned);
                    System.out.println("Biome Modifier: " + world.biomeModifier);
                    System.out.println("Biome: " + world.biome);
                    System.out.println("");
                    
                    world.initializeCreatures();


                    String leaveWorld = "";
                    while(leaveWorld != "L"){
                        leaveWorld = inGame.next();
                        switch (leaveWorld) {
                            // Leave World
                            case "L":
                                System.out.println("Leaving World");
                                System.out.println("Type N to create a new world, Press Q to Quit Simulation");
                                System.out.println("");
                                leaveWorld = "L";
                                break;

                            // Next Day
                            case "D":
                                System.out.println("Next Day");
                                System.out.println("");
                                world.printData();

                                break;
                            
                            // Feed Creatues
                            case "F": 
                                System.out.println("");
                                world.consumeFood();
                                System.out.println("");
                            
                            // Gather More Food
                            case "G":
                                System.out.println("Gathering More Food...");
                                world.gatherFood();
                                

                            // List of Commands
                            case "LIST":
                                System.out.println("D - Next Day");
                                System.out.println("L - Leave World");
                                System.out.println("F - Feed Creatures");
                                System.out.println("G - Gather More Food");
                                System.out.println("LIST - List of Commands");
                                System.out.println("");
                                break;
    
                            // Invalid Command
                            default:
                                System.out.println("Invalid Command");
                                System.out.println("");
                                break;
                        }
                    }
                
                // List of Commands
                case "LIST":
                    System.out.println("N - New World");
                    System.out.println("Q - Quit Simulation");
                    System.out.println("LIST - List of Commands");
                    System.out.println("");
                    break;

                // Invalid Command
                default:
                    System.out.println("Invalid Command");
                    System.out.println("");
                    break;
                }
        }
        userInput.close();
    }
}
