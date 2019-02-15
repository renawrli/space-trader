package cs2340.garbagecollection.spacetrader.views;

//import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import cs2340.garbagecollection.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.garbagecollection.spacetrader.R;


public class ConfigurationActivity extends AppCompatActivity {
    private ConfigurationViewModel configurationViewModel;
    private static final int MAX_POINTS = 16;
    private int remPoints = MAX_POINTS;
    private String difficultyLevel;

    private String playerName;
    private int fighterPoints;
    private int pilotPoints;
    private int traderPoints;
    private int engineerPoints;

    private Spinner difficultySpinner;
    private TextView pDisplay;
    private TextView remPointsDisplay;
    private TextView fighterDisplay;
    private TextView traderDisplay;
    private TextView engineerDisplay;

    private enum difficulties {
        EASY("Easy"), INTERMEDIATE("Intermediate"), EXPERT("Expert");

        difficulties(String s) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        String[] diffs = {"Easy", "Intermediate", "Expert"};
        difficultySpinner = findViewById(R.id.difficultySpinner);
        ArrayAdapter<String> difficultyArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, diffs);
        difficultyArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyArrayAdapter);

        pDisplay = (TextView) findViewById(R.id.pilotPointsDisplay);
        traderDisplay = findViewById(R.id.traderPointsDisplay);
        engineerDisplay = findViewById(R.id.engineerPointsDisplay);
        fighterDisplay = findViewById(R.id.fighterPointsDisplay);
        remPointsDisplay = (TextView) findViewById(R.id.remainingPointsDisplay);
    }

    public void createPlayer(View view) {
//        difficultyLevel = difficultySpinner.getPopupContext();
    }

    private void updatePointDisplays() {
        pDisplay.setText(pilotPoints+"");
        engineerDisplay.setText(engineerPoints+"");
        traderDisplay.setText(traderPoints+"");
        fighterDisplay.setText(fighterPoints+"");

        remPointsDisplay.setText(remPoints+"");
    }

    public void decFighter(View view) {
        if (fighterPoints > 0) {
            fighterPoints--;
            remPoints++;
        }
        updatePointDisplays();
    }

    public void incFighter(View view) {
        if (remPoints > 0) {
            fighterPoints++;
            remPoints--;
        }
        updatePointDisplays();
    }

    public void decTrader(View view) {
        if (traderPoints > 0) {
            traderPoints--;
            remPoints++;
        }
        updatePointDisplays();
    }

    public void incTrader(View view) {
        if (remPoints > 0) {
            traderPoints++;
            remPoints--;
        }
        updatePointDisplays();
    }

    public void decEngineer(View view) {
        if (engineerPoints > 0) {
            engineerPoints--;
            remPoints++;
        }
        updatePointDisplays();
    }

    public void incEngineer(View view) {
        if (remPoints > 0) {
            engineerPoints++;
            remPoints--;
        }
        updatePointDisplays();
    }

    public void decPilot(View view) {
        if (pilotPoints > 0) {
            pilotPoints--;
            remPoints++;
        }
        updatePointDisplays();
    }

    public void incPilot(View view) {
        if (remPoints > 0) {
            pilotPoints++;
            remPoints--;
        }
        updatePointDisplays();
    }

}
