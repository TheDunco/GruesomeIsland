package src;

public class Item {

    public Item() {}

    public String getItem() {
        return "NULL";
    }

    public boolean canBeShot() {
        return false;
    }

    public boolean canBeSwung() {
        return false;
    }

    public boolean canBeConsumed() {
        return false;
    }

    public boolean canBeThrown() {
        return true;
    }

    public int getAmmo() {
        return -1;
    }
    public int throwDamage() {
        return 0;
    }

    public int throwProbability() {
        return 0;
    }

    public void decrementAmmo() {
        
    }

    public int[] damagePerShot() {
        int[] array = new int[]{0,0};
        return array;
    }

    public int accuracy() {
        return 0;
    }

    public int range() {
        return 0;
    }
}