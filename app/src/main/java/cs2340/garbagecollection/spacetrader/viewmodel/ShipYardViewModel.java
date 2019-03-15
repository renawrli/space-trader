package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.model.Ship;

/**
 * This ViewModel supports activities associated with adding fuel to the ship.
 */
public class ShipYardViewModel extends AndroidViewModel {

    private final int PRICE_PER_FUEL = 5;

    public ShipYardViewModel (@NonNull Application application) {
        super(application);
    }

    /** Returns true if player enters valid amount of fuel to tank */
    public boolean checkFuelAdd(Player p, Ship ship, int amountAdd) {
        return (amountAdd + ship.getFuel() <= ship.getShipType().getFuelCapacity();
    }

    /** Returns true if the player has enough money to buy the fuel*/
    public boolean hasEnoughMoney(Player p, int fuelNeeded) {
        return (fuelNeeded * PRICE_PER_FUEL) <= p.getCredits();
    }

    /** Returns the total price of fuel that user wants to add */
    public int fuelPrice(int fuelNeeded) {
        return fuelNeeded * PRICE_PER_FUEL;
    }

    /**To be called after passing the checks, update the model */
    public void buyFuel(Player p, Ship ship, int amountAdd, int fuelNeeded) {
        int newCreditAmount = p.getCredits() - (fuelNeeded * PRICE_PER_FUEL);
        p.setCredits(newCreditAmount);
        ship.addFuel(amountAdd);
    }
}
