package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.PlanetListAdapterKotlin;
import cs2340.garbagecollection.spacetrader.viewmodel.TravelViewModel;
import cs2340.garbagecollection.spacetrader.model.Planet;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;


public class TravelActivity extends AppCompatActivity {

    private RecyclerView reachablePlanets;
    private PlanetListAdapterKotlin adapter;
    private List<Planet> validPlanets;
    private List<String> planetNames;
    private List<Integer> planetDistances;
    private List<Integer> planetFuelCosts;
    private TextView currLocationText;
    private TextView fuelLevelText;
    private RecyclerView.LayoutManager layoutManager;

    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_screen);

        reachablePlanets = findViewById(R.id.reachablePlanets);
        currLocationText = findViewById(R.id.locationLabel);
        fuelLevelText = findViewById(R.id.fuelLevelLabel);

        // custom music
        mySound = MediaPlayer.create(TravelActivity.this,R.raw.backgroundmusic);
        mySound.setLooping(true);
        mySound.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySound.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mySound.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpWidgets();
    }

    private void setUpWidgets() {
        fuelLevelText.setText(getResources().getString(R.string.fuel_level_label)+ " " + game.getPlayer().getShip().getFuel());
        currLocationText.setText(currLocationText.getText()+ " " + game.getCurrLocation().getName());
        validPlanets = TravelViewModel.planetsInRange();
        planetNames = TravelViewModel.validPlanetsString(validPlanets);
        Log.d("valid planet strings", planetNames.toString());
        //planetNames = TravelViewModel.validPlanetsString(TravelViewModel.planetsInRange());
        planetDistances = TravelViewModel.listDistances(validPlanets);
        planetFuelCosts = TravelViewModel.listFuel(planetDistances);
        layoutManager = new LinearLayoutManager(this);
        adapter = new PlanetListAdapterKotlin(planetNames, planetDistances, planetFuelCosts);
        reachablePlanets.setHasFixedSize(true);
        reachablePlanets.setLayoutManager(layoutManager);
        reachablePlanets.setAdapter(adapter);
    }


    public void leaveTravel(View view) {
        Intent buyPressed = new Intent(this, GameScreenActivity.class);
        finishAffinity();
        startActivity(buyPressed);
    }
    @Override
    public void onBackPressed() {
        finishAffinity();
        startActivity(new Intent(this,GameScreenActivity.class));
    }


}
