package up.mash.gourmet_mash_up.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import timber.log.Timber;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MyWishRecyclerViewAdapter;
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;
import up.mash.gourmet_mash_up.data.remote.model.WishModel;


public class MyWishFragment extends Fragment {

    MyWishRecyclerViewAdapter myWishRecyclerViewAdapter;
    RecyclerView myWishRecyclerView;
    ArrayList<WishModel> myWishList;
    Context mContext;

    public static MyWishFragment newInstance() {
        return new MyWishFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getContext();
    }

    @SuppressLint("CheckResult")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_wish, container, false);
        myWishRecyclerView = view.findViewById(R.id.my_wish_recycler_view);
        View background_layout_view = view.findViewById(R.id.background_when_no_internet);

        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = null;

        if (cm != null) {
            activeNetwork = cm.getActiveNetworkInfo();
        }


        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (isConnected) {

            background_layout_view.setVisibility(View.GONE);
            myWishRecyclerView.setVisibility(View.VISIBLE);

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            String token = preferences.getString("auth_token", "");
            Timber.d(token);

            myWishList = new ArrayList<>();

            myWishRecyclerViewAdapter = new MyWishRecyclerViewAdapter(myWishList, mContext);
            myWishRecyclerView.setAdapter(myWishRecyclerViewAdapter);

            myWishRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
            GourmatRestManager
                    .getWishListOnMe(token)
                    .subscribe(
                            (res) -> myWishRecyclerViewAdapter.updateReview(res),
                            Timber::d,
                            () -> Timber.d("onTotalWIshList")
                    );
        } else if (myWishList.size() <= 0) {

            //TODO 내용물이 없을 경우.

        } else {
            //인터넷 연결 안될 때

            myWishRecyclerView.setVisibility(View.GONE);
            background_layout_view.setVisibility(View.VISIBLE);
            Button refershButton = background_layout_view.findViewById(R.id.button_refresh_internet);
            refershButton.setOnClickListener(v -> {
                refreshList();
            });
        }
        return view;
    }

    @SuppressLint("CheckResult")
    private void refreshList() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String token = preferences.getString("auth_token", "");
        Timber.d(token);
        GourmatRestManager.getWishListOnMe(token)
                .subscribe(
                        (res) -> myWishRecyclerViewAdapter.updateReview(res),
                        Timber::d,
                        () -> Timber.d("onTotalWIshList")
                );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
