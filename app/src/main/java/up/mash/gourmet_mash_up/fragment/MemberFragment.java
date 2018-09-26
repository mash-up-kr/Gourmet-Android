package up.mash.gourmet_mash_up.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.NewsFeedRecyclerViewAdapter;
import up.mash.gourmet_mash_up.item.FoodItem;
import up.mash.gourmet_mash_up.item.ItemwithType;
import up.mash.gourmet_mash_up.item.UserIdItem;


public class MemberFragment extends Fragment {

    RecyclerView recyclerView;

    NewsFeedRecyclerViewAdapter newsFeedRecyclerViewAdapter;

    public ArrayList<Integer> arrayListOfContent;

    public static MemberFragment newInstance() {
        return new MemberFragment();
    }

    public MemberFragment() {
        super();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_member, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initArrayListOfItems();

        newsFeedRecyclerViewAdapter = new NewsFeedRecyclerViewAdapter(arrayListOfContent);
        recyclerView = view.findViewById(R.id.news_feed_recycler_view);
        recyclerView.setAdapter(newsFeedRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

    }

    public void initArrayListOfItems() {
        arrayListOfContent = new ArrayList<>();

        for (int i = 0; i < 31; i++) {

            switch( i%4 ) {
                case 0:
                    arrayListOfContent.add(R.drawable.food_ex);
                    break;
                case 1:
                    arrayListOfContent.add(R.drawable.food_ex2);
                    break;
                case 2:
                    arrayListOfContent.add(R.drawable.food_ex3);
                    break;
                case 3:
                    arrayListOfContent.add(R.drawable.food_ex4);
                    break;
            }
        }
    }
}
