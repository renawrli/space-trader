package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.model.Ship;
import cs2340.garbagecollection.spacetrader.model.TradeGood;

/**
 * This ViewModel supports activities associated with Police random encounters
 */
public class PoliceViewModel extends AndroidViewModel {
    public PoliceViewModel (@NonNull Application application) {
        super(application);
    }

    private int FINE = 50;

    /** Getter for FINE **/
    public int getFINE() {
        return FINE;
    }

    /**
     * checks if there are firearms or narcotics on the ship
     * @param ship
     * @return true if there are illegal goods
     */
    public boolean checkIllegalGoods(Ship ship) {
        for (int i = 0; i < ship.getCargoArr().length; i++) {
            if (ship.getCargoArr()[i] == TradeGood.FIREARMS || ship.getCargoArr()[i] == TradeGood.NARCOTICS){
                return true;
            }
        }
        return false;
    }

    /** fines the player if illegal goods are found in their ship
     * @param p**/
    public void finePlayer(Player p) {
        int credits = p.getCredits();
        if (credits < FINE) {
            p.setCredits(0);
        } else {
            p.setCredits(credits - FINE);
        }
    }
}
