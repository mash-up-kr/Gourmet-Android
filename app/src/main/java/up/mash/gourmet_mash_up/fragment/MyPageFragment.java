package up.mash.gourmet_mash_up.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MyPageTabPagerAdapter;

/**
 * Created by derba on 2018-08-11.
 */

public class MyPageFragment extends Fragment {

    ImageView profileImage;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    CollapsingToolbarLayout collapsingToolbarLayout;

    public static MyPageFragment newInstance() {
        return new MyPageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);

        toolbar = view.findViewById(R.id.my_page_toolbar);

        collapsingToolbarLayout = view.findViewById(R.id.my_page_collapse);

        tabLayout = view.findViewById(R.id.my_tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("위시리스트 (000)"));
        tabLayout.addTab(tabLayout.newTab().setText("스탬프 (000)"));

        viewPager = view.findViewById(R.id.my_view_pager);

        MyPageTabPagerAdapter myPageTabPagerAdapter = new MyPageTabPagerAdapter(getContext(), getChildFragmentManager());
        viewPager.setAdapter(myPageTabPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.e("select", "select tab position : " + tab.getPosition());
                Toast.makeText(getContext(), "selectr ta", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.profile_button, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_profile:
                Toast.makeText(getContext(), "edit profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_something:
                Toast.makeText(getContext(), "edit something", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
