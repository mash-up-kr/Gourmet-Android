package up.mash.gourmet_mash_up.fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;

import java.util.Locale;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MyPageTabPagerAdapter;
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;
import up.mash.gourmet_mash_up.data.remote.model.UserModel;

public class MyPageFragment extends Fragment {

    private static final String TAG = "MyPageFragment";
    ImageView profileImage;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    String user_token;
    CollapsingToolbarLayout collapsingToolbarLayout;

    public static MyPageFragment newInstance() {
        return new MyPageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @SuppressLint("CheckResult")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);

        collapsingToolbarLayout = view.findViewById(R.id.my_page_collapse);
        viewPager = view.findViewById(R.id.my_view_pager);
        tabLayout = view.findViewById(R.id.my_tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("위시리스트"));
        tabLayout.addTab(tabLayout.newTab().setText("스탬프"));

        View detailLayout = view.findViewById(R.id.my_profile_detail_layout);
        ImageView profileImage = detailLayout.findViewById(R.id.profile_image);
        TextView profileMyLank = detailLayout.findViewById(R.id.profile_my_rank);
        TextView profileMyId = detailLayout.findViewById(R.id.profile_my_id);
        TextView profileMyName = detailLayout.findViewById(R.id.profile_my_name);
        TextView profileMyFollwerNumber = detailLayout.findViewById(R.id.profile_my_follower_number);
        TextView profileMyFollowingNumber = detailLayout.findViewById(R.id.profile_my_following_number);
        TextView profileIntro = detailLayout.findViewById(R.id.profile_my_intro);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        user_token = preferences.getString("auth_token", "");

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.bronz);
        requestOptions.error(R.drawable.bronz);
        GourmatRestManager
                .getMe(user_token)
                .subscribe((UserModel author) -> {
                            profileMyLank.setText(String.format(Locale.KOREAN, "랭킹 %d위", author.getId()));
                            profileMyName.setText(author.getUsername());
                            profileIntro.setText(author.getIntroduce());
                            profileMyFollowingNumber.setText(String.format(Locale.KOREAN, "%3d", author.getFollowingCount()));
                            profileMyFollwerNumber.setText(String.format(Locale.KOREAN, "%3d", author.getFollowerCount()));

                        },
                        (t) -> Log.e(TAG, t.getMessage()),
                        () -> Log.d(TAG, "getMyProfile Complete")
                );
        MyPageTabPagerAdapter myPageTabPagerAdapter = new MyPageTabPagerAdapter(getContext(), getChildFragmentManager(), 2);
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

    public void bindingMyProfile(UserModel author, View detailLayout) {


    }
}
