package cs2340.garbagecollection.spacetrader.model;

/** Represents a Ship owned by the Player **/
public class Ship {

    private ShipType shipType;

    /** represents actual cargo **/
    private Object[] cargoArr;
    private int size = 0;

    Ship(ShipType shipType) {
        this.shipType = shipType;
        cargoArr = new Object[shipType.getCapacity()];
    }

    /** add's cargo to the end of backing array **/
    public void addCargo(Object cargo) {
        cargoArr[size] = cargo;
        size++;
    }

    /**
     * Removes object sold from ship
     * @param index that object is located in
     * @return Object sold on ship
     */
    public Object sellCargo(int index) {
        Object sold = cargoArr[index];
        size--;
        cargoArr[index] = null;
        return sold;
    }

    public void sellCargo(TradeGood good, int numToSell) {
        int cleared = 0;
        for(int i = 0; i < cargoArr.length; i++) {
            if(cargoArr[i] == good && cleared < numToSell) {
                cargoArr[i] = null;
                size--;
            }
        }
        Object[] newCargoArr = new Object[cargoArr.length];
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
    public Object[] getCargoArr() {
        return cargoArr;
    }

    public int numOpenSlots() {
        return cargoArr.length - size;
    }

}
