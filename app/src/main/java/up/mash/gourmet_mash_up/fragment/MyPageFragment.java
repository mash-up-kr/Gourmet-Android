package up.mash.gourmet_mash_up.fragment;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MyPageTabPagerAdapter;

/**
 * Created by derba on 2018-08-11.
 */

public class MyPageFragment extends Fragment {

    ImageView profileImage;

    TabLayout tabLayout;

    ViewPager viewPager;

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
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);

        profileImage = view.findViewById(R.id.profile_image);
        tabLayout = view.findViewById(R.id.my_tab_layout);
        viewPager = view.findViewById(R.id.my_view_pager);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileImage.setBackground(new ShapeDrawable(new OvalShape()));

        if (Build.VERSION.SDK_INT >= 21) profileImage.setClipToOutline(true);

        tabLayout.addTab(tabLayout.newTab().setText("위시리스트 (000)"));
        tabLayout.addTab(tabLayout.newTab().setText("스탬프 (000)"));

        MyPageTabPagerAdapter myPageTabPagerAdapter = new MyPageTabPagerAdapter( getChildFragmentManager() , tabLayout.getTabCount());
        viewPager.setAdapter(myPageTabPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
