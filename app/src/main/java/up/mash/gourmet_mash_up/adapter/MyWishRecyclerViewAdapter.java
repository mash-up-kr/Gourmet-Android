package up.mash.gourmet_mash_up.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.remote.model.WishModel;

public class MyWishRecyclerViewAdapter extends RecyclerView.Adapter<MyWishViewHolder> {

    private List<WishModel> myWishList;
    private Context mContext;

    public MyWishRecyclerViewAdapter(List<WishModel> myWishList, Context context) {
        this.myWishList = myWishList;
        this.mContext = context;
    }

    public void updateReview(List<WishModel> wishModels) {
        myWishList.clear();
        myWishList.addAll(wishModels);
        notifyDataSetChanged();
    }

    @NonNull
    public MyWishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyWishViewHolder(layoutInflater.inflate(R.layout.food_wish, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyWishViewHolder holder, int position) {

        WishModel singleWishModel = myWishList.get(position);

        Glide.with(mContext)
                .load(singleWishModel.getWishImageUrl())
                .into(holder.menuImage);

        holder.tradeName.setText(singleWishModel.getRestaurant().getName());
        holder.menuName.setText(singleWishModel.getMenu().getName());
        holder.locaionName.setText(singleWishModel.getRestaurant().getAddress());
        //TODO 이상.
        holder.best_wish.setImageResource(TextUtils.isEmpty(singleWishModel.getStamp())
                ? R.drawable.favorite_icon_fill
                : R.drawable.favorite_icon_none);
        holder.menuImage.setOnClickListener(v -> Toast.makeText(mContext, "GG", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return myWishList.size();
    }
}

class MyWishViewHolder extends RecyclerView.ViewHolder {

    public ImageView menuImage;
    public TextView tradeName;
    public TextView menuName;
    public TextView locaionName;
    public ImageView best_wish;

    MyWishViewHolder(View itemView) {
        super(itemView);

        menuImage = itemView.findViewById(R.id.menu_image);
        menuImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        best_wish = itemView.findViewById(R.id.like_dislike);
        tradeName = itemView.findViewById(R.id.trade_name);
        menuName = itemView.findViewById(R.id.menu_name);
        locaionName = itemView.findViewById(R.id.location_name);
    }
}