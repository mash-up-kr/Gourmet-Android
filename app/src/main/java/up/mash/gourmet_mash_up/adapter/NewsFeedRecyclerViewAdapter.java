package up.mash.gourmet_mash_up.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import timber.log.Timber;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.remote.model.ReviewModel;


public class NewsFeedRecyclerViewAdapter extends RecyclerView.Adapter<NewsFeedRecyclerViewAdapter.NewsFeedViewHolder> {

    private List<ReviewModel> listNewsFeeds;
    private Context mContext;

    public NewsFeedRecyclerViewAdapter(List<ReviewModel> listNewsFeeds, Context context) {
        this.listNewsFeeds = listNewsFeeds;
        this.mContext = context;
    }

    public void updateReview(List<ReviewModel> reviewModels) {
        listNewsFeeds.clear();
        listNewsFeeds.addAll(reviewModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new NewsFeedViewHolder(layoutInflater.inflate(R.layout.grid_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedViewHolder holder, int position) {

        if (position < listNewsFeeds.size()) {
            ReviewModel reviewModel = listNewsFeeds.get(position);

            Timber.i(reviewModel.getReviewImageUrl());

            Glide.with(mContext)
                    .load(reviewModel.getReviewImageUrl())
                    .into(holder.imageView);

            holder.itemView.setOnClickListener(v -> {
//                Intent goToDatailedActivity = new Intent(mContext, )
            });
        }
    }

    @Override
    public int getItemCount() {
        return listNewsFeeds.size();
    }

    static class NewsFeedViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        NewsFeedViewHolder(View view) {
            super(view);
            this.imageView = view.findViewById(R.id.grid_layout_content);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }
}

