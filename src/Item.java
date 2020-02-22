public class Item {
    private String name;

    Item(String Name) {name = Name;}

    public String getItem() {
        return name;
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