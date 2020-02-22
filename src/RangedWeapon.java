package src;

public class RangedWeapon extends Item {
    private int type;
    private static String[] weapons = {"RIFLE", "MACHINE GUN", "SHOTGUN", "PISTOL", "LONGBOW"};

    RangedWeapon(int id) {
        super();
        type = id;
    }

    public String getItem() {
        return weapons[id];
    }

    public boolean canBeShot() {
        return true;
    }

}