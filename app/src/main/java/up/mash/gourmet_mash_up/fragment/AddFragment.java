package up.mash.gourmet_mash_up.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.activity.AddWishList_1;
import up.mash.gourmet_mash_up.activity.AddStampList_1;

public class AddFragment extends Fragment {


    public AddFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_fragmnet, container, false);

        TextView tv_add_wish_List = view.findViewById(R.id.add_wish_list);
        TextView tv_add_stamp = view.findViewById(R.id.add_stamp_list);

        tv_add_wish_List.setOnClickListener(v -> startActivity(new Intent(getContext(), AddWishList_1.class)));

        tv_add_stamp.setOnClickListener(v -> startActivity(new Intent(getContext(), AddStampList_1.class)));

        View backgroudview = view.findViewById(R.id.background_view);
        backgroudview.setClickable(false);
        backgroudview.setAlpha(0.6f);
        return view;
    }
}
