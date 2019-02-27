package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Difficulty;
import cs2340.garbagecollection.spacetrader.model.Planet;
import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.model.TradeGood;


/**
 * This ViewModel supports activities associated with buying/selling goods in the Marketplace
 */
public class MarketViewModel extends AndroidViewModel {

    public MarketViewModel (@NonNull Application application) {
        super(application);
    }

    // TODO: Fuad must finish this method for class to work
    /** calculates price of a TradeGood at a planet
     *  planet should be the currLocation in Game class since that's the Planet we're selling on
     */
    public int calcPrice(TradeGood good, Planet planet) {
        return good.getBasePrice() + good.getIPL() * (planet.getTechnology().ordinal() - good.getMTLP()) + good.getVar();
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
    public boolean hasGoodsToSell(Player p) {
        // check size of Player's cargo arr
        return p.getShip().getSize() >= 1;
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
        for(int i = 0; i < numGoods; i++) {
            p.getShip().sellCargo(good, numGoods);
        }
    }
}