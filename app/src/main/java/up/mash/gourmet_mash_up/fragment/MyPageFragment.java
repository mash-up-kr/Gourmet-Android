package up.mash.gourmet_mash_up.fragment;

import android.app.Fragment;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import up.mash.gourmet_mash_up.R;

/**
 * Created by derba on 2018-08-11.
 */

public class MyPageFragment extends Fragment {

    //BindView(R.id.profile_image)
    ImageView profileImage;

    public static MyPageFragment newInstance() {
        return new MyPageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container,false);

        profileImage = view.findViewById(R.id.profile_image);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileImage.setBackground(new ShapeDrawable(new OvalShape()));

        if (Build.VERSION.SDK_INT >= 21)
            profileImage.setClipToOutline(true);
    }
}
