package up.mash.gourmet_mash_up.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Stack;

import butterknife.ButterKnife;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.ViewPageAdapter;
import up.mash.gourmet_mash_up.fragment.AddFragment;
import up.mash.gourmet_mash_up.util.FragmentUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    ViewPager viewPager;

    Intent it;

    BottomNavigationView bnView;
    BottomNavigationMenuView bnViewMenu;
    private ViewPageAdapter viewPageAdapter;
    AddFragment addFragment = new AddFragment();
    static Stack<Integer> fragmentBackStack = new Stack<>();


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        it = new Intent(this.getIntent());

        bnView = findViewById(R.id.bottom_navigation);
        bnViewMenu = (BottomNavigationMenuView) bnView.getChildAt(0);

        for (int i = 0; i < bnViewMenu.getChildCount(); i++) {
            BottomNavigationItemView itemView = (BottomNavigationItemView) bnViewMenu.getChildAt(i);
            itemView.setShiftingMode(false);
            itemView.setChecked(false);
        }

        viewPager = findViewById(R.id.view_pager);
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageAdapter);
        if(fragmentBackStack.isEmpty()) fragmentBackStack.push(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                Log.d(TAG, position + "");
                fragmentBackStack.push(position);
                switch (position) {
                    case 0:
                        bnView.setSelectedItemId(R.id.action_home);
                        break;
                    case 1:
                        bnView.setSelectedItemId(R.id.action_feed);
                        break;
                    case 2:
                        bnView.setSelectedItemId(R.id.action_rank);
                        break;
                    case 3:
                        bnView.setSelectedItemId(R.id.action_profile);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        bnView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            if (!FragmentUtil.removeBackStackIfexisted(getSupportFragmentManager()))
                                viewPager.setCurrentItem(0, true);
                            break;
                        case R.id.action_feed:
                            if (!FragmentUtil.removeBackStackIfexisted(getSupportFragmentManager()))
                                viewPager.setCurrentItem(1, true);
                            break;
                        case R.id.action_add:
                            if (!FragmentUtil.removeBackStackIfexisted(getSupportFragmentManager())) {
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.entry_view, addFragment)
                                        .addToBackStack(null)
                                        .commit();
                            } else if (!fragmentBackStack.isEmpty()) {
                                viewPager.setCurrentItem(fragmentBackStack.pop());
                                setSelectedItemId(fragmentBackStack.pop());
                            }
                            break;
                        case R.id.action_rank:
                            if (!FragmentUtil.removeBackStackIfexisted(getSupportFragmentManager()))
                                viewPager.setCurrentItem(2, true);
                            break;
                        case R.id.action_profile:
                            if (!FragmentUtil.removeBackStackIfexisted(getSupportFragmentManager()))
                                viewPager.setCurrentItem(3, true);
                            break;
                    }
                    return true;
                }
        );
    }

    @Override
    public void onBackPressed() {
        if (!fragmentBackStack.empty()) {
            int value = fragmentBackStack.pop();
            viewPager.setCurrentItem(value, true);
        } else {
            super.onBackPressed();
        }
    }

    public void setSelectedItemId(int position) {
        switch (position) {
            case 0:
                bnView.setSelectedItemId(R.id.action_home);
                break;
            case 1:
                bnView.setSelectedItemId(R.id.action_feed);
                break;
            case 2:
                bnView.setSelectedItemId(R.id.action_rank);
                break;
            case 3:
                bnView.setSelectedItemId(R.id.action_profile);
                break;
        }
    }

}
    