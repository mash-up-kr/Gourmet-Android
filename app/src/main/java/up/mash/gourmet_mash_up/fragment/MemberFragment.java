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

import butterknife.ButterKnife;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MemberRecyclerViewAdapter;
import up.mash.gourmet_mash_up.item.FoodItem;
import up.mash.gourmet_mash_up.item.ItemwithType;
import up.mash.gourmet_mash_up.item.UserIdItem;


public class MemberFragment extends Fragment {

    //@BindView(R.id.member_recycler_view)
    RecyclerView recyclerView;

    MemberRecyclerViewAdapter memberRecyclerViewAdapter;

    public ArrayList<ItemwithType> arrayListofItems;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_member, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        initArrayListofItems();

        memberRecyclerViewAdapter = new MemberRecyclerViewAdapter(arrayListofItems);

        recyclerView = view.findViewById(R.id.member_recycler_view);

        recyclerView.setAdapter(memberRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    public void initArrayListofItems() {
        arrayListofItems = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                UserIdItem userIdItem = new UserIdItem();

                userIdItem.setUserId("@userId" + (i / 2 + 1));

                arrayListofItems.add(userIdItem);

                Log.e("create", "userId : " + userIdItem.getUserId());
            } else {
                FoodItem foodItem = new FoodItem();

                foodItem.setImageLink("food_ex.png");
                foodItem.setTradeName("상호명" + (i / 2 + 1));
                foodItem.setMenuName("메뉴명" + (i / 2 + 1));
                foodItem.setLocationName("위치명" + (i / 2 + 1));
                foodItem.setWish((i / 2) % 2 == 0);
                foodItem.setLikeDislike(!((i / 2) % 2 == 0));

                arrayListofItems.add(foodItem);

                Log.e("create", "menuName : " + foodItem.getMenuName());

            }
        }
    }
}
