package cs2340.garbagecollection.spacetrader.views;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.viewmodel.BlackHoleVMK;
import cs2340.garbagecollection.spacetrader.viewmodel.BlackHoleViewModel;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class BlackHoleActivity extends AppCompatActivity {
    BlackHoleVMK blackHoleVM;
    TextView banner;
    TextView encounterType;
    TextView encounterStatement;
    Button exitButton;

    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackhole_encounter);
        Log.d("onCreate", "onCreate: blackhole activity launched");

        blackHoleVM = new BlackHoleVMK(getApplication());

        banner = findViewById(R.id.blackhole_encounter_banner_text);
        encounterType = findViewById(R.id.blackhole_label);
        encounterStatement = findViewById(R.id.blackhole_encounter_statement);
        exitButton = findViewById(R.id.leaveBlackHoleButton);

        // custom music
        mySound = MediaPlayer.create(BlackHoleActivity.this,R.raw.relaxxxxxblackhole);
        mySound.start();

    }


    public void exitBlackHole(View view) {
        blackHoleVM.fuelDecrease(game.getPlayer().getShip());
        finish();
    }
}