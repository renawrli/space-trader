package cs2340.garbagecollection.spacetrader.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

import cs2340.garbagecollection.spacetrader.R
import cs2340.garbagecollection.spacetrader.viewmodel.PirateViewModel

import cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game

class PirateActivityKotlin : AppCompatActivity() {
    internal var pirateVM: PirateViewModel = PirateViewModel(application)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pirate_encounter)

        Log.d("onCreate", "onCreate: pirate activity launched")


        var banner: TextView = findViewById(R.id.pirate_encounter_banner_text)
        var encounterType: TextView = findViewById(R.id.pirate_label)
        var encounterStatement: TextView = findViewById(R.id.pirate_encounter_statement)
        var exitButton: Button = findViewById(R.id.leavePirateButton)

        Log.d("onCreate", "onCreate: pirate encounter, goods stolen")

    }

    fun exitPirate(view: View) {
        pirateVM.lootStolen(game.player.ship)
        val intent = Intent(view.context, GameScreenActivity::class.java)
        finish()
        view.context.startActivity(intent)
    }
}
