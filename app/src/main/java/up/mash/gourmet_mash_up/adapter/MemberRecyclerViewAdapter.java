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
import up.mash.gourmet_mash_up.item.FoodItem;
import up.mash.gourmet_mash_up.item.ItemwithType;
import up.mash.gourmet_mash_up.item.UserIdItem;

/**
 * Created by derba on 2018-08-01.
 */

public class MemberRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ItemwithType> arrayListofItemInfos;

    public MemberRecyclerViewAdapter(ArrayList<ItemwithType> arrayListofItemInfos) {
        this.arrayListofItemInfos = arrayListofItemInfos;
    }

    class FoodItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView menuImage;
        public TextView tradeName;
        public TextView menuName;
        public TextView locaionName;
        public ImageView best_wish;
        public ImageView likeDislike;

        public FoodItemViewHolder(View itemView) {
            super(itemView);

            menuImage = itemView.findViewById(R.id.menu_image);
            tradeName = itemView.findViewById(R.id.trade_name);
            menuName = itemView.findViewById(R.id.menu_name);
            locaionName = itemView.findViewById(R.id.location_name);
            likeDislike = itemView.findViewById(R.id.like_dislike);
        }
    }

    class UserIdViewHolder extends RecyclerView.ViewHolder {

        public TextView userId;

        public UserIdViewHolder(View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.member_user_id);
        }
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 0:
                return new FoodItemViewHolder(layoutInflater.inflate(R.layout.food_wish, parent, false));
            case 1:
                return new UserIdViewHolder(layoutInflater.inflate(R.layout.user_id_items, parent, false));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemwithType itemwithType = arrayListofItemInfos.get(position);

        if (holder instanceof FoodItemViewHolder) {
            FoodItem foodItem = (FoodItem) itemwithType;

            ((FoodItemViewHolder) holder).menuImage.setImageResource(R.drawable.food_ex);
            ((FoodItemViewHolder) holder).tradeName.setText(foodItem.getTradeName());
            ((FoodItemViewHolder) holder).menuName.setText(foodItem.getMenuName());
            ((FoodItemViewHolder) holder).locaionName.setText(foodItem.getLocationName());

        } else {
            UserIdItem userIdItem = (UserIdItem) itemwithType;

            ((UserIdViewHolder) holder).userId.setText(userIdItem.getUserId());
        }
    }

    @Override
    public int getItemCount() {
        return arrayListofItemInfos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return arrayListofItemInfos.get(position).getType();
    }
}