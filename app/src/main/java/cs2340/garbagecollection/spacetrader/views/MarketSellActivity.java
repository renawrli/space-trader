package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
import android.media.MediaPlayer;
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
import cs2340.garbagecollection.spacetrader.model.Market;
import cs2340.garbagecollection.spacetrader.model.MarketListAdapterSell;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModelKotlin;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class MarketSellActivity extends AppCompatActivity {
    private Button buyButton;
    private RecyclerView recyclerView;
    private RecyclerView cargoRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;
    private MarketListAdapterSell adapter;
    private TextView creditsDisplay;
    private TextView cargoDisplay;
    private MarketViewModelKotlin marketViewModelKotlin;

    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_screen_sell);

        buyButton = findViewById(R.id.buyButton);
        recyclerView = findViewById(R.id.sell_goods);
        layoutManager = new LinearLayoutManager(this);
        layoutManager2 = new LinearLayoutManager(this);
        creditsDisplay = findViewById(R.id.moneyLeftDisplay);
        cargoDisplay = findViewById(R.id.openCargoSpots);
        cargoRecyclerView = findViewById(R.id.cargoGoods);

        ArrayList<String> goodNamesListTranslated = new ArrayList<>();
        ArrayList<Integer> goodPriceList;

        List<TradeGood> goodsList = Market.getAllSellableGoods(game.getCurrLocation().getTechnology());
        Log.d("sell size", goodsList.size()+"");

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
        adapter = new MarketListAdapterSell(goodNamesListTranslated, goodPriceList, this);
        recyclerView.setAdapter(adapter);
        cargoRecyclerView.setHasFixedSize(true);
        cargoRecyclerView.setLayoutManager(layoutManager2);
        cargoRecyclerView.setAdapter(new CargoListAdapterKotlin(translatedCargoList, numGoods));

        updateTextViews();
        // custom music
        mySound = MediaPlayer.create(MarketSellActivity.this,R.raw.backgroundmusic);
        mySound.setLooping(true);
        mySound.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySound.release();
    }
    @Override
    protected void onResume() {
        super.onResume();
        updateTextViews();
    }

    public void buyPressed(View view) {
        updateTextViews();
        Intent buyPressed = new Intent(this, MarketBuyActivity.class);
        startActivity(buyPressed);
        Log.d("intent", "buyPressed: navigate to MarketBuyActivity");
        updateTextViews();


    }

    public void exitPressed(View view) {
        Intent buyPressed = new Intent(this, GameScreenActivity.class);
        finish();
        startActivity(buyPressed);
    }
    private void updateTextViews() {
        creditsDisplay.setText(game.getPlayer().getCredits()+"");
        cargoDisplay.setText(game.getPlayer().getShip().numOpenSlots()+"");
        TradeGood[] cargoArray = game.getPlayer().getShip().getCargoArr();
        List<TradeGood> uniqueList = marketViewModelKotlin.uniqueList(cargoArray);
        List<Integer> numGoods = marketViewModelKotlin.numDuplicatesList(uniqueList, cargoArray);
        List<String> translatedCargoList = marketViewModelKotlin.translateGoodsList(uniqueList);
        cargoRecyclerView.setAdapter(new CargoListAdapterKotlin(translatedCargoList, numGoods));
    }
}
