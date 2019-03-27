package cs2340.garbagecollection.spacetrader.model

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import cs2340.garbagecollection.spacetrader.R
import cs2340.garbagecollection.spacetrader.viewmodel.TravelViewModel
import cs2340.garbagecollection.spacetrader.views.ConfigurationActivity
import cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game
import cs2340.garbagecollection.spacetrader.views.GameScreenActivity
import java.util.ArrayList


class PlanetListAdapterKotlin(planetNames: List<String>, distances: List<Int>, fuelUnitsCost: List<Int>, private val mContext: Context) : RecyclerView.Adapter<PlanetListAdapterKotlin.ViewHolder>() {

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
        internal var parentLayout: RelativeLayout = itemView.findViewById(R.id.planetItemLayout)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val game = ConfigurationActivity.game;
            TravelViewModel.travel(TravelViewModel.planetsInRange()[adapterPosition], game.getPlayer().ship)
            System.out.println("curr planet is " + game.getCurrLocation().name);
            val intent = Intent(view.context, GameScreenActivity::class.java)
            view.context.startActivity(intent)
            //this is where we should start the process of traveling to the selected planet
        }

    }
}