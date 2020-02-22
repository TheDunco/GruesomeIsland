public class MeleeWeapon extends Item {
    private int type;
    private static String[] weapons = {"ELVISH SWORD", "AXE", "MACHETE", "APPLE II", "CANE"};

    MeleeWeapon(int id) {
        type = id;
    }
    
    public String getItem() {
        return weapons[id];
    }

    public boolean canBeSwung() {
        return true;
    }
}