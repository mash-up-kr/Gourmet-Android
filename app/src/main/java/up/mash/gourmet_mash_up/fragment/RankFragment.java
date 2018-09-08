package up.mash.gourmet_mash_up.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.RankRecyclerViewAdapter;
import up.mash.gourmet_mash_up.item.RankItem;

public class RankFragment extends Fragment {

    RankRecyclerViewAdapter mRankRecyclerViewAdapter;
    RecyclerView rankRecyclerView;
    ArrayList<RankItem> mItemArrayList;

    public static RankFragment newInstance(String param1, String param2) {
        return new RankFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        initStampList();
        View view = inflater.inflate(R.layout.fragment_rank, container, false);

        rankRecyclerView = view.findViewById(R.id.rv_ranking);
        mRankRecyclerViewAdapter = new RankRecyclerViewAdapter(mItemArrayList);
        rankRecyclerView.setAdapter(mRankRecyclerViewAdapter);
        rankRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    public void initStampList() {
        mItemArrayList = new ArrayList<RankItem>();

        for (int i = 0; i < 10; i++) {
            RankItem rankItem = new RankItem();

            rankItem.setRankingNumber(i);
//            rankItem.setUrl();
            rankItem.setUserId(i + "- gourmet");
            rankItem.setStampCount("101");
            rankItem.setUserFollowerCount("324");
            mItemArrayList.add(rankItem);
        }
    }
}