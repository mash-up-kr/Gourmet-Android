package up.mash.gourmet_mash_up.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import up.mash.gourmet_mash_up.fragment.HomeFragment;
import up.mash.gourmet_mash_up.fragment.MemberFragment;
import up.mash.gourmet_mash_up.fragment.RankFragment;

/**
 * Created by derba on 2018-06-30.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {

    private final HomeFragment homeFragment;
    private final MemberFragment memberFragment;
    private final RankFragment rankFragment;


    public ViewPageAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);

        homeFragment = HomeFragment.newInstance(null, null);
        memberFragment = MemberFragment.newInstance(null, null);
        rankFragment = RankFragment.newInstance(null, null);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return homeFragment;
            case 1:
                return memberFragment;
            case 2:
                return rankFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
