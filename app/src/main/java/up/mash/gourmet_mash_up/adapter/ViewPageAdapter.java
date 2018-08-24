package up.mash.gourmet_mash_up.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import up.mash.gourmet_mash_up.fragment.MemberFragment;
import up.mash.gourmet_mash_up.fragment.MyPageFragment;
import up.mash.gourmet_mash_up.fragment.ProfileFragment;
import up.mash.gourmet_mash_up.fragment.RankFragment;


public class ViewPageAdapter extends FragmentPagerAdapter {

    private static final String TAG = ViewPageAdapter.class.getSimpleName();

    private final MyPageFragment homeFragment;
    private final MemberFragment memberFragment;
    private final RankFragment rankFragment;
    private final ProfileFragment profileFragment;

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);

        homeFragment = MyPageFragment.newInstance();
        memberFragment = MemberFragment.newInstance();
        rankFragment = RankFragment.newInstance(null, null);
        profileFragment = new ProfileFragment();
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
            case 3:
                return profileFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
