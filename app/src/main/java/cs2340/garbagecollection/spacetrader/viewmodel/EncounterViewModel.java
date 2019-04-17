package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Random;

public class EncounterViewModel extends AndroidViewModel {
    public EncounterViewModel (@NonNull Application application) {
        super(application);
    }

    private static final int PIRATE_RATE = 5;
    private static final int POLICE_RATE = 15;
    private static final int TRADER_RATE = 20;
    private static final int DROUGHT_RATE = 15;
    private static final int BLACKHOLE_RATE = 25;

    /**
     * returns a number representing encounter type
     * 0 - no encounter
     * 1 - pirate encounter
     * 2 - police encounter
     * 3 - trader encounter
     * 4 - drought encounter
     * 5 - blackHole encounter
     * **/
    public static int generateEncounterType() {
        Random rand = new Random();
        int num = 1 + rand.nextInt(100);

        if (num > PIRATE_RATE+POLICE_RATE+TRADER_RATE + DROUGHT_RATE+BLACKHOLE_RATE) { return 0; }
        else if (num <= PIRATE_RATE) { return 1; }
        else if (num <= PIRATE_RATE+DROUGHT_RATE) { return 4; }
        else if (num <= PIRATE_RATE+DROUGHT_RATE+BLACKHOLE_RATE) { return 5; }
        else if (num <= PIRATE_RATE+POLICE_RATE+DROUGHT_RATE+BLACKHOLE_RATE) { return 2; }
        else { return 3; }
    }
}
