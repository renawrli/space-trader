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
import cs2340.garbagecollection.spacetrader.model.MarketListAdapterBuy;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModel;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModelKotlin;

public class MarketBuyActivity extends AppCompatActivity {
    private Button sellButton;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MarketListAdapterBuy adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_screen_buy);

        sellButton = findViewById(R.id.sellButton);
        recyclerView = findViewById(R.id.Goods);
        layoutManager = new LinearLayoutManager(this);

        ArrayList<String> goodNamesListTranslated = new ArrayList<>();
        ArrayList<Integer> goodPriceList;

        List<TradeGood> goodsList = Market.getAllBuyableGoods(Game.getCurrLocation().getTechnology());
        Log.d("size", goodsList.size()+"");

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
        recyclerView.setAdapter(new MarketListAdapterBuy(goodNamesListTranslated, goodPriceList, this));
    }

    public void sellPressed(View view) {
        Intent marketSellIntent = new Intent(this, MarketSellActivity.class);
        startActivity(marketSellIntent);
        Log.d("intent", "sellPressed: navigating to sell");

    }

}
