package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.Game;
import cs2340.garbagecollection.spacetrader.model.PlanetListAdapterKotlin;
import cs2340.garbagecollection.spacetrader.viewmodel.TravelViewModel;
import cs2340.garbagecollection.spacetrader.model.Planet;


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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_screen);
        reachablePlanets = findViewById(R.id.reachablePlanets);
        currLocationText = findViewById(R.id.locationLabel);
        fuelLevelText = findViewById(R.id.fuelLevelLabel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        setUpWidgets();
    }

    private void setUpWidgets() {
        fuelLevelText.setText(fuelLevelText.getText()+ " " + Game.getPlayer().getShip().getFuel());
        currLocationText.setText(currLocationText.getText()+ " " + Game.getCurrLocation().getName());
        validPlanets = TravelViewModel.planetsInRange();
        planetNames = TravelViewModel.validPlanetsString(validPlanets);
        Log.d("valid planet strings", planetNames.toString());
        //planetNames = TravelViewModel.validPlanetsString(TravelViewModel.planetsInRange());
        planetDistances = TravelViewModel.listDistances(validPlanets);
        planetFuelCosts = TravelViewModel.listFuel(planetDistances);
        layoutManager = new LinearLayoutManager(this);
        adapter = new PlanetListAdapterKotlin(planetNames, planetDistances, planetFuelCosts, this);
        reachablePlanets.setHasFixedSize(true);
        reachablePlanets.setLayoutManager(layoutManager);
        reachablePlanets.setAdapter(adapter);

    }
}
