package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.CargoListAdapterKotlin;
import cs2340.garbagecollection.spacetrader.model.Game;
import cs2340.garbagecollection.spacetrader.model.Market;
import cs2340.garbagecollection.spacetrader.model.MarketListAdapterBuy;
import cs2340.garbagecollection.spacetrader.model.Ship;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModelKotlin;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class MarketBuyActivity extends AppCompatActivity {
    private Button sellButton;
    private RecyclerView recyclerView;
    private RecyclerView cargoRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;
    private MarketListAdapterBuy adapter;
    private TextView cargoDisplay;
    private TextView currentCreditsDisplay;
    private MarketViewModelKotlin marketViewModelKotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_screen_buy);

        sellButton = findViewById(R.id.sellButton);
        recyclerView = findViewById(R.id.Goods);
        layoutManager = new LinearLayoutManager(this);
        layoutManager2 = new LinearLayoutManager(this);
        cargoDisplay = findViewById(R.id.openCargoSpots);
        currentCreditsDisplay = findViewById(R.id.moneyLeft);
        cargoRecyclerView = findViewById(R.id.cargoGoods);

        ArrayList<String> goodNamesListTranslated = new ArrayList<>();
        ArrayList<Integer> goodPriceList;

        List<TradeGood> goodsList = Market.getAllBuyableGoods(game.getCurrLocation().getTechnology());
        Log.d("size", goodsList.size()+"");

        for (int i = 0; i < goodsList.size() ; i++) {
            for (int j = 0; j < TradeGood.values().length; j++) {
                if (goodsList.get(i)==(TradeGood.values()[j])) {
                    goodNamesListTranslated.add(getResources().getStringArray(R.array.goodNames)[j]);
                }
            }

        }
        marketViewModelKotlin = new MarketViewModelKotlin(this.getApplication());
        TradeGood[] cargoArray = game.getPlayer().getShip().getCargoArr();
        List<TradeGood> uniqueList = marketViewModelKotlin.uniqueList(cargoArray);
        List<Integer> numGoods = marketViewModelKotlin.numDuplicatesList(uniqueList, cargoArray);
        List<String> translatedCargoList = marketViewModelKotlin.translateGoodsList(uniqueList);
        goodPriceList = (ArrayList<Integer>) marketViewModelKotlin.calcPriceList(goodsList, game.getCurrLocation());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MarketListAdapterBuy(goodNamesListTranslated, goodPriceList, this));
        cargoRecyclerView.setHasFixedSize(true);
        cargoRecyclerView.setLayoutManager(layoutManager2);
        cargoRecyclerView.setAdapter(new CargoListAdapterKotlin(translatedCargoList, numGoods));
        updateTextViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTextViews();
    }

    public void sellPressed(View view) {
        updateTextViews();
        Intent marketSellIntent = new Intent(this, MarketSellActivity.class);
        startActivity(marketSellIntent);
        Log.d("intent", "sellPressed: navigating to sell");
        updateTextViews();
    }

    public void exitPressed(View view) {
        Intent buyPressed = new Intent(this, GameScreenActivity.class);
        finish();
        startActivity(buyPressed);
    }

    private void updateTextViews() {
        currentCreditsDisplay.setText(game.getPlayer().getCredits()+"");
        cargoDisplay.setText(game.getPlayer().getShip().numOpenSlots()+"");
        TradeGood[] cargoArray = game.getPlayer().getShip().getCargoArr();
        List<TradeGood> uniqueList = marketViewModelKotlin.uniqueList(cargoArray);
        List<Integer> numGoods = marketViewModelKotlin.numDuplicatesList(uniqueList, cargoArray);
        List<String> translatedCargoList = marketViewModelKotlin.translateGoodsList(uniqueList);
        cargoRecyclerView.setAdapter(new CargoListAdapterKotlin(translatedCargoList, numGoods));
    }


}
