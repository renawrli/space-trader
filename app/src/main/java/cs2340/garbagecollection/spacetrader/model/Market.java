package cs2340.garbagecollection.spacetrader.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Market {
    /** location of market, x and y coordinates */
    private final int x;
    private final int y;

    /** price of goods */
    private double price;

    public Market(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** returns a List of all goods you can buy on a planet
     * @param planetTLevel - TechLevel of the planet the Player is on
     * **/
    public static List<TradeGood> getAllBuyableGoods(TechLevel planetTLevel) {
        int planetTechLevel = planetTLevel.ordinal();
        List<TradeGood> goodsList = new ArrayList<>();

        for(TradeGood t: TradeGood.values()) {
            if (t.getMTLP() <= planetTechLevel) {
                goodsList.add(t);
            }
        }
        return goodsList;
    }

    /**returns a List of all goods you can buy on a planet
     * @param planetTLevel - TechLevel of the planet the Player is onS
     * **/
    public static List<TradeGood> getAllSellableGoods(TechLevel planetTLevel) {
        int planetTechLevel = planetTLevel.ordinal();
        List<TradeGood> goodsList = new ArrayList<>();

        for(TradeGood t: TradeGood.values()) {
            if (t.getMTLU() <= planetTechLevel) {
                goodsList.add(t);
            }
        }
        return goodsList;
    }

    /** getters and setters **/
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
