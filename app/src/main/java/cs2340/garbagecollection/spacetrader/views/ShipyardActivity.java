package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cs2340.garbagecollection.spacetrader.R;
import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;
import cs2340.garbagecollection.spacetrader.viewmodel.ShipYardViewModel;



public class ShipyardActivity extends AppCompatActivity {
    ShipYardViewModel shipyardVM;
    TextView currentMoney;
    TextView refuelCost;
    TextView fuelLevel;
    Button leaveShipyardButton;
    Button refuelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipyard_screen);
        shipyardVM = new ShipYardViewModel(getApplication());

        fuelLevel = findViewById(R.id.currentFuelLevel);
        refuelButton = findViewById(R.id.refuelButton);
        leaveShipyardButton = findViewById(R.id.leaveShipyardButton);
        currentMoney = findViewById(R.id.moneyLeft);
        refuelCost = findViewById(R.id.fullTankCost);


        updateTextViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTextViews();
    }

    public void refuelPressed(View view) {
        if (!shipyardVM.needsFuel(game.getPlayer().getShip())) {
            Toast.makeText(this, "Tank is already full", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, RefuelActivity.class);
            startActivity(intent);
        }
    }

    public void updateTextViews() {
        currentMoney.setText(game.getPlayer().getCredits()+"");
        fuelLevel.setText(game.getPlayer().getShip().getFuel() + "/"+ game.getPlayer().getShip().getFuelCapacity());
        refuelCost.setText(shipyardVM.getRefuelCost(game.getPlayer().getShip())+"");
    }

    public void exitShipyardPressed(View view) {
        finish();
    }
}
