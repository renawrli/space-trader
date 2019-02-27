package cs2340.garbagecollection.spacetrader.viewmodel

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
class MarketViewModelKotlin(application: Application) : AndroidViewModel(application) {

    // TODO: Fuad must finish this method for class to work
    /** calculates price of a TradeGood at a planet
     *  planet should be the currLocation in Game class since that's the Planet we're selling on
     */
    fun calcPrice(good : TradeGood, planet : Planet) : Int {
        return good.basePrice + good.ipl * (planet.technology.ordinal - good.mtlp) + good.getVar()
    }

    // TODO: Finish these 5 methods after calcPrice() is finished
    /** checks to see if player has enough money to buy the good **/
    fun enoughMoney(p : Player, good : TradeGood,planet : Planet, numGoods : Int) : Boolean {
        // will compare Player's credits to the result of calcPrice(good, currLocation)
        return p.credits >= numGoods*calcPrice(good, planet)
    }

    /** checks to see if player has enough cargo space to buy the good **/
    fun enoughSpaceToBuy(p : Player, numGoods : Int) : Boolean{
        // check size of cargoArr
        return numGoods <= p.ship.numOpenSlots()
    }

    /** returns true if the Player has goods to sell, false if not **/
    fun hasGoodsToSell(p : Player) : Boolean{
        // check size of Player's cargo arr
        return p.ship.size >= 1
    }

    /**
     * The following two methods should only be used after checking buying/selling is allowed
     */

    /** buys good and adds to Player's cargo bay **/
    fun buy(p : Player, good : TradeGood, planet : Planet, numGoods : Int) {
        // decrement money and add to cargoArr
        p.credits =p.credits - numGoods*calcPrice(good, planet)
        for(i in 1..numGoods) {
        p.ship.addCargo(good)
    }
    }

    /** sells good, removes from Player's cargo bay **/
    fun sell(p : Player, good : TradeGood, planet : Planet, numGoods : Int) {
        // increment money and remove from cargoArr
        p.credits = p.credits + numGoods*calcPrice(good, planet);
        for(i in 1..numGoods) {
        p.ship.sellCargo(good, numGoods)
    }
    }
}
