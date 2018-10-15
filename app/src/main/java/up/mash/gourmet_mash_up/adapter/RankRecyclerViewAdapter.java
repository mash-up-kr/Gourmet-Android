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
import up.mash.gourmet_mash_up.item.RankItem;

public class RankRecyclerViewAdapter extends RecyclerView.Adapter<RankRecyclerViewAdapter.RankItemViewHolder> {

    private ArrayList<RankItem> mArrayList;

    public RankRecyclerViewAdapter(ArrayList<RankItem> items) {
        this.mArrayList = items;
    }

    @NonNull
    @Override
    public RankItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new RankItemViewHolder(layoutInflater.inflate(R.layout.item_ranking_profile, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RankItemViewHolder holder, int position) {

        RankItem item = mArrayList.get(position);

        holder.rankingNumber.setText(item.getRankingNumber());
        holder.userId.setText(item.getUserId());
        holder.userFollowerCount.setText(item.getUserFollowerCount());
        holder.stampCount.setText(item.getStampCount());
        holder.userIdImageView.setImageResource(R.drawable.bronz);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class RankItemViewHolder extends RecyclerView.ViewHolder {

        TextView rankingNumber;
        ImageView userIdImageView;
        TextView userId;
        TextView stampCount;
        TextView userFollowerCount;

        RankItemViewHolder(View itemView) {
            super(itemView);

            rankingNumber = itemView.findViewById(R.id.ranking_number);
            userIdImageView = itemView.findViewById(R.id.user_id_image);
            userId = itemView.findViewById(R.id.user_id);
            stampCount = itemView.findViewById(R.id.stamp_count);
            userFollowerCount = itemView.findViewById(R.id.user_follower_count);
        }
    }

}
