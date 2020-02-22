package src;

import java.util.Scanner;

public class Player {
    private String name;
    private int health;
    private int kills;

    Player(String Name) {
        this.name = Name;
        this.health = 100;
        this.kills = 0;
    }

    public String getName() {
        return this.name;
    }

}