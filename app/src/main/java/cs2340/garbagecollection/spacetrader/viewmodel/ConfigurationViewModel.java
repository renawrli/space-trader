package cs2340.garbagecollection.spacetrader.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Player;

public class ConfigurationViewModel extends AndroidViewModel {
    private Player currentPlayer;

    public ConfigurationViewModel (@NonNull Application application) {
        super(application);
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }
}
