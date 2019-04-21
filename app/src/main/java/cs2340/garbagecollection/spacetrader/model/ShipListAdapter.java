package cs2340.garbagecollection.spacetrader.model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cs2340.garbagecollection.spacetrader.model.Game;
import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;
import java.util.ArrayList;

import cs2340.garbagecollection.spacetrader.R;
import cs2340.garbagecollection.spacetrader.viewmodel.ShipYardViewModel;
import cs2340.garbagecollection.spacetrader.views.GameScreenActivity;
import cs2340.garbagecollection.spacetrader.views.QuantityTransactionActivity;

public class ShipListAdapter extends RecyclerView.Adapter<ShipListAdapter.ViewHolder> {

    private ArrayList<String> mItemNames = new ArrayList<>();
    private ArrayList<Integer> mItemPrices = new ArrayList<>();
    private Context mContext;
    private static ShipYardViewModel shipYardViewModel;
    public ShipListAdapter(ArrayList<String> itemNames, ArrayList<Integer> itemPrices, Context context, ShipYardViewModel shipVM) {
        mItemNames = itemNames;
        mItemPrices = itemPrices;
        mContext = context;
        shipYardViewModel = shipVM;
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


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            if (shipYardViewModel.canBuyShip(game.getPlayer(), Integer.parseInt(itemPrice.getText().toString()))) {
                shipYardViewModel.buyNewShip(game.getPlayer(), new Ship(ShipType.valueOf(itemName.getText().toString())));
                System.out.println("new ship bought");
                Intent dialogue = new Intent(view.getContext(), GameScreenActivity.class);
                view.getContext().startActivity(dialogue);
            } else {
                System.out.println("can't buy ship");
            }
        }
    }
}