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
    private int remPoints = 16;
    private int difficultyLevel = 0;
    private String playerName;
    private int pilotPoints = 0;
    private Spinner difficultySpinner;
    private TextView pDisplay;
    private TextView remPointsDisplay;

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
        remPointsDisplay = (TextView) findViewById(R.id.remainingPointsDisplay);


    }

    protected void onSpinnerSelect() {

    }

    public void decPilot(View view) {
        if (pilotPoints > 0) {
            pilotPoints--;
            remPoints++;
        }

        pDisplay.setText(pilotPoints+"");
        remPointsDisplay.setText(remPoints+"");
    }

    public void incPilot(View view) {
        if (remPoints > 0) {
            pilotPoints++;
            remPoints--;
        }

        pDisplay.setText(pilotPoints+"");
        remPointsDisplay.setText(remPoints+"");
        //create update display method
    }

}
