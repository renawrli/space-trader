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
import cs2340.garbagecollection.spacetrader.model.MarketListAdapter;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModel;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModelKotlin;

public class MarketBuyActivity extends AppCompatActivity implements MarketListAdapter.ItemClickListener {
    private Button sellButton;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MarketListAdapter adapter;
    private MarketListAdapter.ItemClickListener itemClickListener;
    @Override
    public void onItemClick(int position) {
//        Log.d("Click", "onItemClick: "  + position);
//        Intent transactionDialogue = new Intent(this, QuantityTransactionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_screen_buy);

        sellButton = findViewById(R.id.sellButton);
        recyclerView = findViewById(R.id.Goods);
        layoutManager = new LinearLayoutManager(this);

        ArrayList<String> goodNamesList = new ArrayList<>();
        ArrayList<Integer> goodPriceList;

        List<TradeGood> goodsList = Market.getAllBuyableGoods(Game.getCurrLocation().getTechnology());
//        Log.d("size", goodsList.size()+"");
        for (TradeGood tg : goodsList) {
            goodNamesList.add(tg.name());
        }
        MarketViewModelKotlin marketViewModelKotlin = new MarketViewModelKotlin(this.getApplication());
        goodPriceList = (ArrayList<Integer>) marketViewModelKotlin.calcPriceList(goodsList, Game.getCurrLocation());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MarketListAdapter(goodNamesList, goodPriceList, this));
    }

    public void sellPressed(View view) {
        Intent marketSellIntent = new Intent(this, MarketSellActivity.class);
        startActivity(marketSellIntent);
    }

}
