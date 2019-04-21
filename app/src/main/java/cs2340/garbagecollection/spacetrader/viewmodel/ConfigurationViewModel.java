package cs2340.garbagecollection.spacetrader.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.model.Game;
import cs2340.garbagecollection.spacetrader.model.Difficulty;

/**
 * This ViewModel supports activities associated with initially creating the Player
 */
public class ConfigurationViewModel extends AndroidViewModel {
    private final int MAX_POINTS_BEGINNER = 26;
    private final int MAX_POINTS_EASY = 20;
    private final int MAX_POINTS_MEDIUM = 16;
    private final int MAX_POINTS_HARD = 10;
    private final int MAX_POINTS_IMPOSSIBLE = 5;


    public ConfigurationViewModel (@NonNull Application application) {
        super(application);
    }

    /** Checks if a potential Player's skill points are higher than the allowed amount.
     * @param pilotPts
     * @param fighterPts
     * @param traderPts
     * @param engineerPts**/
    public boolean pointsTooHigh(int pilotPts, int fighterPts, int traderPts, int engineerPts, Difficulty difficulty) {
        if (difficulty.equals(Difficulty.NORMAL)) {
            return (pilotPts + fighterPts + traderPts + engineerPts) > MAX_POINTS_MEDIUM;
        } else if (difficulty.equals(Difficulty.BEGINNER)) {
            return (pilotPts + fighterPts + traderPts + engineerPts) > MAX_POINTS_BEGINNER;
        } else if (difficulty.equals(Difficulty.EASY)) {
            return (pilotPts + fighterPts + traderPts + engineerPts) > MAX_POINTS_EASY;
        } else if (difficulty.equals(Difficulty.HARD)) {
            return (pilotPts + fighterPts + traderPts + engineerPts) > MAX_POINTS_HARD;
        } else {
            return (pilotPts + fighterPts + traderPts + engineerPts) > MAX_POINTS_IMPOSSIBLE;
        }
    }

    /** Checks if a potential Player's skill points are lower than the allowed amount
     * @param pilotPts
     * @param fighterPts
     * @param traderPts
     * @param engineerPts**/
    public boolean pointsTooLow(int pilotPts, int fighterPts, int traderPts, int engineerPts, Difficulty difficulty) {
        if (difficulty.equals(Difficulty.NORMAL)) {
            return (pilotPts + fighterPts + traderPts + engineerPts) < MAX_POINTS_MEDIUM;
        } else if (difficulty.equals(Difficulty.BEGINNER)) {
            return (pilotPts + fighterPts + traderPts + engineerPts) < MAX_POINTS_BEGINNER;
        } else if (difficulty.equals(Difficulty.EASY)) {
            return (pilotPts + fighterPts + traderPts + engineerPts) < MAX_POINTS_EASY;
        } else if (difficulty.equals(Difficulty.HARD)) {
            return (pilotPts + fighterPts + traderPts + engineerPts) < MAX_POINTS_HARD;
        } else {
            return (pilotPts + fighterPts + traderPts + engineerPts) < MAX_POINTS_IMPOSSIBLE;
        }
    }

    /** Checks that the player entered a valid name
     * @param name**/
    public boolean invalidName(String name) {
        return name.equals("");
    }

    /** Creates a Game
     * @param difficulty
     * @param player**/
    public Game createGame(Difficulty difficulty, Player player) {
        //Log.d("Printing difficulty: ", difficulty.toString());
        Game game = new Game(difficulty, player);
        Log.d("Printing Universe: ", game.getUniverse().toString());
        return game;
    }
    /** Creates a Player
     * @param name
     * @param pilotPts
     * @param fighterPts
     * @param traderPts
     * @param engineerPts**/
    public Player createPlayer(String name, int pilotPts, int fighterPts, int traderPts,
                               int engineerPts) {
        Player player = new Player(name, pilotPts,fighterPts, traderPts, engineerPts);
        Log.d("Printing Player", player.toString());
        return player;
    }
}
