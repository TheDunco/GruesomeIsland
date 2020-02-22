package src;

import java.util.Random;
import java.util.Scanner;

public class GruesomeIsland {

    public static void main(String[] args) {

        run();
        // World world = new World(10);
        // world.showMatrix();
        // try {
        //     int[] test = new int[2];
        //     test = world.chunks[3][3].getAdjacentChunk("East");

        //     System.out.println(test[0]);
        //      System.out.println(test[1]);
        // }
        // catch(IllegalStateException OB) {
        //     // System.out.println(OB);
        // }
    }

    static void run(){
        Scanner scan = new Scanner(System.in);
        String commandLineInput = "";
        String exit = "exit";

        System.out.println("\nDo you want to play a game?");
        System.out.print("---> ");
        commandLineInput = scan.nextLine().toUpperCase();

        if (commandLineInput.equalsIgnoreCase("yes") || commandLineInput.equalsIgnoreCase("y")
                || commandLineInput.equalsIgnoreCase("yeah") || commandLineInput.equalsIgnoreCase("sure")) {
            System.out.println("\nOk, what's your name?");
            System.out.print("---> ");
            commandLineInput = scan.nextLine().toUpperCase();
            Player player = new Player(commandLineInput);
            int worldSize = 10;


            Random rand = new Random();
            Chunk spawnChunk = World.getInstance(10).chunks[rand.nextInt(worldSize)][rand.nextInt(worldSize)];
            spawnChunk.addPlayer(player); // spawn the player
            player.setLocation(spawnChunk);

            System.out.print("\nWelcome to Gruesome Island " + player.getName()
                        + ".\n\nWe've been expecting you and we are eager to see great results from you today.\n"
                        + "You may be wondering how you got here, but more on that later...\n\n"
                        + "For now, simply tell me what you want to do:\n");

            while (!player.isDead()){
                System.out.print("---> ");
                commandLineInput = scan.nextLine().toUpperCase();
                if (commandLineInput.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println(player.commandLine(commandLineInput));
                
                
                // world.showMatrix();

            }
            
            System.out.print("\n\nGame over!\n\n Would you like to play again?\n");
            System.out.print("---> ");

        }

    }

}
