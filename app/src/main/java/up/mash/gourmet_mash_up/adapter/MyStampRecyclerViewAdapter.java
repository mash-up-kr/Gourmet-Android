package up.mash.gourmet_mash_up.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.item.FoodStamp;

/**
 * Created by derba on 2018-08-01.
 */

public class MyStampRecyclerViewAdapter extends RecyclerView.Adapter<MyStampViewHolder> {

    private ArrayList<FoodStamp> arrayListofStampInfos;

    public MyStampRecyclerViewAdapter(ArrayList<FoodStamp> arrayListofItemInfos) {
        this.arrayListofStampInfos = arrayListofItemInfos;
    }

    @NonNull
    public MyStampViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new MyStampViewHolder(layoutInflater.inflate(R.layout.food_stamp, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyStampViewHolder holder, int position) {

        FoodStamp foodStamp = arrayListofStampInfos.get(position);

        holder.menuImage.setImageResource(R.drawable.food_ex);
        holder.tradeName.setText(foodStamp.getTradeName());
        holder.menuName.setText(foodStamp.getMenuName());
        holder.locaionName.setText(foodStamp.getLocationName());

    }

    @Override
    public int getItemCount() {
        return arrayListofStampInfos.size();
    }

}

class MyStampViewHolder extends RecyclerView.ViewHolder {

    public ImageView menuImage;
    public TextView tradeName;
    public TextView menuName;
    public TextView locaionName;
    public ImageView stamp;

    public MyStampViewHolder(View itemView) {
        super(itemView);

        menuImage = itemView.findViewById(R.id.menu_image);
        tradeName = itemView.findViewById(R.id.trade_name);
        menuName = itemView.findViewById(R.id.menu_name);
        locaionName = itemView.findViewById(R.id.location_name);
        stamp = itemView.findViewById(R.id.stamp);
    }
}