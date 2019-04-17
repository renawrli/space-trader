package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.viewmodel.DroughtViewModel;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModel;
import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class DroughtActivity extends AppCompatActivity {
    DroughtViewModel droughtVM;
    MarketViewModel marketVM;
    TextView banner;
    TextView encounterType;
    TextView encounterStatement;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drought_encounter);
        Log.d("onCreate", "onCreate: drought activity launched");

        droughtVM = new DroughtViewModel(getApplication());
        marketVM = new MarketViewModel(getApplication());

        banner = findViewById(R.id.drought_encounter_banner_text);
        encounterType = findViewById(R.id.drought_label);
        encounterStatement = findViewById(R.id.drought_encounter_statement);
        exitButton = findViewById(R.id.leaveDroughtButton);

    }


    public void exitDrought(View view) {
        //insert method to increase water price
        int waterPrice = marketVM.calcPrice(TradeGood.WATER, game.getCurrLocation() );
        finish();
    }
}