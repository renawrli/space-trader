package cs2340.garbagecollection.spacetrader.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import cs2340.garbagecollection.spacetrader.R
import java.util.ArrayList



class CargoListAdapterKotlin(itemNames: List<String>, itemCounts: List<Int>) :
        RecyclerView.Adapter<CargoListAdapterKotlin.ViewHolder>() {


    private var mItemNames = ArrayList<String>()
    private var mItemCounts = ArrayList<Int>()

    init {
        mItemNames = itemNames as ArrayList<String>
        mItemCounts = itemCounts as ArrayList<Int>
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.market_list_item,
                viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemName.text = mItemNames[i]
        viewHolder.itemCount.text = mItemCounts[i].toString() + ""
    }

    override fun getItemCount(): Int {
        return mItemNames.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var itemName: TextView = itemView.findViewById(R.id.itemName)
        internal var itemCount: TextView = itemView.findViewById(R.id.itemPrice)


    }
}