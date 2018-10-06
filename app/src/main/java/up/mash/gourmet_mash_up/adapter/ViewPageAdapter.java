package up.mash.gourmet_mash_up.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import up.mash.gourmet_mash_up.fragment.MemberFragment;
import up.mash.gourmet_mash_up.fragment.MyPageFragment;
import up.mash.gourmet_mash_up.fragment.RankFragment;

//import up.mash.gourmet_mash_up.fragment.MemberFragment;


public class ViewPageAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = ViewPageAdapter.class.getSimpleName();

    private final MemberFragment homeFragment;
    private final RankFragment rankFragment;
    private final MyPageFragment profileFragment;

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);

        homeFragment = MemberFragment.newInstance();
        rankFragment = RankFragment.newInstance(null, null);
        profileFragment = MyPageFragment.newInstance();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return homeFragment;
            case 1:
                return rankFragment;
            case 2:
                return profileFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
