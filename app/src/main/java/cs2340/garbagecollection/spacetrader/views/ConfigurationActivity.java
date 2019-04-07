package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
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

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import cs2340.garbagecollection.spacetrader.model.Difficulty;
import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.viewmodel.ConfigurationViewModel;
import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.Game;


public class ConfigurationActivity extends AppCompatActivity {
    private static final int MAX_POINTS = 16;
    private int remPoints = MAX_POINTS;

    private Player player;
    public static Game game;

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
        FileInputStream fis = null;
        try {
            Log.d("awe", "aaegwawegae");
            fis = this.openFileInput("gameFile.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            String json = sb.toString();
            Log.d("awe", json);
            Gson gson = new Gson();
            game = gson.fromJson(json, Game.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (game != null) {
            Intent intent = new Intent(this, GameScreenActivity.class);
            this.finish();
            startActivity(intent);
        }

        setContentView(R.layout.activity_configuration);

        /** Sets difficulty spinner values, uses String values **/
        difficultySpinner = findViewById(R.id.difficultySpinner);
        //difficultySpinner.setAdapter(new ArrayAdapter<Difficulty>(this,
        // android.R.layout.simple_spinner_item, Difficulty.values()));
        ArrayAdapter<CharSequence> difficultyArrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.difficulties, android.R.layout.simple_spinner_item);
        difficultyArrayAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyArrayAdapter);
        nameField = findViewById(R.id.nameInput);
        pDisplay = findViewById(R.id.pilotPointsDisplay);
        traderDisplay = findViewById(R.id.traderPointsDisplay);
        engineerDisplay = findViewById(R.id.engineerPointsDisplay);
        fighterDisplay = findViewById(R.id.fighterPointsDisplay);
        remPointsDisplay = findViewById(R.id.remainingPointsDisplay);
        createPlayerButton = findViewById(R.id.createPlayerButton);
    }


    public void createPlayer(View view) {
        ConfigurationViewModel configVM = new ConfigurationViewModel(getApplication());
        playerName = nameField.getText().toString();
        // prints directions to user if invalid data is entered
        if (configVM.invalidName(playerName)) {
            Toast.makeText(ConfigurationActivity.this, "Please enter a name",
                    Toast.LENGTH_SHORT).show();
        }
        if (configVM.pointsTooLow(pilotPoints, fighterPoints, traderPoints, engineerPoints)) {
            Toast.makeText(ConfigurationActivity.this, "Please use all points",
                    Toast.LENGTH_SHORT).show();
        }
        if (configVM.pointsTooHigh(pilotPoints, fighterPoints, traderPoints, engineerPoints)) {
            Toast.makeText(ConfigurationActivity.this, "You used too many points",
                    Toast.LENGTH_SHORT).show();
        }
        // resets screen if any invalid data is entered
        if (configVM.pointsTooHigh(pilotPoints, fighterPoints, traderPoints, engineerPoints)
                || configVM.pointsTooLow(pilotPoints, fighterPoints, traderPoints, engineerPoints)
                || configVM.invalidName(playerName)) {
            resetScreen();
        } else {
            // Create player and Game
            player = configVM.createPlayer(playerName, pilotPoints, fighterPoints, traderPoints,
                    engineerPoints);
            Difficulty difficulty = Difficulty.EASY; //
            for (Difficulty dif : Difficulty.values()) {
                if (dif.getDifficulty().equals(difficultySpinner.getSelectedItem()))
                    difficulty = dif;
            }
            Difficulty gameDifficulty = difficulty;
            game = configVM.createGame(gameDifficulty, player);
            Intent intent = new Intent(this, GameScreenActivity.class);
            this.finish();
            startActivity(intent);
        }
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
        pDisplay.setText(pilotPoints + "");
        engineerDisplay.setText(engineerPoints + "");
        traderDisplay.setText(traderPoints + "");
        fighterDisplay.setText(fighterPoints + "");
        remPointsDisplay.setText(remPoints + "");
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
