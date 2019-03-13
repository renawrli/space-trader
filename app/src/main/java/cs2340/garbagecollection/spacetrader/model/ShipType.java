package cs2340.garbagecollection.spacetrader.model;

/**
 * enum for the different types of Ships
 */
public enum ShipType {
    FLEA(5, 20),
    GNAT(15, 14),
    FIREFLY(20, 17),
    MOSQUITO(15, 13),
    BUMBLEBEE(20, 15),
    BEETLE(50, 14),
    HORNET(20, 16),
    GRASSHOPPER(30, 15),
    TERMITE(60, 13),
    WASP(35, 14);

    /** the ship's cargo capacity */
    private int capacity;

    /** the ship's fuel capacity */
    private int fuelCapacity;

    ShipType(int capacity, int fuelCapacity) {
        this.capacity = capacity;
        this.fuelCapacity = fuelCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }
}
