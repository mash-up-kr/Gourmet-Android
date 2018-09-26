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
import up.mash.gourmet_mash_up.item.UserInfo;

/**
 * Created by derba on 2018-08-01.
 */

public class RecommendRecyclerViewAdapter extends RecyclerView.Adapter<RecommendRecyclerViewAdapter.RecommendRecyclerViewHolder> {

    private ArrayList<UserInfo> listofUserInfo;

    UserInfo userInfo;

    public RecommendRecyclerViewAdapter(ArrayList listofUserInfo) {
        this.listofUserInfo = listofUserInfo;
    }

    @NonNull
    @Override
    public RecommendRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new RecommendRecyclerViewHolder( layoutInflater.inflate(R.layout.recommend_gourmet_item, parent, false) );
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendRecyclerViewHolder holder, int position) {
        userInfo = listofUserInfo.get(position);

        //holder.image.setImageDrawable();
        holder.id.setText(userInfo.getId());
        holder.stamp.setText(userInfo.getStamp());
        holder.follower.setText(userInfo.getFollower());
        holder.ranking.setText(userInfo.getRank());

    }

    @Override
    public int getItemCount() {
        return listofUserInfo.size();
    }

    static class RecommendRecyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView id, stamp, follower, ranking;

        public RecommendRecyclerViewHolder(View view) {
            super(view);

            this.image = view.findViewById(R.id.recommend_image);
            this.id = view.findViewById(R.id.recommend_id);
            this.stamp = view.findViewById(R.id.recommend_stamp);
            this.follower = view.findViewById(R.id.recommend_follwer);
            this.ranking = view.findViewById(R.id.recommend_ranking);
        }
    }
}

