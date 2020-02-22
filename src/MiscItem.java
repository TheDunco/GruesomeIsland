// Misc items have unique properties that don't align to MeleeWeapon or RangedWeapon specifications

public class MiscItem extends Item {
    private int id;
    private static String[] items = {"TRIDENT", "GRENADE", "HEALTH POTION", "SPEED POTION", "TIN CAN"};

    public String getItem() {
        return items[id];
    }

    public boolean canBeConsumed() {
        if (id == 2 || id == 3) {
            return true;
        }
        return false;
    }

    public boolean canBeThrown() {
        if (id == 2 || id == 3) {
            return false;
        }
        return true;
    }

    public boolean canBeThrown() {
        if (id == 2 || id == 3) {
            return false;
        }
        return true;
    }

    public boolean canBeSwung() {
        if (id == 0) {
            return true;
        }
        return false;
    }

}