package cs2340.garbagecollection.spacetrader;

import android.app.Application;

import org.junit.Before;
import org.junit.Test;

import cs2340.garbagecollection.spacetrader.model.Planet;
import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.model.Ship;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.model.GovernmentType;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModel;

import static org.junit.Assert.*;

/** Andrew's JUnit to test the buy() method in MarketViewModel **/
public class BuyUnitTest {
    private Player player;
    private Planet planet;
    private MarketViewModel marketVM;
    private TradeGood[] expectedResult;
    @Before
    public void setUp() {
        player = new Player("Antony", 4, 4, 4, 4);
        planet = new Planet("Asgard", GovernmentType.ANARCHY, 5, 5, 0, 0);
        marketVM = new MarketViewModel(new Application());
        expectedResult = new TradeGood[player.getShip().getShipType().getCapacity()];
    }
    @Test
    public void testBuy() {
        Ship ship = player.getShip();
        assertEquals(0, ship.getSize());
        // adding one good
        marketVM.buy(player, TradeGood.FOOD, planet, 1);
        expectedResult[0] = TradeGood.FOOD;
        assertEquals(1, ship.getSize());
        assertArrayEquals(expectedResult, ship.getCargoArr());
        // adding multiple goods
        marketVM.buy(player, TradeGood.FURS, planet, 7);
        for (int i = 0; i < 7; i++) {
            expectedResult[i + 1] = TradeGood.FURS;
        }
        assertEquals(8, ship.getSize());
        assertArrayEquals(expectedResult, ship.getCargoArr());
    }
}
