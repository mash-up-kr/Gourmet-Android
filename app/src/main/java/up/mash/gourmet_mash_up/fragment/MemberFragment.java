package up.mash.gourmet_mash_up.fragment;

import android.annotation.SuppressLint;
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
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;
import up.mash.gourmet_mash_up.data.remote.model.ReviewModel;


public class MemberFragment extends Fragment {

    private static final String TAG = MemberFragment.class.getSimpleName();

    RecyclerView recyclerView;
    NewsFeedRecyclerViewAdapter memberRecyclerViewAdapter;
    public ArrayList<ReviewModel> arrayListOfItems;

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

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String token = preferences.getString("auth_token", "");
        Log.d(TAG, token);
        arrayListOfItems = new ArrayList<>();
        memberRecyclerViewAdapter = new NewsFeedRecyclerViewAdapter(arrayListOfItems);

        GourmatRestManager.getTotalWishlists(token)
                .subscribe(
                        (wishLists) -> {
                            memberRecyclerViewAdapter.updateReview(wishLists);
                        },
                        Throwable::getMessage,
                        () -> Log.d("totalwish", "onComplate")
                );
        recyclerView = view.findViewById(R.id.news_feed_recycler_view);
        recyclerView.setAdapter(memberRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }
}
