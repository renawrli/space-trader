package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Random;

public class EncounterViewModel extends AndroidViewModel {
    public EncounterViewModel (@NonNull Application application) {
        super(application);
    }

    /** returns a random number from 1-100 **/
    public int randomNum() {
        Random rand = new Random();
        return 1 + rand.nextInt(100);
    }
}
