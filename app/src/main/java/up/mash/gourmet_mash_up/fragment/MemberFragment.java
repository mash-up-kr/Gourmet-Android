package up.mash.gourmet_mash_up.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.NewsFeedRecyclerViewAdapter;


public class MemberFragment extends Fragment {

    private static final String TAG = MemberFragment.class.getSimpleName();

    RecyclerView recyclerView;
    NewsFeedRecyclerViewAdapter memberRecyclerViewAdapter;
    public ArrayList<Object> arrayListOfItems;

    public static MemberFragment newInstance() {
        return new MemberFragment();
    }

    public MemberFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String token = preferences.getString("auth_token", "");
        Log.d(TAG, token);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_member, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initArrayListOfItems();

        memberRecyclerViewAdapter = new NewsFeedRecyclerViewAdapter(arrayListOfItems);
        recyclerView = view.findViewById(R.id.news_feed_recycler_view);
        recyclerView.setAdapter(memberRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

    }

    public void initArrayListOfItems() {
        arrayListOfItems = new ArrayList<>();

        for (int i = 0; i < 31; i++) {

            switch (i % 4) {
                case 0:
                    arrayListOfItems.add(R.drawable.food_ex);
                    break;
                case 1:
                    arrayListOfItems.add(R.drawable.food_ex);
                    break;
                case 2:
                    arrayListOfItems.add(R.drawable.food_ex);
                    break;
                case 3:
                    arrayListOfItems.add(R.drawable.food_ex);
                    break;
            }
        }
    }
}
