package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Difficulty;
import cs2340.garbagecollection.spacetrader.model.Planet;
import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.model.Game;

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
        return -1;
    }

    // TODO: Finish these 5 methods after calcPrice() is finished
    /** checks to see if player has enough money to buy the good **/
    public boolean enoughMoney(Player p, TradeGood good) {
        // will compare Player's credits to the result of calcPrice(good, currLocation)
        return false;
    }

    /** checks to see if player has enough cargo space to buy the good **/
    public boolean enoughSpaceToBuy(Player p) {
        // check size of cargoArr
        return false;
    }

    /** returns true if the Player has goods to sell, false if not **/
    public boolean hasGoodsToSell(Player p) {
        // check size of Player's cargo arr
        return false;
    }

    /**
     * The following two methods should only be used after checking buying/selling is allowed
     */

    /** buys good and adds to Player's cargo bay **/
    public void buy(Player p, TradeGood good) {
        // decrement money and add to cargoArr
    }

    /** sells good, removes from Player's cargo bay **/
    public void sell(Player p, TradeGood good) {
        // increment money and remove from cargoArr
    }
}
