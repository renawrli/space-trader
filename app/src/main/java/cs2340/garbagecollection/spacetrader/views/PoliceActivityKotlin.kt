package cs2340.garbagecollection.spacetrader.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

import cs2340.garbagecollection.spacetrader.R
import cs2340.garbagecollection.spacetrader.viewmodel.PoliceViewModel
import cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game

class PoliceActivityKotlin : AppCompatActivity() {
    internal var policeVM: PoliceViewModel = PoliceViewModel(application)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.police_encounter)
        var banner: TextView = findViewById(R.id.police_encounter_banner_text)
        var encounterType: TextView = findViewById(R.id.police_label)
        var encounterStatement: TextView = findViewById(R.id.police_encounter_statement)
        var moneyTextView: TextView = findViewById(R.id.moneyLeft)
        var exitButton: Button = findViewById(R.id.leavePoliceButton)
        Log.d("onCreate", "onCreate: police activity launched")
        moneyTextView.text = game.player.credits.toString() + ""
    }


    fun exitPolice(view: View) {
        val hasIllegalGoods = policeVM.checkIllegalGoods(game.player.ship)
        if (hasIllegalGoods) {
            policeVM.finePlayer(game.player)
        }

        val intent = Intent(view.context, GameScreenActivity::class.java)
        finish()
        view.context.startActivity(intent)
    }
}
