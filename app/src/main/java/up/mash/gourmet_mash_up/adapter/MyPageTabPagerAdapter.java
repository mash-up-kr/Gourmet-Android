package up.mash.gourmet_mash_up.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import up.mash.gourmet_mash_up.fragment.MyStampFragment;
import up.mash.gourmet_mash_up.fragment.MyWishFragment;

/**
 * Created by derba on 2018-08-11.
 */

public class MyPageTabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    private final MyWishFragment myWishFragment;
    private final MyStampFragment myStampFragment;

    public MyPageTabPagerAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);

        myWishFragment = MyWishFragment.newInstance();
        myStampFragment = MyStampFragment.newInstance();

        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return myWishFragment;
            case 1:
                return myStampFragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
