package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
}
