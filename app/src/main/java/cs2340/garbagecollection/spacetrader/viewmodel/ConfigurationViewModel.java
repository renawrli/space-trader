package cs2340.garbagecollection.spacetrader.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Player;

/**
 * This ViewModel supports activities associated with initially creating the Player
 */
public class ConfigurationViewModel extends AndroidViewModel {
    private final int MAX_POINTS = 16;

    public ConfigurationViewModel (@NonNull Application application) {
        super(application);
    }

    /** Checks if a potential Player's skill points are higher than the allowed amount. **/
    public boolean pointsTooHigh(int pilotPts, int fighterPts, int traderPts, int engineerPts) {
        return (pilotPts + fighterPts + traderPts + engineerPts) > MAX_POINTS;
    }

    /** Checks if a potential Player's skill points are lower than the allowed amount **/
    public boolean pointsTooLow(int pilotPts, int fighterPts, int traderPts, int engineerPts) {
        return (pilotPts + fighterPts + traderPts + engineerPts) < MAX_POINTS;
    }

    /** Checks that the player entered a valid name **/
    public boolean validName(String name) {
        return name != null && name.length() > 0;
    }

    //TODO: get the game and get player the game and get player attributes you want
    //TODO: make a method to instantiate a player


//    public void setCurrentPlayer(Player player) {
//        currentPlayer = player;
//    }
}
