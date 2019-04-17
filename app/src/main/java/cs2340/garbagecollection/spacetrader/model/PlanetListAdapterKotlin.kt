package cs2340.garbagecollection.spacetrader.model

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import cs2340.garbagecollection.spacetrader.R
import cs2340.garbagecollection.spacetrader.viewmodel.EncounterViewModel
import cs2340.garbagecollection.spacetrader.viewmodel.TravelViewModel
import cs2340.garbagecollection.spacetrader.views.*
import java.util.ArrayList


class PlanetListAdapterKotlin(planetNames: List<String>, distances: List<Int>, fuelUnitsCost: List<Int>) : RecyclerView.Adapter<PlanetListAdapterKotlin.ViewHolder>() {
    private var mPlanetNames = ArrayList<String>()
    private var mDistances = ArrayList<Int>()
    private var mFuelUnitsCost = ArrayList<Int>()

    init {
        mPlanetNames = planetNames as ArrayList<String>
        mDistances = distances as ArrayList<Int>
        mFuelUnitsCost = fuelUnitsCost as ArrayList<Int>
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.planet_list_item, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.planetName.text = mPlanetNames[i]
        viewHolder.distanceToPlanet.text = mDistances[i].toString() + ""
        viewHolder.fuelToPlanet.text = mFuelUnitsCost[i].toString() + ""
    }

    override fun getItemCount(): Int {
        return mPlanetNames.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal var planetName: TextView = itemView.findViewById(R.id.planetName)
        internal var distanceToPlanet: TextView = itemView.findViewById(R.id.distanceToPlanet)
        internal var fuelToPlanet: TextView = itemView.findViewById(R.id.fuelToPlanet)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val game = ConfigurationActivity.game
            TravelViewModel.travel(TravelViewModel.planetsInRange()[adapterPosition], game.player.ship)
            System.out.println("curr planet is " + game.currLocation.name)

            val encounterType = EncounterViewModel.generateEncounterType()
            System.out.println("encounter num: $encounterType")

            val intent = Intent(view.context, GameScreenActivity::class.java)
            view.context.startActivity(intent)

            if (encounterType == 3) {

                val traderAct = Intent(view.context, TraderActivity::class.java)
                view.context.startActivity(traderAct)
                System.out.println("launching trader encounter")
            } else if (encounterType == 1) {

                val pirateAct = Intent(view.context, PirateActivity::class.java)
                view.context.startActivity(pirateAct)
                System.out.println("launching pirate encounter")
            } else if (encounterType == 2) {

                val policeAct = Intent(view.context, PoliceActivityKotlin::class.java)
                view.context.startActivity(policeAct)
                System.out.println("launching police encounter")
            } else if (encounterType == 4) {

                val droughtAct = Intent(view.context, DroughtActivity::class.java)
                view.context.startActivity(droughtAct)
                System.out.println("launching drought encounter")
            } else if (encounterType == 5) {

                val blackHoleAct = Intent(view.context, BlackHoleActivity::class.java)
                view.context.startActivity(blackHoleAct)
                System.out.println("launching blackhole encounter")
            }




            //this is where we should start the process of traveling to the selected planet
        }

    }
}