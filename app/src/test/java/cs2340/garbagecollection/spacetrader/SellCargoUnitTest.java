package cs2340.garbagecollection.spacetrader;

import org.junit.Before;
import org.junit.Test;

import cs2340.garbagecollection.spacetrader.model.Ship;
import cs2340.garbagecollection.spacetrader.model.ShipType;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import static org.junit.Assert.*;

/** Rena's JUnit tests**/
public class SellCargoUnitTest {
    private Ship ship;
    private TradeGood[] cargoArray;

    @Before
    public void setup() {
        ship = new Ship(ShipType.FLEA);
        for (int i = 0; i < 2; i++) {
            ship.addCargo(TradeGood.FOOD);
        }
        for (int i = 0; i < 2; i++) {
            ship.addCargo(TradeGood.FURS);
        }
        ship.addCargo(TradeGood.GAMES);

        cargoArray = ship.getCargoArr();
    }

    @Test
    public void testNoCargo() {
        ship.sellCargo(TradeGood.GAMES, 0);
        assertEquals(ship.getSize(), 5);
        assertArrayEquals(cargoArray, ship.getCargoArr());
    }

    @Test
    public void testSellAllCargo() {
        ship.sellCargo(TradeGood.FOOD, 2);
        assertEquals(ship.getSize(), 3);
        for (int i = 0; i < cargoArray.length; i++) {
            if (cargoArray[i] != null && cargoArray[i].equals(TradeGood.FOOD))
                cargoArray[i] = null;
        }
        assertArrayEquals(ship.getCargoArr(), cargoArray);
    }

    @Test
    public void testSellCargoGeneral() {
        cargoArray = new TradeGood[] {null, TradeGood.FOOD, null, TradeGood.FURS, null};
        ship.sellCargo(TradeGood.FOOD, 1);
        ship.sellCargo(TradeGood.FURS, 1);
        ship.sellCargo(TradeGood.GAMES, 1);
        assertEquals(ship.getSize(), 2);
        assertArrayEquals(cargoArray, ship.getCargoArr());
    }

}
