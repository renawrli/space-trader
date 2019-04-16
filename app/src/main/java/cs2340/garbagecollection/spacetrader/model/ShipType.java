package cs2340.garbagecollection.spacetrader.model;

/**
 * enum for the different types of Ships
 */
public enum ShipType {
    FLEA(5, 20, 100),
    GNAT(15, 14, 200),
    FIREFLY(20, 17, 1000),
    MOSQUITO(15, 13,2000),
    BUMBLEBEE(20, 15, 3000),
    BEETLE(50, 14, 6000),
    HORNET(20, 16, 6000),
    GRASSHOPPER(30, 15, 10000),
    TERMITE(60, 13, 10000),
    WASP(35, 14, 15000);

    /** the ship's cargo capacity */
    private int cargoCapacity;

    /** the ship's fuel capacity */
    private int fuelCapacity;
    private int creditCost;
    ShipType(int capacity, int fuelCapacity, int creditCost) {
        this.cargoCapacity = capacity;
        this.fuelCapacity = fuelCapacity;
        this.creditCost = creditCost;
    }
    public int getCreditCost() { return creditCost;}

    public int getCapacity() {
        return cargoCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }
}
