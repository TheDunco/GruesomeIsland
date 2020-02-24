package src;

import java.util.Random;
import java.util.Scanner;

public class GruesomeIsland {

    public static void main(String[] args) {

        run();

    }

    private static void run(){
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
            commandLineInput = scan.nextLine();
            Player player = new Player(commandLineInput);
            int worldSize = 10;


            Random rand = new Random();

            // randomly select the spawn chunk
            Chunk spawnChunk = World.getInstance(worldSize).chunks[rand.nextInt(worldSize)][rand.nextInt(worldSize)];

            // spawn the player
            spawnChunk.addPlayer(player);
            player.setLocation(spawnChunk);

            System.out.print("\nWelcome to Gruesome Island " + player.getName()
                        + ".\n\nWe've been expecting you and we are eager to see great results from you today.\n"
                        + "You may be wondering how you got here, but more on that later...\n\n"
                        + "For now, simply tell me what you want to do:\n");

            while (!player.isDead()){
                // print the player's location within the matrix
                System.out.print(player.getLocation().iPos);
                System.out.print(" ");
                System.out.print(player.getLocation().jPos);

                System.out.print("---> ");
                commandLineInput = scan.nextLine().toUpperCase();
                if (commandLineInput.equalsIgnoreCase("exit")) {
                    player.kill("Player exit");
                    break;
                }

                try {
                System.out.println(player.commandLine(commandLineInput));
                }
                catch(java.lang.ArrayIndexOutOfBoundsException Exc) {
                    System.out.println("Please enter something sensible");
                }

                // world.showMatrix();
            }
            
            System.out.print("\n\nGame over!\n\n Would you like to play again?\n");
            System.out.print("---> ");
            commandLineInput = scan.nextLine().toUpperCase();

            if (commandLineInput.equalsIgnoreCase("y") ||
            commandLineInput.equalsIgnoreCase("yes")) {
                run();
            }
        }

    }

}
