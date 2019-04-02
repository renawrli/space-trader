package cs2340.garbagecollection.spacetrader.views;

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
import cs2340.garbagecollection.spacetrader.model.Market;
import cs2340.garbagecollection.spacetrader.model.MarketListAdapterBuy;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModelKotlin;
import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class TraderActivity extends AppCompatActivity {
    TextView banner;
    TextView encounterType;
    TextView encounterStatement;
    Button exitButton;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("onCreate", "onCreate: trader activity launched");
        setContentView(R.layout.trader_encounter);

        banner = findViewById(R.id.trader_encounter_banner_text);
        encounterType = findViewById(R.id.trader_label);
        encounterStatement = findViewById(R.id.purchaseQuestion);
        exitButton = findViewById(R.id.leaveTraderButton);

        recyclerView = findViewById(R.id.goods);
        layoutManager = new LinearLayoutManager(this);

        ArrayList<String> goodNamesListTranslated = new ArrayList<>();
        ArrayList<Integer> goodPriceList = new ArrayList<>();

        List<TradeGood> goodsList = Market.getAllBuyableGoods(game.getCurrLocation().getTechnology());
        Log.d("size", goodsList.size()+"");

        for (int i = 0; i < goodsList.size() ; i++) {
            for (int j = 0; j < TradeGood.values().length; j++) {
                if (goodsList.get(i)==(TradeGood.values()[j])) {
                    goodNamesListTranslated.add(getResources().getStringArray(R.array.goodNames)[j]);
                }
            }

        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MarketListAdapterBuy(goodNamesListTranslated, goodPriceList, this));
    }

    public void exitTrader(View view) {
        finish();
    }

}
