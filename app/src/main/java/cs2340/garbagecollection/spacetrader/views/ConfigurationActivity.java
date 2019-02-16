package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.garbagecollection.spacetrader.R;


public class ConfigurationActivity extends AppCompatActivity {
    private static final int MAX_POINTS = 16;
    private int remPoints = MAX_POINTS;

    private Player player;

    private String playerName;
    private int fighterPoints;
    private int pilotPoints;
    private int traderPoints;
    private int engineerPoints;

    private EditText nameField;
    private Spinner difficultySpinner;
    private TextView pDisplay;
    private TextView remPointsDisplay;
    private TextView fighterDisplay;
    private TextView traderDisplay;
    private TextView engineerDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        difficultySpinner = findViewById(R.id.difficultySpinner);
        Player.Difficulty[] difficulties = Player.Difficulty.values();
        String[] difficultiesAsString = new String[difficulties.length];
        for (int i = 0; i < difficulties.length; i++) {
            difficultiesAsString[i] = difficulties[i].getDifficulty();
        }
        //ArrayAdapter<String> difficultyArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, R.array.difficulties);
        ArrayAdapter<String> difficultyArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, difficultiesAsString);
        difficultyArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyArrayAdapter);
        nameField = findViewById(R.id.nameInput);

        playerName = nameField.getText().toString();
        nameField = findViewById(R.id.nameInput);
        pDisplay = findViewById(R.id.pilotPointsDisplay);
        traderDisplay = findViewById(R.id.traderPointsDisplay);
        engineerDisplay = findViewById(R.id.engineerPointsDisplay);
        fighterDisplay = findViewById(R.id.fighterPointsDisplay);
        remPointsDisplay = findViewById(R.id.remainingPointsDisplay);
    }

    public void createPlayer(View view) {
        Player.Difficulty difficulty = Player.Difficulty.EASY;
        for (Player.Difficulty dif : Player.Difficulty.values()) {
            if (dif.getDifficulty().equals(difficultySpinner.getSelectedItem()))
                difficulty = dif;
        }
        player = new Player(playerName, pilotPoints, fighterPoints, traderPoints, engineerPoints, difficulty);
        Log.d("TEST", player.toString());
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
