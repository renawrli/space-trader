package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.Game;
import cs2340.garbagecollection.spacetrader.model.Planet;

public class GameScreenActivity extends AppCompatActivity {
    TextView welcomeText;
    Planet currentPlanet = Game.getCurrLocation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        welcomeText = (TextView)findViewById(R.id.universeCreationLabel);
        welcomeText.setText(welcomeText.getText() + " " + currentPlanet.getName());
    }

    public void toMarket(View view) {
        Intent intent = new Intent(this, MarketBuyActivity.class);
//        Log.d("onClick", "toMarket: called");
        startActivity(intent);
    }

    public void viewTravelOptions(View view) {
        Intent intent = new Intent(this, TravelActivity.class);
        startActivity(intent);
    }
}
