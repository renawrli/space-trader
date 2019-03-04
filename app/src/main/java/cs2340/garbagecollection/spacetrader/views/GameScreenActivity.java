package cs2340.garbagecollection.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cs2340.garbagecollection.spacetrader.R;

public class GameScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
    }

    public void toMarket(View view) {
        Intent intent = new Intent(this, MarketBuyActivity.class);
        this.finish();
//        Log.d("onClick", "toMarket: called");
        startActivity(intent);
    }
}
