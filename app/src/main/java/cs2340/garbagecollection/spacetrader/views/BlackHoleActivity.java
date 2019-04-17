package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.viewmodel.BlackHoleViewModel;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class BlackHoleActivity extends AppCompatActivity {
    BlackHoleViewModel blackHoleVM;
    TextView banner;
    TextView encounterType;
    TextView encounterStatement;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackhole_encounter);
        Log.d("onCreate", "onCreate: blackhole activity launched");

        blackHoleVM = new BlackHoleViewModel(getApplication());

        banner = findViewById(R.id.blackhole_encounter_banner_text);
        encounterType = findViewById(R.id.blackhole_label);
        encounterStatement = findViewById(R.id.blackhole_encounter_statement);
        exitButton = findViewById(R.id.leaveBlackHoleButton);

    }


    public void exitBlackHole(View view) {
        blackHoleVM.fuelDecrease(game.getPlayer().getShip());
        finish();
    }
}