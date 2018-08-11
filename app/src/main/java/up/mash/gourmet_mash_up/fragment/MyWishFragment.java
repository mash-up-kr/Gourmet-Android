package up.mash.gourmet_mash_up.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MyWishRecyclerViewAdapter;
import up.mash.gourmet_mash_up.item.FoodWish;

/**
 * Created by derba on 2018-08-11.
 */

public class MyWishFragment extends Fragment {

    MyWishRecyclerViewAdapter myWishRecyclerViewAdapter;
    RecyclerView myWishRecyclerView;
    ArrayList<FoodWish> arrayListofFood;

    public static MyWishFragment newInstance() {
        return new MyWishFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_wish, container, false);

        initWishList();

        myWishRecyclerView = view.findViewById(R.id.my_wish_recycler_view);
        myWishRecyclerViewAdapter = new MyWishRecyclerViewAdapter(arrayListofFood);
        myWishRecyclerView.setAdapter(myWishRecyclerViewAdapter);

        myWishRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void initWishList() {
        arrayListofFood = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            FoodWish foodWish = new FoodWish();

            foodWish.setLocationName("상호명" + (i + 1));
            foodWish.setMenuName("메뉴명" + (i + 1));
            foodWish.setTradeName("위치명" + (i + 1));
            foodWish.setLike_dislike((i / 2) == 0);
            foodWish.setLike_percentage((int) (Math.random() * 100));

            arrayListofFood.add(foodWish);

            Log.e("create", "menuName : " + foodWish.getMenuName());
        }
    }
}
