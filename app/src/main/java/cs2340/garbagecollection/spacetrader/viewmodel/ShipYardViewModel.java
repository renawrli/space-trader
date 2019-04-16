package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.model.Ship;
import cs2340.garbagecollection.spacetrader.model.TradeGood;

/**
 * This ViewModel supports activities associated with adding fuel to the ship.
 */
public class ShipYardViewModel extends AndroidViewModel {

    private static final int PRICE_PER_FUEL = 5;

    public ShipYardViewModel (@NonNull Application application) {
        super(application);
    }

    /** Returns true if player enters valid amount of fuel to tank
     * @param ship
     * @param amountAdd*/
    public boolean checkFuelAdd(Ship ship, int amountAdd) {
        return (amountAdd + ship.getFuel() <= ship.getShipType().getFuelCapacity());
    }

    /** Returns true if the player has enough money to buy the fuel
     * @param p
     * @param fuelNeeded*/
    public boolean hasEnoughMoney(Player p, int fuelNeeded) {
        return (fuelNeeded * PRICE_PER_FUEL) <= p.getCredits();
    }

    public int getRefuelCost(Ship ship) {
        return (ship.getFuelCapacity() - ship.getFuel())*PRICE_PER_FUEL;
    }

    public boolean needsFuel(Ship ship) {
        return getRefuelCost(ship) > 0;
    }

    /** Returns the total price of fuel that user wants to add
     * @param fuelNeeded*/
    public int fuelPrice(int fuelNeeded) {
        return fuelNeeded * PRICE_PER_FUEL;
    }

    /** To be called after passing the checks, update the model
     * @param p
     * @param ship
     * @param fuelNeeded*/
    public void buyFuel(Player p, Ship ship, int fuelNeeded) {
        int newCreditAmount = p.getCredits() - (fuelNeeded * PRICE_PER_FUEL);
        p.setCredits(newCreditAmount);
        ship.addFuel(fuelNeeded);
    }

    /** getter **/
    public static int getPricePerFuel() {
        return PRICE_PER_FUEL;
    }

    public boolean canBuyShip(Player p, int creditsNeeded) {
        return p.getCredits() >= creditsNeeded;
    }

    public void buyNewShip(Player p, Ship ship) {
        int newCargoSize = 0;
        for (TradeGood good: p.getShip().getCargoArr()) {
            if (newCargoSize < ship.getCargoArr().length) {
                ship.addCargo(good);
                newCargoSize++;
            }
        }
        p.setCredits(p.getCredits() - ship.getShipType().getCreditCost());
        p.setShip(ship);
    }
}
