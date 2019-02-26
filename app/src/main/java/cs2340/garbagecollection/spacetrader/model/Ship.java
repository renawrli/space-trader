package cs2340.garbagecollection.spacetrader.model;

/** Represents a Ship owned by the Player **/
class Ship {

    private ShipType shipType;

    /** represents actual cargo **/
    int[] cargoArr;

    Ship(ShipType shipType) {
        this.shipType = shipType;
        cargoArr = new int[shipType.getCapacity()];
    }

}
