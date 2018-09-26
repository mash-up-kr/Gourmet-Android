package up.mash.gourmet_mash_up.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class NewsFeedRecyclerViewAdapter extends RecyclerView.Adapter<NewsFeedRecyclerViewAdapter.NewsFeedViewHolder> {

    private ArrayList<Integer> listofNewsFeed;

    public NewsFeedRecyclerViewAdapter(ArrayList listofNewsFeed) {
        this.listofNewsFeed = listofNewsFeed;
    }

    @NonNull
    @Override
    public NewsFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new NewsFeedViewHolder( layoutInflater.inflate(R.layout.grid_layout, parent, false) );
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedViewHolder holder, int position) {
        holder.imageView.setImageResource(listofNewsFeed.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listofNewsFeed.size();
    }

    static class NewsFeedViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public NewsFeedViewHolder(View view) {
            super(view);
            this.imageView = view.findViewById(R.id.grid_layout_content);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }
}

