package cs2340.garbagecollection.spacetrader.model;

/** Represents a Ship owned by the Player **/
class Ship {

    private ShipType shipType;

    /** represents actual cargo **/
    Object[] cargoArr;

    Ship(ShipType shipType) {
        this.shipType = shipType;
        cargoArr = new Object[shipType.getCapacity()];
    }



}
