package up.mash.gourmet_mash_up.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
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

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MyWishRecyclerViewAdapter;
import up.mash.gourmet_mash_up.item.FoodWish;


public class MyWishFragment extends Fragment {

    MyWishRecyclerViewAdapter myWishRecyclerViewAdapter;
    RecyclerView myWishRecyclerView;
    ArrayList<FoodWish> arrayListOfFood;

    @SuppressLint("StaticFieldLeak")
    static Context mContext;

    public static MyWishFragment newInstance(Context context) {
        mContext = context;
        return new MyWishFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_wish, container, false);
        myWishRecyclerView = view.findViewById(R.id.my_wish_recycler_view);
        View background_layout_view = view.findViewById(R.id.background_when_no_internet);

        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = null;

        if (cm != null)
            activeNetwork = cm.getActiveNetworkInfo();


        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            background_layout_view.setVisibility(View.GONE);
            myWishRecyclerView.setVisibility(View.VISIBLE);
        } else if (arrayListOfFood.size() <= 0) {

            //TODO 내용물이 없을 경우.

        } else {
            myWishRecyclerView.setVisibility(View.GONE);
            background_layout_view.setVisibility(View.VISIBLE);
            Button refershButton = background_layout_view.findViewById(R.id.button_refresh_internet);
            refershButton.setOnClickListener(v -> {
                //TODO Retry Request
            });
        }

        initWishList();

        myWishRecyclerViewAdapter = new MyWishRecyclerViewAdapter(arrayListOfFood);
        myWishRecyclerView.setAdapter(myWishRecyclerViewAdapter);

        myWishRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initWishList() {

        arrayListOfFood = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            FoodWish foodWish = new FoodWish();

            foodWish.setLocationName("상호명" + (i + 1));
            foodWish.setMenuName("메뉴명" + (i + 1));
            foodWish.setTradeName("위치명" + (i + 1));
            foodWish.setLike_dislike((i / 2) == 0);
            foodWish.setLike_percentage((int) (Math.random() * 100));

            arrayListOfFood.add(foodWish);
        }
    }
}
