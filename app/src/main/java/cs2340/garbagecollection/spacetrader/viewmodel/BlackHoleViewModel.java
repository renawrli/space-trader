package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Ship;

public class BlackHoleViewModel extends AndroidViewModel {

    public BlackHoleViewModel (@NonNull Application application) {
        super(application);
    }

    /** when a blackhole is encountered, decrease fuel by 3 units
     * @param ship
     * **/
    public void fuelDecrease(Ship ship) {
        ship.deductFuel(3);
    }
}