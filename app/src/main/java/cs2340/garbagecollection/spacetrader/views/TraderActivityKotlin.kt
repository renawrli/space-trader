package cs2340.garbagecollection.spacetrader.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

import java.util.ArrayList

import cs2340.garbagecollection.spacetrader.R
import cs2340.garbagecollection.spacetrader.model.Market
import cs2340.garbagecollection.spacetrader.model.MarketListAdapterBuy
import cs2340.garbagecollection.spacetrader.model.TradeGood
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModelKotlin
import cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game

class TraderActivityKotlin : AppCompatActivity() {
    internal var marketViewModelKotlin: MarketViewModelKotlin = MarketViewModelKotlin(this.application)

    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("onCreate", "onCreate: trader activity launched")
        setContentView(R.layout.trader_encounter)

        var banner:TextView = findViewById(R.id.trader_encounter_banner_text)
        var encounterType:TextView = findViewById(R.id.trader_label)
        var encounterStatement:TextView = findViewById(R.id.purchaseQuestion)
        var exitButton:Button = findViewById(R.id.leaveTraderButton)

        recyclerView = findViewById(R.id.goods)
        layoutManager = LinearLayoutManager(this)

        val goodNamesListTranslated = ArrayList<String>()
        var goodPriceList = ArrayList<Int>()

        val goodsList = Market.getAllBuyableGoods(game.currLocation.technology)
        Log.d("size", goodsList.size.toString() + "")

        for (i in goodsList.indices) {
            for (j in 0 until TradeGood.values().size) {
                if (goodsList[i] == TradeGood.values()[j]) {
                    goodNamesListTranslated.add(resources.getStringArray(R.array.goodNames)[j])
                }
            }

        }
        goodPriceList = marketViewModelKotlin.calcPriceList(goodsList, game.currLocation) as ArrayList<Int>

        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = MarketListAdapterBuy(goodNamesListTranslated, goodPriceList, this)
    }

    fun exitTrader(view: View) {
        val intent = Intent(view.context, GameScreenActivity::class.java)
        finish()
        view.context.startActivity(intent)
    }

}
