package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Ship;

/**
 * This ViewModel supports activities associated with Pirate random encounters
 */
public class PirateViewModel extends AndroidViewModel {
    public PirateViewModel (@NonNull Application application) {
        super(application);
    }

    /** when a pirate steals all your loot **/
    public void lootStolen(Ship ship) {
        ship.resetGoods();
    }
}
