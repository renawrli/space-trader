package cs2340.garbagecollection.spacetrader.model;

/** Represents a Ship owned by the Player **/
public class Ship {

    private ShipType shipType;

    /** represents actual cargo **/
    private TradeGood[] cargoArr;
    private int size = 0;

    Ship(ShipType shipType) {
        this.shipType = shipType;
        cargoArr = new TradeGood[shipType.getCapacity()];
    }

    /** add's cargo to the end of backing array **/
    public void addCargo(TradeGood cargo) {
        cargoArr[size] = cargo;
        size++;
    }

    /**
     * Sells a specified amount of goods from the cargoArr.
     * @param good - TradeGood to sell
     * @param numToSell - number of goods to sell
     */
    public void sellCargo(TradeGood good, int numToSell) {
        int cleared = 0;
        for(int i = 0; i < cargoArr.length; i++) {
            if(cargoArr[i] == good && cleared < numToSell) {
                cargoArr[i] = null;
                cleared++;
                size--;
            }
        }
        TradeGood[] newCargoArr = new TradeGood[cargoArr.length];
        for(int i = 0; i < cargoArr.length; i++) {
            if(cargoArr[i] != null) {
                newCargoArr[i] = cargoArr[i];
            }
        }
        cargoArr = newCargoArr;
    }

    public int getSize() {
        return size;
    }

    /** returns a List of all Objects in the cargo bay on the ship **/
    public TradeGood[] getCargoArr() {
        return cargoArr;
    }

    public int numOpenSlots() {
        return cargoArr.length - size;
    }

}
