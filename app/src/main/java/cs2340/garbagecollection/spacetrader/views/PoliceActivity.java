package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.viewmodel.PoliceViewModel;
import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class PoliceActivity extends AppCompatActivity {
    PoliceViewModel policeVM;
    TextView banner;
    TextView encounterType;
    TextView encounterStatement;
    TextView moneyTextView;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_encounter);
        Log.d("onCreate", "onCreate: police activity launched");

        policeVM = new PoliceViewModel(getApplication());

        banner = findViewById(R.id.police_encounter_banner_text);
        encounterType = findViewById(R.id.police_label);
        encounterStatement = findViewById(R.id.police_encounter_statement);
        moneyTextView = findViewById(R.id.moneyLeft);
        exitButton = findViewById(R.id.leavePoliceButton);

        moneyTextView.setText(game.getPlayer().getCredits()+"");
    }


    public void exitPolice(View view) {
        boolean hasIllegalGoods = policeVM.checkIllegalGoods(game.getPlayer().getShip());
        if (hasIllegalGoods) {
            policeVM.finePlayer(game.getPlayer());
        }
        finish();
    }
}
