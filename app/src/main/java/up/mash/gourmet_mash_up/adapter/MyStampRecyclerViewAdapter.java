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

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.remote.model.ReviewModel;

/**
 * Created by derba on 2018-08-01.
 */

public class MyStampRecyclerViewAdapter extends RecyclerView.Adapter<MyStampViewHolder> {

    private ArrayList<ReviewModel> myStampList;
    private Context mContext;

    public MyStampRecyclerViewAdapter(ArrayList<ReviewModel> myStampList, Context context) {
        this.myStampList = myStampList;
        this.mContext = context;
    }

    @NonNull
    public MyStampViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyStampViewHolder(layoutInflater.inflate(R.layout.food_stamp, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyStampViewHolder holder, int position) {

        if (position < myStampList.size()) {
            ReviewModel reviewModel = myStampList.get(position);
            Timber.i(reviewModel.getReviewImageUrl());
            Glide.with(mContext)
                    .load(reviewModel.getReviewImageUrl())
                    .into(holder.menuImage);

            if(TextUtils.isEmpty(reviewModel.getStamp())){
                holder.stamp.setImageResource(R.drawable.good_stamp);
            }
            if(TextUtils.equals(reviewModel.getStamp(), "LIKE")){
                holder.stamp.setImageResource(R.drawable.good_stamp);
            } else {
                holder.stamp.setImageResource(R.drawable.bad_stamp);
            }

            holder.tradeName.setText(reviewModel.getRestaurant().getName());
            holder.menuName.setText(reviewModel.getMenu().getName());
            holder.locaionName.setText(reviewModel.getRestaurant().getAddress());

            holder.menuImage.setOnClickListener(v -> {
                Toast.makeText(mContext, "GG", Toast.LENGTH_SHORT).show();
            });


        }


    }

    @Override
    public int getItemCount() {
        return myStampList.size();
    }

    public void updateStamp(List<ReviewModel> res) {
        myStampList.clear();
        myStampList.addAll(res);
        notifyDataSetChanged();
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
        stamp = itemView.findViewById(R.id.my_stamp);
    }
}