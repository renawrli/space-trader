package cs2340.garbagecollection.spacetrader.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

import java.util.Random

class EncounterVMK(application: Application) : AndroidViewModel(application) {
    companion object {

        private val PIRATE_RATE = 5
        private val POLICE_RATE = 15
        private val TRADER_RATE = 20
        private val DROUGHT_RATE = 15
        private val BLACKHOLE_RATE = 25

        /**
         * returns a number representing encounter type
         * 0 - no encounter
         * 1 - pirate encounter
         * 2 - police encounter
         * 3 - trader encounter
         * 4 - drought encounter
         * 5 - blackHole encounter
         */
        fun generateEncounterType(): Int {
            val rand = Random()
            val num = 1 + rand.nextInt(100)

            return if (num > PIRATE_RATE + POLICE_RATE + TRADER_RATE + DROUGHT_RATE + BLACKHOLE_RATE) {
                0
            } else if (num <= PIRATE_RATE) {
                1
            } else if (num <= PIRATE_RATE + DROUGHT_RATE) {
                4
            } else if (num <= PIRATE_RATE + DROUGHT_RATE + BLACKHOLE_RATE) {
                5
            } else if (num <= PIRATE_RATE + POLICE_RATE + DROUGHT_RATE + BLACKHOLE_RATE) {
                2
            } else {
                3
            }
        }
    }
}
