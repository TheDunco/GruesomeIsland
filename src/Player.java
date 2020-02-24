package src;

import java.util.Scanner;

// import jdk.nashorn.internal.ir.GetSplitState;

import java.util.LinkedList;
import java.util.Random;

public class Player {
    private String name;
    private LinkedList<Item> inventory;
    private int health;
    private int kills;
    private String commandLineInput;
    private boolean waiting = false;
    private boolean dodging = false;
    private Chunk location;
    private boolean dead = false;

    private static Random rand = new Random();
    private static String cardinalDirections = "NORTH EAST SOUTH WEST UP LEFT DOWN RIGHT";

    // private static String[] rangedWeapons = {"RIFLE", "MACHINE GUN", "SHOTGUN", "PISTOL", "LONGBOW"};
    // private static String[] throwableItems = {"GRENADE", "TRIDENT", "TIN CAN"}

    public Player() {
        this.name = "username";
        this.health = 100;
        this.kills = 0;
        this.inventory = new LinkedList<Item>();
    }

    Player(String newName) {
        this.name = newName;
        this.health = 100;
        this.kills = 0;
        this.inventory = new LinkedList<Item>();
        this.inventory.add(new RangedWeapon(4));
    }

    String commandLine(String input) {
        waiting = false;
        dodging = false;
        // String[] movementType = {"RUN", "WALK", "GO", "GOTO", "CRAWL", "CLIMB"};
        String[] speechType = {"YELL", "TALK", "SAY", "SPEAK"};
        // String[] thrown = {"THROW", "LOB", "CHUCK"};

        String[] tokens = input.toUpperCase().split("\\s+");

        switch (tokens[0]) {
            case "UP":
            case "NORTH":
                return move("NORTH", "walk");
            case "DOWN":
            case "SOUTH":
                return move("SOUTH", "walk");
            case "LEFT":
            case "WEST":
                return move("EAST", "walk");
            case "RIGHT":
            case "EAST":
                return move("WEST", "walk");
            case "RUN":
                if (cardinalDirections.contains(tokens[1])) {
                    return move(tokens[1], "run");
                }
                return "I do not understand what direction you wish to run";
            case "WALK":
            case "MOVE":
            case "GOTO":
            case "GO":
                if (cardinalDirections.contains(tokens[1])) {
                    return move(tokens[1], "walk");
                }
                return "I do not understand what direction you wish to walk";
//            case "CRAWL":
//                if (cardinalDirections.contains(tokens[1])) {
//                    return move(tokens[0], "crawl");
//                }
//                return "I do not understand what direction you wish to crawl";
//            case "CLIMB":
//                if (cardinalDirections.contains(tokens[1])) {
//                    return move(tokens[0], "climb");
//                }
//                return "I do not understand what direction you wish to climb";
            case "LISTEN":
                return listen();
            case "PRONE":
            case "CROUCH":
                return crouch();
            case "LOOK":
                if (cardinalDirections.contains(tokens[1])) {
                    return look(tokens[0]);
                }
            case "AIM":
                return aim(tokens[1], tokens[3]);
            case "SHOOT":
                return shoot(tokens[3], tokens[1]);
            case "THROW":
            case "LOB":
            case "CHUCK":
                return throwObj(tokens[1], tokens[3]);
            case "SWING":
            case "SLASH":
            case "ATTACK":
            case "BASH":
            case "HIT":
                return swing(tokens[1], tokens[3]);
            case "DODGE":
                return dodge();
            case "DRINK":
                return drink(tokens[1]);
            case "KILL":
                switch (tokens[1]) {
                    case "SELF":
                        return kill("SELF");
                    default:
                        return swing(tokens[3], tokens[1]);
                }
            default:
                if (contains(speechType, tokens[0])) {
                    return speak(input);
                } else {
                    return "I don't know what you mean by " + input;
                }

        }
    }

    boolean contains(String[] array, String test) {
        for (int i = 0; i < array.length; i++) {
            if (test == array[i]) {
                return true;
            }
        }
        return false;
    }

    String crouch() {
        return "yes";
    }

    String kill(String cause) {
        return "You were slain by " + cause + "!";
    }

    String drink(String potion) {
        return "yes";
    }

    String swing(String weapon, String target) {
        return "yes";
    }

    String aim(String weapon, String target) {
        return "yes";
    }

    String shoot(String weaponString, String target) {
        int index = playerHas(weaponString);
        if (index == -1) { // shoot fails - specified item not in inventory
            return "You don't have a " + weaponString + " in your inventory.\n";
        }

        Item weapon = this.inventory.get(index);

        // if (location.sightLine(this, location.getPlayer(target), weapon.range())){ // determine whether player is in a chunk close enough to target

        int shotAccuracy = rand.nextInt(100);
        int damageRange = weapon.damagePerShot()[1] - weapon.damagePerShot()[0];
        int shotDamage = rand.nextInt(damageRange + 1);
        shotDamage += weapon.damagePerShot()[0];
        if (weapon.getItem() != "MACHINE GUN") {
            if (shotAccuracy < weapon.accuracy()) {
                //  TODO deal damage to other player
                // TODO sound
                this.inventory.get(index).decrementAmmo();
                return "You hit " + target + " with your " + weaponString + " dealing " + String.valueOf(shotDamage);
            } else {
                inventory.get(index).decrementAmmo();
                return "Your shot at " + target + " missed.\n";
            }
        } else {
            String returnString = "";
            for (int i = 0; i < 5; i++) {
                if (shotAccuracy < weapon.accuracy() && weapon.getAmmo() > 0) {
                    // TODO deal damage
                    // TODO make sound
                    returnString += "A bullet hits " + target + " for " + String.valueOf(shotDamage) + " damage.\n";
                }
                this.inventory.get(index).decrementAmmo();
                shotAccuracy = rand.nextInt(100);
                shotDamage = rand.nextInt(damageRange + 1);
                shotDamage += weapon.damagePerShot()[0];
            }
            if (returnString == "") {
                return "All your shots at " + target + " missed!\n";
            } else {
                return returnString;
            }
        }
        // } 
        // else {
        //     return target + " is not in range.";
        // }
    }

