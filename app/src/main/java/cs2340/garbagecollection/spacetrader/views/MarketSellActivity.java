package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.Game;
import cs2340.garbagecollection.spacetrader.model.Market;
import cs2340.garbagecollection.spacetrader.model.MarketListAdapterSell;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModelKotlin;

public class MarketSellActivity extends AppCompatActivity {
    private Button buyButton;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MarketListAdapterSell adapter;
    private MarketListAdapterSell.ViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_screen_sell);

        buyButton = findViewById(R.id.buyButton);
        recyclerView = findViewById(R.id.sell_goods);
        layoutManager = new LinearLayoutManager(this);


        ArrayList<String> goodNamesListTranslated = new ArrayList<>();
        ArrayList<Integer> goodPriceList;

        List<TradeGood> goodsList = Market.getAllSellableGoods(Game.getCurrLocation().getTechnology());
        Log.d("sell size", goodsList.size()+"");

        for (int i = 0; i < goodsList.size() ; i++) {
            for (int j = 0; j < TradeGood.values().length; j++) {
                if (goodsList.get(i)==(TradeGood.values()[j])) {
                    goodNamesListTranslated.add(getResources().getStringArray(R.array.goodNames)[j]);
                }
            }
        }

        MarketViewModelKotlin marketViewModelKotlin = new MarketViewModelKotlin(this.getApplication());
        goodPriceList = (ArrayList<Integer>) marketViewModelKotlin.calcPriceList(goodsList, Game.getCurrLocation());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MarketListAdapterSell(goodNamesListTranslated, goodPriceList, this);
        recyclerView.setAdapter(adapter);

    }


    public void buyPressed(View view) {
        Intent buyPressed = new Intent(this, MarketBuyActivity.class);
        startActivity(buyPressed);
        Log.d("intent", "buyPressed: navigate to MarketBuyActivity");

    }

    public void exitPressed(View view) {
        Intent buyPressed = new Intent(this, GameScreenActivity.class);
        finish();
        startActivity(buyPressed);
    }
}
