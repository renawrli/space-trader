package cs2340.garbagecollection.spacetrader.model;

/**
 * enum for the different types of Ships
 */
public enum ShipType {
    FLEA(5),
    GNAT(15),
    FIREFLY(20),
    MOSQUITO(15),
    BUMBLEBEE(20),
    BEETLE(50),
    HORNET(20),
    GRASSHOPPER(30),
    TERMITE(60),
    WASP(35);

    /** the ship's cargo capacity */
    private int capacity;

    ShipType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
