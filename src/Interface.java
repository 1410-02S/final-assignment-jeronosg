import java.util.Scanner;   
public class Interface {
    public static void main(String[] args) throws Exception {
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
                case "Q":
                    System.out.println("Quitting Simulation");
                    quitSimulation = "Q";
                    break;

                case "N":
                    Scanner inGame = new Scanner(System.in);
                    System.out.println("New World Created:");
                    System.out.println("Type D to go to Next Day, Press L to Leave");
                    World world = new World();
                    int amountOfCreatures = world.randomCreature();
                    int amountOfFoodSpawned = world.randomFoodSpawn();
                    String worldBiome = world.biome();
                    System.out.println("Amount of Creatures: " + amountOfCreatures);
                    System.out.println("Food Spawned: " + amountOfFoodSpawned);
                    System.out.println("Biome: " + worldBiome);
                    System.out.println("");
                    
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
                    String leaveWorld = "";
                    while(leaveWorld != "L"){
                        leaveWorld = inGame.next();
                        switch (leaveWorld) {
                            case "L":
                                System.out.println("Leaving World");
                                System.out.println("Type N to create a new world, Press Q to Quit Simulation");
                                System.out.println("");
                                leaveWorld = "L";
                                break;

                            case "D":
                                System.out.println("Next Day");
                                System.out.println("");
                                //TODO: Add code to go to next day
                                break;

                            case "LIST":
                                System.out.println("D - Next Day");
                                System.out.println("L - Leave World");
                                System.out.println("LIST - List of Commands");
                                System.out.println("");
                                break;
        
                            default:
                                System.out.println("Invalid Command");
                                System.out.println("");
                                break;
                        }
                    }

                case "LIST":
                    System.out.println("N - New World");
                    System.out.println("Q - Quit Simulation");
                    System.out.println("LIST - List of Commands");
                    System.out.println("");
                    break;
                
                default:
                    System.out.println("Invalid Command");
                    System.out.println("");
                    break;
                }
        }
        userInput.close();
    }
}
