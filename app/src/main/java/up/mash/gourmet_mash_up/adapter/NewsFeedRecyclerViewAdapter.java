package up.mash.gourmet_mash_up.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.remote.model.ReviewModel;


public class NewsFeedRecyclerViewAdapter extends RecyclerView.Adapter<NewsFeedRecyclerViewAdapter.NewsFeedViewHolder> {

    private List<ReviewModel> listNewsFeeds;

    public NewsFeedRecyclerViewAdapter(List<ReviewModel> listNewsFeeds) {
        this.listNewsFeeds = listNewsFeeds;
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
//            holder.imageView.setImageResource(reviewModel.getMenuImages());
            holder.setReview(reviewModel);
            holder.itemView.setOnClickListener(v -> {
                //TODO 리뷰 보내기
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

        void setReview(ReviewModel review) {

        }
    }
}

