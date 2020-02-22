package src;

public class Item {
    private String name;

    // constructor
    public Item(String Name) {this.name = Name;}

    public String getItem() {
        return this.name;
    }

    public String throwObj() {
        return " THROWN ";
    }

    public String drop() {
        return " DROPPED ";
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

}