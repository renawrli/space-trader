package cs2340.garbagecollection.spacetrader.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cs2340.garbagecollection.spacetrader.R;

public class MarketListAdapter extends RecyclerView.Adapter<MarketListAdapter.ViewHolder> {

    private ArrayList<String> mItemNames = new ArrayList<>();
    private ArrayList<Integer> mItemPrices = new ArrayList<>();
    private Context mContext;

    public MarketListAdapter(ArrayList<String> itemNames, ArrayList<Integer> itemPrices, Context context) {
        mItemNames = itemNames;
        mItemPrices = itemPrices;
        mContext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.market_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemName.setText(mItemNames.get(i));
        viewHolder.itemPrice.setText(mItemPrices.get(i)+"");
    }

    @Override
    public int getItemCount() {
        return mItemNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView itemName;
        TextView itemPrice;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            parentLayout = itemView.findViewById(R.id.marketItemLayout);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            System.out.println("Clicking at posit" +
                    "ion " + getAdapterPosition());
           //dialogue box
        }
    }
}