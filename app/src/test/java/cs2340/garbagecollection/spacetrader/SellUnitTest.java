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

public class SellUnitTest {
    private Player player;
    private Planet planet;
    private TradeGood[] cargoExpected;
    private MarketViewModel marketVM;

    @Before
    public void setUp() {
        player = new Player("Uty", 4,4,4,4);
        planet = new Planet("Nigeria", GovernmentType.CYBERNETIC, 10, 10, 50, 50);
        marketVM = new MarketViewModel(new Application());

        int cargoSize = player.getShip().getCargoArr().length;

        cargoExpected = new TradeGood[cargoSize];
    }

    @Test
    public void testSell() {
        Ship ship = player.getShip();
        assertEquals("Cargo is not size 0",0, ship.getSize());

        // populates cargo array
        marketVM.buy(player, TradeGood.NARCOTICS, planet, 3);
        marketVM.buy(player, TradeGood.WATER, planet, 1);
        marketVM.buy(player, TradeGood.FOOD, planet, 1);

        // test sell method, sell multiple
        cargoExpected[0] = null;
        cargoExpected[1] = null;
        cargoExpected[2] = null;
        cargoExpected[3] = TradeGood.WATER;
        cargoExpected[4] = TradeGood.FOOD;

        marketVM.sell(player, TradeGood.NARCOTICS, planet, 3);
        assertEquals("Multiple narcotics sold, all were not removed",
                2, ship.getSize());
        assertArrayEquals(cargoExpected, ship.getCargoArr());


        // sells the rest of the goods
        cargoExpected[3] = null;
        marketVM.sell(player, TradeGood.WATER, planet, 1);
        assertArrayEquals(cargoExpected, ship.getCargoArr());
        assertEquals(1, ship.getSize());

        cargoExpected[4] = null;
        marketVM.sell(player, TradeGood.FOOD, planet, 1);
        assertArrayEquals(cargoExpected, ship.getCargoArr());
        assertEquals(0, ship.getSize());

    }

}
