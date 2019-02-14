package cs2340.garbagecollection.spacetrader.views;

//import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;

import cs2340.garbagecollection.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.garbagecollection.spacetrader.R;


public class ConfigurationActivity extends AppCompatActivity {
    private ConfigurationViewModel configurationViewModel;

    private Spinner difficultySpinner;
    private enum difficulties {
        EASY, INTERMEDIATE, EXPERT
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
    }

    protected void onSpinnerSelect() {

    }

}
