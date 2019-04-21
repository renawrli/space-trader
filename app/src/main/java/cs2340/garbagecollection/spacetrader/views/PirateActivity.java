package cs2340.garbagecollection.spacetrader.views;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.viewmodel.PirateViewModel;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class PirateActivity extends AppCompatActivity {
    PirateViewModel pirateVM;
    TextView banner;
    TextView encounterType;
    TextView encounterStatement;
    Button exitButton;

    MediaPlayer mySound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pirate_encounter);

        Log.d("onCreate", "onCreate: pirate activity launched");


        banner = findViewById(R.id.pirate_encounter_banner_text);
        encounterType = findViewById(R.id.pirate_label);
        encounterStatement = findViewById(R.id.pirate_encounter_statement);
        exitButton = findViewById(R.id.leavePirateButton);

        pirateVM = new PirateViewModel(getApplication());

        Log.d("onCreate", "onCreate: pirate encounter, goods stolen");
        // custom music
        mySound = MediaPlayer.create(PirateActivity.this,R.raw.illkillyoupirate);
        mySound.start();
    }

    public void exitPirate(View view) {
        pirateVM.lootStolen(game.getPlayer().getShip());
        finish();
    }
}
