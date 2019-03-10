package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.Difficulty;
import cs2340.garbagecollection.spacetrader.model.Planet;
import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.model.TradeGood;

import java.util.ArrayList;
import java.util.List;

/**
 * This ViewModel supports activities associated with buying/selling goods in the Marketplace
 */
public class MarketViewModel extends AndroidViewModel {
    //these 3 variables should be in the View
//    List<TradeGood> uniqueGoods = new ArrayList<>();
//    List<Integer> goodCounts = new ArrayList<>();
//    List<String> translatedGoods = new ArrayList<>();

    public MarketViewModel (@NonNull Application application) {
        super(application);
    }

    //The following 3 methods are used to display cargo hold in UI
    /** returns a list of unique TradeGoods in the cargo arr **/
    public List<TradeGood> uniqueList(TradeGood[] cargoArr) {
        List<TradeGood> uniqueGoods = new ArrayList<>();

        for (int i = 0; i < cargoArr.length; i++) {
            boolean inUniqueList = false;
            if(cargoArr[i] != null) {
                for (int j = 0; j < uniqueGoods.size(); j++) {
                    if(cargoArr[i].equals(uniqueGoods.get(j))) {
                        inUniqueList = true;
                    }
                }
                if(!inUniqueList) {
                    uniqueGoods.add(cargoArr[i]);
                }
            }
        }
        return uniqueGoods;
    }

    /** returns a list of the number of duplicates of each TradeGood **/
    public List<Integer> numDuplicatesList(List<TradeGood> uniqueGoods, TradeGood[] cargoArr) {
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < uniqueGoods.size(); i++) {
            int counter = 0;
            for (int j = 0; j < cargoArr.length; j++) {
                if (uniqueGoods.get(i).equals(cargoArr[j])) {
                    counter++;
                }
            }
            countList.add(counter);
        }
        return countList;
    }

    /** translates a List of TradeGoods into a List of the translated String equivalents **/
    private ArrayList<String> translateGoodsList(List<TradeGood> goodList) {
        ArrayList<String> cargoNames = new ArrayList<>();
        for (int i = 0; i < goodList.size(); i++) {
            for (int j = 0; j < TradeGood.values().length; j++) {
                if (goodList.get(i) != null && goodList.get(i) == (TradeGood.values()[j])) {
                    cargoNames.add(this.getApplication().getResources().getStringArray(R.array.goodNames)[j]);
                }
            }

        }
        return cargoNames;
    }

    // TODO: Fuad must finish this method for class to work
    /** calculates price of a TradeGood at a planet
     *  planet should be the currLocation in Game class since that's the Planet we're selling on
     */
    public static int calcPrice(TradeGood good, Planet planet) {
        return good.getBasePrice() + good.getIPL() * (planet.getTechnology().ordinal() - good.getMTLP()) + good.getVar();
    }

    /**
     * Returns a List of prices
     * @param allGoods - TradeGoods you want to know the prices of
     * @param planet - planet you are selling on
     * @return a List with corresponding prices to each TradeGood in allGoods
     */
    public static List<Integer> calcPriceList(List<TradeGood> allGoods, Planet planet) {
        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < allGoods.size(); i++) {
            priceList.add(calcPrice(allGoods.get(i), planet));
        }
        return priceList;
    }

    // TODO: Finish these 5 methods after calcPrice() is finished
    /** checks to see if player has enough money to buy the good **/
    public boolean enoughMoney(Player p, TradeGood good, Planet planet, int numGoods) {
        // will compare Player's credits to the result of calcPrice(good, currLocation)
        return p.getCredits() >= numGoods*calcPrice(good, planet);
    }

    /** checks to see if player has enough cargo space to buy the good **/
    public boolean enoughSpaceToBuy(Player p, int numGoods) {
        // check size of cargoArr
        return numGoods <= p.getShip().numOpenSlots();
    }

    /** returns true if the Player has goods to sell, false if not **/
    public boolean hasGoodsToSell(Player p, TradeGood good, int numGoods) {
        // check size of Player's cargo arr
        int goodCount = 0;
        for (TradeGood element : p.getShip().getCargoArr()) {
            if(element == good) {
                goodCount++;
            }
        }
        return goodCount >= numGoods;
    }

    /**
     * The following two methods should only be used after checking buying/selling is allowed
     */

    /** buys good and adds to Player's cargo bay **/
    public void buy(Player p, TradeGood good, Planet planet, int numGoods) {
        // decrement money and add to cargoArr
        p.setCredits(p.getCredits() - numGoods*calcPrice(good, planet));
        for(int i = 0; i < numGoods; i++) {
            p.getShip().addCargo(good);
        }
    }

    /** sells good, removes from Player's cargo bay **/
    public void sell(Player p, TradeGood good, Planet planet, int numGoods) {
        // increment money and remove from cargoArr
        p.setCredits(p.getCredits() + numGoods*calcPrice(good, planet));
//        for(int i = 0; i < numGoods; i++) {
//            p.getShip().sellCargo(good, numGoods);
//        }
        p.getShip().sellCargo(good, numGoods);
    }

    /**
     * Displays list of cargo from an array to ArrayList,
     * if null it is not added
     * @param cargo all the cargo on the ship including null
     * @return cargoNames not null
     */
//    private ArrayList<String> cargoDisplayList(TradeGood[] cargo) {
//        ArrayList<String> cargoNames = new ArrayList<>();
//        for (int i = 0; i < cargo.length ; i++) {
//            for (int j = 0; j < TradeGood.values().length; j++) {
//                if (cargo[i] != null && cargo[i]==(TradeGood.values()[j])) {
//                    cargoNames.add(this.getApplication().getResources().getStringArray(R.array.goodNames)[j]);
//                }
//            }
//
//        }
//        return cargoNames;
//    }

}
