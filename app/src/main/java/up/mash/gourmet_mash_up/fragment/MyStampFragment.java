package up.mash.gourmet_mash_up.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MyStampRecyclerViewAdapter;
import up.mash.gourmet_mash_up.item.FoodStamp;

public class MyStampFragment extends Fragment {

    MyStampRecyclerViewAdapter myStampRecyclerViewAdapter;
    RecyclerView myStampRecyclerView;
    ArrayList<FoodStamp> arrayListofStamp;

    public static MyStampFragment newInstance(Context context) {
        return new MyStampFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_stamp, container, false);

        initStampList();

        myStampRecyclerView = view.findViewById(R.id.my_stamp_recycler_view);
        myStampRecyclerViewAdapter = new MyStampRecyclerViewAdapter(arrayListofStamp);
        myStampRecyclerView.setAdapter(myStampRecyclerViewAdapter);

        myStampRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void initStampList() {
        arrayListofStamp = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            FoodStamp foodStamp = new FoodStamp();

            foodStamp.setLocationName("상호명" + (i + 1));
            foodStamp.setMenuName("메뉴명" + (i + 1));
            foodStamp.setTradeName("위치명" + (i + 1));
            foodStamp.setLike_dislike((i / 2) == 0);

            arrayListofStamp.add(foodStamp);

//            Log.e("create", "menuName : " + foodStamp.getMenuName());
        }
    }
}
