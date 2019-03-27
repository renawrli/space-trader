package cs2340.garbagecollection.spacetrader.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.FileOutputStream;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.Game;
import cs2340.garbagecollection.spacetrader.model.Planet;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class GameScreenActivity extends AppCompatActivity {
    TextView welcomeText;
    Planet currentPlanet = game.getCurrLocation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        setContentView(R.layout.game_screen);
        welcomeText = (TextView)findViewById(R.id.universeCreationLabel);
        welcomeText.setText(welcomeText.getText() + " " + currentPlanet.getName());
        Game myGame = game;
        String filename = "gameFile.txt";
        Gson gson = new Gson();
        String s = gson.toJson(myGame);
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
