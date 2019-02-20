package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import cs2340.garbagecollection.spacetrader.model.Difficulty;
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
    private Button createPlayerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        /** Sets difficulty spinner values, uses Enum values instead of Strings **/
        difficultySpinner = findViewById(R.id.difficultySpinner);
        difficultySpinner.setAdapter(new ArrayAdapter<Difficulty>(this, android.R.layout.simple_spinner_item, Difficulty.values()));

        nameField = findViewById(R.id.nameInput);
        pDisplay = findViewById(R.id.pilotPointsDisplay);
        traderDisplay = findViewById(R.id.traderPointsDisplay);
        engineerDisplay = findViewById(R.id.engineerPointsDisplay);
        fighterDisplay = findViewById(R.id.fighterPointsDisplay);
        remPointsDisplay = findViewById(R.id.remainingPointsDisplay);
        createPlayerButton = findViewById(R.id.createPlayerButton);

        createPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfigurationViewModel configVM = new ConfigurationViewModel(getApplication());
                playerName = nameField.getText().toString();
                // prints directions to user if invalid data is entered
                if (configVM.invalidName(playerName)) {
                    Toast.makeText(ConfigurationActivity.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                }
                if(configVM.pointsTooLow(pilotPoints, fighterPoints, traderPoints, engineerPoints)) {
                    Toast.makeText(ConfigurationActivity.this, "Please use all points", Toast.LENGTH_SHORT).show();
                }
                if(configVM.pointsTooHigh(pilotPoints, fighterPoints, traderPoints, engineerPoints)) {
                    Toast.makeText(ConfigurationActivity.this, "You used too many points", Toast.LENGTH_SHORT).show();
                }
                // resets screen if any invalid data is entered
                if (configVM.pointsTooHigh(pilotPoints, fighterPoints, traderPoints, engineerPoints)
                        || configVM.pointsTooLow(pilotPoints, fighterPoints, traderPoints, engineerPoints)
                        || configVM.invalidName(playerName)) {
                    resetScreen();
                } else {
                    // Create player and Game
                    player = configVM.createPlayer(playerName, pilotPoints, fighterPoints, traderPoints, engineerPoints);
                    Difficulty gameDifficulty = (Difficulty) difficultySpinner.getSelectedItem();
                    configVM.createGame(gameDifficulty, player);
                }
            }
        });
    }

    private void resetScreen() {
        remPoints = MAX_POINTS;
//        nameField.setText("");
//        remPointsDisplay.setText(MAX_POINTS + "");
//        pDisplay.setText(0 + "");
//        fighterDisplay.setText(0 + "'");
//        traderDisplay.setText(0+"");
//        engineerDisplay.setText(0+"");
//        commented out since we can utilize the updateDisplays() method instead
        fighterPoints = 0;
        pilotPoints = 0;
        traderPoints = 0;
        engineerPoints = 0;
        playerName = "";
        updateDisplays();
    }

    private void updateDisplays() {
        pDisplay.setText(pilotPoints+"");
        engineerDisplay.setText(engineerPoints+"");
        traderDisplay.setText(traderPoints+"");
        fighterDisplay.setText(fighterPoints+"");

        remPointsDisplay.setText(remPoints+"");

        nameField.setText(playerName);
    }

    public void decFighter(View view) {
        if (fighterPoints > 0) {
            fighterPoints--;
            remPoints++;
        }
        updateDisplays();
    }

    public void incFighter(View view) {
        if (remPoints > 0) {
            fighterPoints++;
            remPoints--;
        }
        updateDisplays();
    }

    public void decTrader(View view) {
        if (traderPoints > 0) {
            traderPoints--;
            remPoints++;
        }
        updateDisplays();
    }

    public void incTrader(View view) {
        if (remPoints > 0) {
            traderPoints++;
            remPoints--;
        }
        updateDisplays();
    }

    public void decEngineer(View view) {
        if (engineerPoints > 0) {
            engineerPoints--;
            remPoints++;
        }
        updateDisplays();
    }

    public void incEngineer(View view) {
        if (remPoints > 0) {
            engineerPoints++;
            remPoints--;
        }
        updateDisplays();
    }

    public void decPilot(View view) {
        if (pilotPoints > 0) {
            pilotPoints--;
            remPoints++;
        }
        updateDisplays();
    }

    public void incPilot(View view) {
        if (remPoints > 0) {
            pilotPoints++;
            remPoints--;
        }
        updateDisplays();
    }

}
