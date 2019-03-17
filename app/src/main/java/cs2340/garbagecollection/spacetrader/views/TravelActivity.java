package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.PlanetListAdapterKotlin;
import cs2340.garbagecollection.spacetrader.viewmodel.TravelViewModel;


public class TravelActivity extends AppCompatActivity {
    private RecyclerView reachablePlanets;
    private PlanetListAdapterKotlin adapter;
    private List<String> planetNames;
    private List<Integer> planetDistances;
    private List<Integer> planetFuelCosts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_screen);
        reachablePlanets = findViewById(R.id.reachablePlanets);
        planetNames = TravelViewModel.validPlanetsString(TravelViewModel.planetsInRange());
        adapter = new PlanetListAdapterKotlin(planetNames, planetDistances, planetFuelCosts, this);
        reachablePlanets.setAdapter(adapter);

    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
