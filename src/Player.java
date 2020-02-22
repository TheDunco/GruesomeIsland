import java.util.Scanner;

public class Player {
    private String name;
    // private Item[] inventory;
    private int health;
    private int kills;
    private String commandLineInput;
    private boolean waiting = false;
    private boolean dodging = false;

    Player(){
        name = "username";
        health = 100;
        kills = 0;
    }

    Player(String newName){
        name = newName;
        health = 100;
        kills = 0;
    }

    int menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to play a game? ");
        commandLineInput = scan.nextLine().toUpperCase();
        if (!(commandLineInput == "YES" || commandLineInput == "Y")){
            return -1;
        }
        // while (true){
        //     System.out.printLine(commandLine(commandLineInput));
        //     commandLineInput = scan.nextLine().toUpperCase();
        // }

    }

    String commandLine(String input){
        waiting = false;
        dodging = false;
        String[] cardinalDirections = {"NORTH", "EAST", "SOUTH", "WEST"};
        String[] movementType = {"RUN", "WALK", "GO", "GOTO", "CRAWL", "CLIMB"};
        String[] speechType = {"YELL", "TALK", "SAY", "SPEAK"};
        String[] thrown = {"THROW", "LOB", "CHUCK"};

        String[] tokens = input.toUpperCase().split("\\s+");

        switch(tokens[0]){
            case "NORTH":
                return move("North");
            case "SOUTH":
                return move("South");
            case "EAST":
                return move("East");
            case "WEST":
                return move("West");
            case "RUN":
                if (contains(cardinalDirections, tokens[1])){
                    return move(tokens[0], "run");
                }
                return "I do not understand what direction you wish to run";
            case "WALK":
            case "GOTO":
        //     case "GO":
        //         if (cardinalDirections.contains(tokens[1])){
        //             return move(tokens[0], "walk");
        //         }
        //         return "I do not understand what direction you wish to walk";
        //     case "CRAWL":
        //         if (cardinalDirections.contains(tokens[1])){
        //             return move(tokens[0], "crawl");
        //         }
        //         return "I do not understand what direction you wish to crawl";
        //     case "CLIMB":
        //         if (cardinalDirections.contains(tokens[1])){
        //             return move(tokens[0], "climb");
        //         }
        //         return "I do not understand what direction you wish to climb";
        //     case "LISTEN":
        //         return listen();
        //     case "WAIT":
        //     case "PREPARE":
        //         return wait();
        //     case "DODGE":
        //         return dodge();
        //     case "PRONE":
        //     case "CROUCH":
        //         return crouch();
        //     case "LOOK":
        //         if (cardinalDirections.contains(tokens[1])){
        //             return look(tokens[0]);
        //         }
        //     case "AIM":
        //         return aim(tokens[1], tokens[3]);
        //     case "SHOOT":
        //         return shoot(tokens[1], tokens[3]);
        //     case "THROW":
        //     case "LOB":
        //     case "CHUCK":
        //         return throwObj(tokens[1], tokens[3]);
        //     case "SWING":
        //     case "SLASH":
        //     case "ATTACK":
        //     case "BASH":
        //     case "HIT":
        //         return swing(tokens[1], tokens[3]);
        //     case "DODGE":
        //         return dodge();
        //     case "DRINK":
        //         return drink(tokens[1]);
        //     case "WAIT":
        //     case "PREPARE":
        //     case "BRACE":
        //         return wait();
        //     case "KILL":
        //         switch(tokens[1]){
        //             case "SELF":
        //                 return die();
        //             default:
        //                 return swing(tokens[3], tokens[1]);
        //     }
        //     default:
        //     if(speechType.contains(tokens[0])){
        //         return speak(input);
        //     }

        // }
    }

    public boolean contains(String[] array, String test) {
        for (int i = 0; i < array.length; i++){
            if (test == array[i]){
                return true;
            }
        }
        return false;
    }

    public String crouch() {
        return "yes";
    }

    public String die(){
        return "yes";
    }

    public String drink(String potion){
        return "yes";
    }

    public String swing(String weapon, String target){
        return "yes";
    }

    public String aim(String weapon, String target){
        return "yes";
    }

    public String shoot(String weapon, String target){
        return "yes";
    }

    public String throwObj(String object, String target) {
        return "yes";
    }


    public String speak(String message) {
        String sayType = message.substring(0, message.indexOf(' '));
        String sayMessage = message.substring(message.indexOf(' '));

        // WRITE send a sound message to the world/chunck to send to surronding players
        return("You " + sayType + "\"" + sayMessage + "\"");
    }

    public String look(String direction) {
        // take in data from the world 3
        return ("You look " + direction + " and see ");
    }

    public String dodge() {
        dodging = true;
        return("You begin dodging attacks.");
    }

    // String wait() {
    //     waiting = true;
    //     return("You lay in wait, preparing to hunt your prey.");
    // }

    public String listen(){
        //call for sound data at particular chunck

        return ("You stop to listen. Focusing you hear ");
    }

    public String move(String direction){
        return move(direction, "walk");
    }

    public String move(String direction, String speed){
        //Send message to world dictating the updated position of the character
        //recieve new sight and hear data
        return ("You " + speed + " in the " + direction + ". As you stop you see ");
    }

    public String getName(){
        return name;
    }

    // String[] getInventory(){
    //     return inventory;
    // }

    int getHealth(){
        return health;
    }

    int getKills(){
        return kills;
    }

}