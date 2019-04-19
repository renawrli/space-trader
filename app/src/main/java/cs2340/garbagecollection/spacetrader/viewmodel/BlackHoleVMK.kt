package cs2340.garbagecollection.spacetrader.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

import cs2340.garbagecollection.spacetrader.model.Ship

class BlackHoleVMK(application: Application) : AndroidViewModel(application) {

    /** when a blackhole is encountered, decrease fuel by 3 units
     * @param ship
     */
    fun fuelDecrease(ship: Ship) {
        ship.deductFuel(3)
    }
}