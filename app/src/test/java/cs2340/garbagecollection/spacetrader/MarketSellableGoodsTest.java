package cs2340.garbagecollection.spacetrader.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Philena's JUnit Test for the getAllSellableGoodsMethod in Market Class
 */
public class MarketSellableGoodsTest {
    @Test
    public void getAllSellableGoods() {

        Planet planetA = new Planet("Test", 1, 1, TechLevel.HiTech, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet planetB = new Planet("Test", 1, 1, TechLevel.PreAgriculture, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet planetC = new Planet("Test", 1, 1, TechLevel.Renaissance, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet planetD = new Planet("Test", 1, 1, TechLevel.Agriculture, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet planetE = new Planet("Test", 1, 1, TechLevel.Medieval, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet planetF = new Planet("Test", 1, 1, TechLevel.EarlyIndustrial, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet planetG = new Planet("Test", 1, 1, TechLevel.Industrial, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet planetH = new Planet("Test", 1, 1, TechLevel.PostIndustrial, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        List<TradeGood> ePlanet1 = new ArrayList<>();

        //adds trade goods to expected planet 1
        for (TradeGood good : TradeGood.values()) {
            ePlanet1.add(good);
        }

        List<TradeGood> ePlanet2 = new ArrayList<>();
        ePlanet2.add(TradeGood.WATER);
        ePlanet2.add(TradeGood.FURS);

        List<TradeGood> ePlanet3 = new ArrayList<>();
        ePlanet3.add(TradeGood.WATER);
        ePlanet3.add(TradeGood.FURS);
        ePlanet3.add(TradeGood.FOOD);
        ePlanet3.add(TradeGood.ORE);
        ePlanet3.add(TradeGood.GAMES);
        ePlanet3.add(TradeGood.FIREARMS);

        List<TradeGood> ePlanet4 = new ArrayList<>();
        ePlanet4.add(TradeGood.WATER);
        ePlanet4.add(TradeGood.FURS);
        ePlanet4.add(TradeGood.FOOD);

        List<TradeGood> ePlanet5 = new ArrayList<>();
        ePlanet5.add(TradeGood.WATER);
        ePlanet5.add(TradeGood.FURS);
        ePlanet5.add(TradeGood.FOOD);
        ePlanet5.add(TradeGood.ORE);

        List<TradeGood> ePlanet6 = new ArrayList<>();
        ePlanet6.add(TradeGood.WATER);
        ePlanet6.add(TradeGood.FURS);
        ePlanet6.add(TradeGood.FOOD);
        ePlanet6.add(TradeGood.ORE);
        ePlanet6.add(TradeGood.GAMES);
        ePlanet6.add(TradeGood.FIREARMS);
        ePlanet6.add(TradeGood.MEDICINE);
        ePlanet6.add(TradeGood.MACHINES);

        List<TradeGood> ePlanet7 = new ArrayList<>();
        ePlanet7.add(TradeGood.WATER);
        ePlanet7.add(TradeGood.FURS);
        ePlanet7.add(TradeGood.FOOD);
        ePlanet7.add(TradeGood.ORE);
        ePlanet7.add(TradeGood.GAMES);
        ePlanet7.add(TradeGood.FIREARMS);
        ePlanet7.add(TradeGood.MEDICINE);
        ePlanet7.add(TradeGood.MACHINES);
        ePlanet7.add(TradeGood.NARCOTICS);

        List<TradeGood> actualPlanet1 = Market.getAllSellableGoods(planetA.getTechnology());
        assertEquals(ePlanet1, actualPlanet1);

        List<TradeGood> actualPlanet2 = Market.getAllSellableGoods(planetB.getTechnology());
        assertEquals(ePlanet2, actualPlanet2);

        List<TradeGood> actualPlanet3 = Market.getAllSellableGoods(planetC.getTechnology());
        assertEquals(ePlanet3, actualPlanet3);

        List<TradeGood> actualPlanet4 = Market.getAllSellableGoods(planetD.getTechnology());
        assertEquals(ePlanet4, actualPlanet4);

        List<TradeGood> actualPlanet5 = Market.getAllSellableGoods(planetE.getTechnology());
        assertEquals(ePlanet5, actualPlanet5);

        List<TradeGood> actualPlanet6 = Market.getAllSellableGoods(planetF.getTechnology());
        assertEquals(ePlanet6, actualPlanet6);

        List<TradeGood> actualPlanet7 = Market.getAllSellableGoods(planetG.getTechnology());
        assertEquals(ePlanet7, actualPlanet7);

        List<TradeGood> actualPlanet8 = Market.getAllSellableGoods(planetH.getTechnology());
        assertEquals(ePlanet1, actualPlanet8);

    }
}
