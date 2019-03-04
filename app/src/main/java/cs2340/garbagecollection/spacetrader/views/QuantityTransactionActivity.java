package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.model.Game;
import cs2340.garbagecollection.spacetrader.model.TradeGood;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModel;
import cs2340.garbagecollection.spacetrader.viewmodel.MarketViewModelKotlin;

public class QuantityTransactionActivity extends AppCompatActivity {
    private Button transactionConfirmationButton;
    private Button minusButton;
    private Button plusButton;
    private TextView buyPrompt;
    private TextView quantityDisplay;
    private MarketViewModelKotlin marketViewModel;
    private TradeGood good;
    private int quantity;
    private boolean buy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Create", "onCreate: QuantityTransactionActivity launched");

        Bundle bundle = getIntent().getExtras();
        System.out.println("BUNDLE = " +bundle);
        buy = bundle.getBoolean("buy_sell");
        String goodName = bundle.getString("goodName");
        String[] translatedGoodNames = getResources().getStringArray(R.array.goodNames);

        for (int i = 0; i < translatedGoodNames.length; i++) {
            if (goodName.equals(translatedGoodNames[i])) {
                good = TradeGood.values()[i];
                break;
            }
        }

        setContentView(R.layout.quantity_dialog_box);

        transactionConfirmationButton = findViewById(R.id.confirmTransactionButton);
        plusButton = findViewById(R.id.add_button);
        minusButton = findViewById(R.id.minus_button);
        buyPrompt = findViewById(R.id.text_dialog);
        quantityDisplay = findViewById(R.id.quantityDisplay);
        marketViewModel = new MarketViewModelKotlin(this.getApplication());
    }

    public void confirmTransactionPressed(View view) {
        boolean valid = true;
        if (buy) {
            if (!marketViewModel.enoughMoney(Game.getPlayer(), good, Game.getCurrLocation(), quantity)) {
                Toast.makeText(this, getResources().getString(R.string.not_enough_money_toast), Toast.LENGTH_LONG).show();
                valid = false;
            }
            if (!marketViewModel.enoughSpaceToBuy(Game.getPlayer(), quantity)) {
                Toast.makeText(this, getResources().getString(R.string.not_enough_space_toast), Toast.LENGTH_LONG).show();
                valid = false;
            }

            if (valid) {
                marketViewModel.buy(Game.getPlayer(), good, Game.getCurrLocation(), quantity);
                this.finish();
            }

        } else {
            if (!marketViewModel.hasGoodsToSell(Game.getPlayer(), good, quantity)) {
                Toast.makeText(this, getResources().getString(R.string.not_enough_goods_toast), Toast.LENGTH_LONG).show();
                valid = false;
            }
            if (valid) {
                marketViewModel.sell(Game.getPlayer(), good, Game.getCurrLocation(), quantity);
                this.finish();
            }
        }

    }

    public void plusPressed(View view) {
        quantity++;
        quantityDisplay.setText(quantity+"");
    }

    public void minusPressed(View view) {
        if (quantity > 0) {
            quantity--;
            quantityDisplay.setText(quantity+"");
        }
    }
}
