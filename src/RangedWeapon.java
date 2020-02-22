package src;

public class RangedWeapon extends Item {
    private int type;
    private int ammoCount;
    private static String[] weapons = {"RIFLE", "MACHINE GUN", "SHOTGUN", "PISTOL", "LONGBOW"};

    RangedWeapon(int id) {
        this.type = id;
    }

    public String getItem() {
        return weapons[this.type];
    }

    public boolean canBeShot() {
        return true;
    }

    public int getAmmo() {
        return ammoCount;
    }

    public void decrementAmmo() {
        ammoCount--;
    }

    public int accuracy() {
        switch (this.type) {
            case 0:
                return 85; // rifle
            case 1:
                return 55; // machine gun
            case 2:
                return 85; // shotgun
            case 3:
                return 70; // pistol
            case 4:
                return 80;  // longbow
            default:
                return 0;
        }
    }

    public int[] damagePerShot() {
        switch (this.type) {
            case 0:
                return new int[]{30, 30}; // rifle
            case 1:
                return new int[]{5, 15}; // machine gun
            case 2:
                return new int[]{20, 45}; // shotgun
            case 3:
                return new int[]{20, 20}; // pistol
            case 4:
                return new int[]{15, 25};  // longbow
            default:
                return new int[]{0, 0};
        }
    }

    public int range() {
        switch (this.type) {
            case 0:
                return 2; // rifle
            case 1:
                return 2; // machine gun
            case 2:
                return 1; // shotgun
            case 3:
                return 1; // pistol
            case 4:
                return 3;  // longbow
            default:
                return 0;
        }
    }

}