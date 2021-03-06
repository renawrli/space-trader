package cs2340.garbagecollection.spacetrader.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import cs2340.garbagecollection.spacetrader.R
import cs2340.garbagecollection.spacetrader.model.Planet
import cs2340.garbagecollection.spacetrader.model.Player
import cs2340.garbagecollection.spacetrader.model.TradeGood
import java.util.ArrayList


/**
 * This ViewModel supports activities associated with buying/selling goods in the Marketplace
 */
class MarketViewModelKotlin(application: Application) : AndroidViewModel(application) {
    fun calcPriceList(allGoods: List<TradeGood>, planet: Planet): List<Int> {
        val priceList = ArrayList<Int>()
        for (i in allGoods.indices) {
            priceList.add(calcPrice(allGoods[i], planet))
        }
        return priceList
    }
    // TODO: Fuad must finish this method for class to work
    /** calculates price of a TradeGood at a planet
     *  planet should be the currLocation in Game class since that's the Planet we're selling on
     */
    private fun calcPrice(good : TradeGood, planet : Planet) : Int {
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
    fun hasGoodsToSell(p : Player, good: TradeGood, numGoods: Int) : Boolean{
        // check size of Player's cargo arr
        var goodCount : Int = 0
        for (element : TradeGood in p.ship.cargoArr) {
            if(element == good) {
                goodCount++
            }
        }
        return goodCount >= numGoods
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

    /*fun calcPriceList(allGoods: List<TradeGood>, planet: Planet): List<Int> {
        val priceList = ArrayList<Int>()
        for (i in allGoods.indices) {
            priceList.add(calcPrice(allGoods[i], planet))
        }
        return priceList
    }*/

    /** sells good, removes from Player's cargo bay **/
    fun sell(p : Player, good : TradeGood, planet : Planet, numGoods : Int) {
        // increment money and remove from cargoArr
        p.credits = p.credits + numGoods*calcPrice(good, planet)
//        for(i in 1..numGoods) {
//            p.ship.sellCargo(good, numGoods)
//        }
        p.ship.sellCargo(good, numGoods)
    }

    //The following 3 methods are used to display cargo hold in UI
    /** returns a list of unique TradeGoods in the cargo arr  */
    fun uniqueList(cargoArr: Array<TradeGood>): List<TradeGood> {
        val uniqueGoods = ArrayList<TradeGood>()

        for (i in cargoArr.indices) {
            var inUniqueList = false
            if (cargoArr[i] != null) {
                for (j in uniqueGoods.indices) {
                    if (cargoArr[i] == uniqueGoods[j]) {
                        inUniqueList = true
                    }
                }
                if (!inUniqueList) {
                    uniqueGoods.add(cargoArr[i])
                }
            }
        }
        System.out.println("uniqueGoods $uniqueGoods")
        return uniqueGoods
    }
    /** translates a List of TradeGoods into a List of the translated String equivalents **/
    fun numDuplicatesList(uniqueGoods : List<TradeGood>, cargoArr: Array<TradeGood>) : List<Int> {
        val countList = ArrayList<Int>()
        for(i in uniqueGoods.indices) {
            var counter = 0
            for (j in cargoArr.indices) {
                if (uniqueGoods[i] == cargoArr[j]) {
                    counter++
                }
            }
            countList.add(counter)
        }
        System.out.println("num $countList")
        return countList
    }

    /** translates a List of TradeGoods into a List of the translated String equivalents  */
     fun translateGoodsList(goodList: List<TradeGood>): ArrayList<String> {
        val cargoNames = ArrayList<String>()
        for (i in goodList.indices) {
            for (j in 0 until TradeGood.values().size) {
                if (goodList[i] != null && goodList[i] == TradeGood.values()[j]) {
                    cargoNames.add(this.getApplication<Application>().resources.getStringArray(R.array.goodNames)[j])
                }
            }

        }
        System.out.println("translated " + cargoNames)
        return cargoNames
    }



}
