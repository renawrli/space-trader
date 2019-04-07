package cs2340.garbagecollection.spacetrader.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.FileOutputStream;

import cs2340.garbagecollection.spacetrader.R;
import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;


public class PlanetInfoActivity extends AppCompatActivity {
    TextView nameDisplay;
    TextView governmentDisplay;
    TextView techDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_info);

        nameDisplay = findViewById(R.id.planet_name_displayed);
        governmentDisplay = findViewById(R.id.planet_government_displayed);
        techDisplay = findViewById(R.id.planet_tech_displayed);

        updateTextViews();
    }

    public void updateTextViews() {
        nameDisplay.setText(game.getCurrLocation().getName());
        governmentDisplay.setText(game.getCurrLocation().getGovernment().getGovernmentType());
        techDisplay.setText(game.getCurrLocation().getTechnology().getTechLevel());
    }

    public void exitPlanetInfo(View view) {
        finish();
    }

    public void deleteGame(View view) {
        String filename = "gameFile.txt";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, ConfigurationActivity.class);
        game = null;
        this.finish();
        startActivity(intent);
    }
}
