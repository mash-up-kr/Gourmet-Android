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
import up.mash.gourmet_mash_up.item.FoodWish;

/**
 * Created by derba on 2018-08-01.
 */

public class MyWishRecyclerViewAdapter extends RecyclerView.Adapter<MyWishViewHolder> {

    private ArrayList<FoodWish> arrayListofItemInfos;

    public MyWishRecyclerViewAdapter(ArrayList<FoodWish> arrayListofItemInfos) {
        this.arrayListofItemInfos = arrayListofItemInfos;
    }

    @NonNull
    public MyWishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new MyWishViewHolder(layoutInflater.inflate(R.layout.food_wish, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyWishViewHolder holder, int position) {

        FoodWish foodWish = arrayListofItemInfos.get(position);

        holder.menuImage.setImageResource(R.drawable.food_ex);
        holder.tradeName.setText(foodWish.getTradeName());
        holder.menuName.setText(foodWish.getMenuName());
        holder.locaionName.setText(foodWish.getLocationName());
        //holder.best_wish.setImageResource(foodWish.getLike_dislike() ? R.drawable.add_wishlist_icon_active : R.drawable.add_wishlist_icon_none);
        holder.like_percentage.setText("취항저격" + foodWish.getLike_percentage() + "%");

    }

    @Override
    public int getItemCount() {
        return arrayListofItemInfos.size();
    }

}

class MyWishViewHolder extends RecyclerView.ViewHolder {

    public ImageView menuImage;
    public TextView tradeName;
    public TextView menuName;
    public TextView locaionName;
    public ImageView best_wish;
    public TextView like_percentage;

    public MyWishViewHolder(View itemView) {
        super(itemView);

        menuImage = itemView.findViewById(R.id.menu_image);
        tradeName = itemView.findViewById(R.id.trade_name);
        menuName = itemView.findViewById(R.id.menu_name);
        locaionName = itemView.findViewById(R.id.location_name);
        //best_wish = itemView.findViewById(R.id.like_percentage);
        like_percentage = itemView.findViewById(R.id.like_percentage);
    }
}