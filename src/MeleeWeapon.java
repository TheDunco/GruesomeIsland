package src;

public class MeleeWeapon extends Item {
    private int type;
    private static String[] weapons = {"ELVISH SWORD", "AXE", "MACHETE", "APPLE II", "CANE"};

    public MeleeWeapon(int id) {
        super();
        this.type = id;

    }

    public String getItem() {
        return weapons[this.type];
    }

    public boolean canBeSwung() {
        return true;
    }
}