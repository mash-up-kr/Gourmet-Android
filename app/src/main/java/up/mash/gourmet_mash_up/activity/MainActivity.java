package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.ButterKnife;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.ViewPageAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    Intent it;

    BottomNavigationView bnView;

    private ViewPageAdapter viewPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        it = new Intent(this.getIntent());

        bnView = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.view_pager);
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bnView.setSelectedItemId(R.id.action_home);
                        break;
                    case 1:
                        bnView.setSelectedItemId(R.id.action_member);
                        break;
                    case 2:
                        bnView.setSelectedItemId(R.id.action_rank);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bnView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                viewPager.setCurrentItem(0, true);
                                break;
                            case R.id.action_member:
                                viewPager.setCurrentItem(1, true);
                                break;
                            case R.id.action_rank:
                                viewPager.setCurrentItem(2, true);
                                break;
                        }
                        return true;
                    }
                }
        );
    }
}
    