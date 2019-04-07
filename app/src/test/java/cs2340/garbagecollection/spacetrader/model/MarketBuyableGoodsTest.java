package cs2340.garbagecollection.spacetrader.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Author: Fuad Youssef
 * A JUnit Test for the getAllBuyableGoodsMethod in Market Class
 */
public class MarketBuyableGoodsTest {

    @Test
    public void getAllBuyableGoods() {
        //the planets made to test
        Planet testPlanet1 = new Planet("Test", 1, 1, TechLevel.HiTech, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet testPlanet2 = new Planet("Test", 1, 1, TechLevel.PreAgriculture, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet testPlanet3 = new Planet("Test", 1, 1, TechLevel.Renaissance, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet testPlanet4 = new Planet("Test", 1, 1, TechLevel.Agriculture, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet testPlanet5 = new Planet("Test", 1, 1, TechLevel.Medieval, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet testPlanet6 = new Planet("Test", 1, 1, TechLevel.EarlyIndustrial, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet testPlanet7 = new Planet("Test", 1, 1, TechLevel.Industrial, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        Planet testPlanet8 = new Planet("Test", 1, 1, TechLevel.PostIndustrial, GovernmentType.ANARCHY, Resources.NOSPECIALRESOURCES, 1,1);
        List<TradeGood> expectPlanet1 = new ArrayList<>();
        //adds all trade goods to expected planet 1 because all goods are buyable at planet 1
        //also the expected list for post Industrial planets so same for planet 8
        for (TradeGood good : TradeGood.values()) {
            expectPlanet1.add(good);
        }
        List<TradeGood> expectPlanet2 = new ArrayList<>();
        //planet 2 should only be able to sell water and furs
        expectPlanet2.add(TradeGood.WATER);
        expectPlanet2.add(TradeGood.FURS);

        List<TradeGood> expectPlanet3 = new ArrayList<>();
        //planet 3 should be able to sell water, furs, ore, games, and firearms
        expectPlanet3.add(TradeGood.WATER);
        expectPlanet3.add(TradeGood.FURS);
        expectPlanet3.add(TradeGood.FOOD);
        expectPlanet3.add(TradeGood.ORE);
        expectPlanet3.add(TradeGood.GAMES);
        expectPlanet3.add(TradeGood.FIREARMS);

        List<TradeGood> expectPlanet4 = new ArrayList<>();
        //planet 4 should be able to sell water, furs, and food
        expectPlanet4.add(TradeGood.WATER);
        expectPlanet4.add(TradeGood.FURS);
        expectPlanet4.add(TradeGood.FOOD);

        List<TradeGood> expectPlanet5 = new ArrayList<>();
        //planet 5 should be able to sell water, furs, food, and ore
        expectPlanet5.add(TradeGood.WATER);
        expectPlanet5.add(TradeGood.FURS);
        expectPlanet5.add(TradeGood.FOOD);
        expectPlanet5.add(TradeGood.ORE);

        List<TradeGood> expectPlanet6 = new ArrayList<>();
        //planet 6 should be able to sell water, furs, food, ore, games, firearms, medicine, and machines
        expectPlanet6.add(TradeGood.WATER);
        expectPlanet6.add(TradeGood.FURS);
        expectPlanet6.add(TradeGood.FOOD);
        expectPlanet6.add(TradeGood.ORE);
        expectPlanet6.add(TradeGood.GAMES);
        expectPlanet6.add(TradeGood.FIREARMS);
        expectPlanet6.add(TradeGood.MEDICINE);
        expectPlanet6.add(TradeGood.MACHINES);

        List<TradeGood> expectPlanet7 = new ArrayList<>();
        //planet 7 should be able to sell water, furs, food, ore, games, firearms, medicine, machines, and narcotics
        expectPlanet7.add(TradeGood.WATER);
        expectPlanet7.add(TradeGood.FURS);
        expectPlanet7.add(TradeGood.FOOD);
        expectPlanet7.add(TradeGood.ORE);
        expectPlanet7.add(TradeGood.GAMES);
        expectPlanet7.add(TradeGood.FIREARMS);
        expectPlanet7.add(TradeGood.MEDICINE);
        expectPlanet7.add(TradeGood.MACHINES);
        expectPlanet7.add(TradeGood.NARCOTICS);

        List<TradeGood> actualPlanet1 = Market.getAllBuyableGoods(testPlanet1.getTechnology());
        assertEquals(expectPlanet1, actualPlanet1);

        List<TradeGood> actualPlanet2 = Market.getAllBuyableGoods(testPlanet2.getTechnology());
        assertEquals(expectPlanet2, actualPlanet2);

        List<TradeGood> actualPlanet3 = Market.getAllBuyableGoods(testPlanet3.getTechnology());
        assertEquals(expectPlanet3, actualPlanet3);

        List<TradeGood> actualPlanet4 = Market.getAllBuyableGoods(testPlanet4.getTechnology());
        assertEquals(expectPlanet4, actualPlanet4);

        List<TradeGood> actualPlanet5 = Market.getAllBuyableGoods(testPlanet5.getTechnology());
        assertEquals(expectPlanet5, actualPlanet5);

        List<TradeGood> actualPlanet6 = Market.getAllBuyableGoods(testPlanet6.getTechnology());
        assertEquals(expectPlanet6, actualPlanet6);

        List<TradeGood> actualPlanet7 = Market.getAllBuyableGoods(testPlanet7.getTechnology());
        assertEquals(expectPlanet7, actualPlanet7);

        List<TradeGood> actualPlanet8 = Market.getAllBuyableGoods(testPlanet8.getTechnology());
        assertEquals(expectPlanet1, actualPlanet8);

    }
}