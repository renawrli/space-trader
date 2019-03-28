package cs2340.garbagecollection.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.viewmodel.ShipYardViewModel;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class RefuelActivity extends AppCompatActivity {
    ShipYardViewModel shipYardVM;
    TextView fuelAmountTextView;
    Button minusButton;
    Button plusButton;
    Button exitButton;
    Button confirmTransactionButton;
    int fuelAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refuel_dialogue);

        shipYardVM = new ShipYardViewModel(getApplication());

        fuelAmountTextView = findViewById(R.id.fuelQuantityDisplay);
        minusButton = findViewById(R.id.refuel_minus_button);
        plusButton = findViewById(R.id.refuel_add_button);
        exitButton = findViewById(R.id.refuel_cancel_button);
        confirmTransactionButton = findViewById(R.id.confirm_refuel_button);
    }

    public void plusPressed(View view) {
        fuelAmount++;
        fuelAmountTextView.setText(fuelAmount+"");
    }

    public void minusPressed(View view) {
        if (fuelAmount - 1 >= 0) {
            fuelAmount--;
            fuelAmountTextView.setText(fuelAmount+"");
        }
    }

    public void cancelRefuel(View view) {
        finish();
    }

    public void confirmRefuel(View view) {
        if (!shipYardVM.hasEnoughMoney(game.getPlayer(), fuelAmount)){
            Toast.makeText(this, getResources().getString(R.string.not_enough_money_toast), Toast.LENGTH_SHORT).show();
        } else if (!shipYardVM.checkFuelAdd(game.getPlayer().getShip(), fuelAmount)) {
            Toast.makeText(this, getResources().getString(R.string.insufficient_tank_capacity_toast), Toast.LENGTH_SHORT).show();
        } else {
            shipYardVM.buyFuel(game.getPlayer(), game.getPlayer().getShip(), fuelAmount);
            finish();
        }
    }
}
