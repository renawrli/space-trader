package cs2340.garbagecollection.spacetrader.model;

/** Represents a Ship owned by the Player **/
class Ship {

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

    public int getSize() {
        return size;
    }
    /**
     * Removes object sold from ship
     * @param index that object is located in
     * @return Object sold on ship
     */
    public Object remove(int index) {
        Object sold = cargoArr[index];
        size--;
        cargoArr[index] = null;
        return sold;
    }

}
