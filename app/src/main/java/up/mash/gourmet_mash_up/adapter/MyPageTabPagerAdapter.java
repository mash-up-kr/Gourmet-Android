package up.mash.gourmet_mash_up.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import timber.log.Timber;
import up.mash.gourmet_mash_up.fragment.MyStampFragment;
import up.mash.gourmet_mash_up.fragment.MyWishFragment;

public class MyPageTabPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = MyPageTabPagerAdapter.class.getSimpleName();

    private int tabCount;

    private final MyWishFragment myWishFragment;
    private final MyStampFragment myStampFragment;

    public MyPageTabPagerAdapter(Context context, FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);

        this.tabCount = tabCount;
        myWishFragment = MyWishFragment.newInstance();
        myStampFragment = MyStampFragment.newInstance();
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Timber.e("myWishFragment");
                return myWishFragment;
            case 1:
                Timber.e("myStampFragment");
                return myStampFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