    String throwObj(String object, String target) {
        int index = playerHas(object);
        String returnString;
        // throw fails because player does not have specified item in inventory
        if (index == -1) {
            returnString = "You don't have a " + object + " in your inventory.\n";
        }
        if (target == this.getName()) { // throw object at self
            returnString = "You toss your " + object + " in the air";
            if (this.inventory.get(index).getItem() == "GRENADE") {
                returnString += ", and it explodes upon hitting the ground at your feet.";
                return kill("GRENADE");
            }
            returnString += " and catch it.\nPlaying catch with yourself?\nPathetic.";
            return returnString;
        }
        // Player targetPlayer = location.getPlayer(this, target);
        Player targetPlayer = new Player("Duncan");
        if (targetPlayer == this) { // fails because specified player is not in the same chunk or is self
            return "You look for " + target + ", but you can't see them anywhere.\n";
        }
        RangedWeapon item = (RangedWeapon) this.inventory.get(index);
        if (!item.canBeThrown()) { // throw fails because specified item cannot be thrown
            return "You think it would be better to hold on to your " + object;
        } else {                 // throw occurs, remove item from inventory
            returnString = "You throw your " + inventory.get(index).getItem() + " at " + target + ".\n";

            int attackProbability = rand.nextInt(100);
            if (attackProbability < item.throwProbability()) { // successful hit
                // deal damage to other player
                returnString = "Your " + item.getItem() + " hit " + target + ", dealing " + String.valueOf(item.throwDamage()) + " damage.\n";
            } else {                                           // miss
                returnString = "Your " + item.getItem() + " misses " + target + ", landing nearby.\n";
            }

            if (item.getItem() != "GRENADE" && item.getItem() != "POTION") { // re-pickup-able items are placed in the chunk
                this.location.addItem(this.inventory.get(index));
                returnString += "You'll need to pick up your " + item.getItem() + " if you want to use it again.\n";
            } else if (item.getItem() == "GRENADE") {                        // grenades do damage, but are not placed in the chunk afterward
                int grenadeDamage = rand.nextInt(45);
                grenadeDamage += 5;
                returnString += "The grenade you threw at " + target + " dealt" + String.valueOf(grenadeDamage) + " damage.\n";
            } else if (item.getItem() == "POTION") {                         // throwing a potion destroys the potion
                returnString += "You throw your " + item.getItem() + ". It shatters on the ground.\n";
            }

            this.inventory.remove(index);
        }


        return returnString;
    }

    public String speak(String message) {
        String sayType = message.substring(0, message.indexOf(' '));
        String sayMessage = message.substring(message.indexOf(' '));

        // WRITE send a sound message to the world/chunck to send to surronding players
        return ("You " + sayType + "\"" + sayMessage + "\"");
    }

    public String look(String direction) {
        // take in data from the world 3
        return ("You look " + direction + " and see ");
    }

    public String dodge() {
        dodging = true;
        return ("You begin dodging attacks.");
    }

    public String listen() {
        //call for sound data at particular chunk

        return ("You stop to listen. Focusing you hear ");
    }

//    public String move(String direction) {
//        return move(direction, "walk");
//    }

    public String move(String direction, String speed) {
        //Send message to world dictating the updated position of the character
        //TODO:recieve new sight and hear data

        boolean outOfBounds = false;
        outOfBounds = World.getInstance(10).movePlayer(this, direction); // move the player in direction

        if(speed == "run") {
            // move again
            outOfBounds = World.getInstance(10).movePlayer(this, direction); // move the player in direction
        }

        if (!outOfBounds) {
//            return ("You " + speed + " " + direction + ". As you stop you see ");// + World.getInstance(10).seenBiomes(getLocation()));
            return ("You " + speed + " " + direction + ". As you stop you see "+ World.getInstance(10).seenBiomes(getLocation()));

        }
        else {
            return ("You " + speed + " " + direction + " and bump into the barrier.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getKills() {
        return this.kills;
    }

    public Chunk getLocation() {
        return this.location;
    }

    public void setLocation(Chunk loc) {
        this.location = loc;
    }

    public boolean isDead() {
        return this.dead;
    }

    // returns index of item in intentory if player has object with given name,
    // returns -1 if object with provided name is not present in player's inventory
    int playerHas(String object) {
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).getItem() == object.toUpperCase()) {
                return i;
            }
        }
        return -1;
    }

    public void damage(int damageVal, String source) {
        this.health -= damageVal;
        if (this.health <= 0) {
            kill(source);
        }
    }

}

