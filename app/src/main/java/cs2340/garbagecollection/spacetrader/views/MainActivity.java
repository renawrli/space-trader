package cs2340.garbagecollection.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cs2340.garbagecollection.spacetrader.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO: create Game Object with singleton pattern
        //setContentView(R.layout.activity_configuration);
    }
    public void incPilot(View view) {
    }
}
