package cs2340.garbagecollection.spacetrader.model;

import java.util.Random;

/**
 * enum for the resources
 */
public enum Resources {
    NOSPECIALRESOURCES,
    MINERALRICH,
    MINERALPOOR,
    DESERT,
    LOTSOFWATER,
    RICHSOIL,
    POORSOIL,
    RICHFAUNA,
    LIFELESS,
    WEIRDMUSHROOMS,
    LOTSOFHERBS,
    ARTISTIC,
    WARLIKE;

    public static Resources getRandomResources() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }
}
