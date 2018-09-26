package up.mash.gourmet_mash_up.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import up.mash.gourmet_mash_up.fragment.MyStampFragment;
import up.mash.gourmet_mash_up.fragment.MyWishFragment;

/**
 * Created by derba on 2018-08-11.
 */

public class MyPageTabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount = 2;

    private final MyWishFragment myWishFragment;
    private final MyStampFragment myStampFragment;

    public MyPageTabPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);

        myWishFragment = MyWishFragment.newInstance(context);
        myStampFragment = MyStampFragment.newInstance(context);

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Log.e("return", "return myWishFragment!!");
                return myWishFragment;
            case 1:
                Log.e("return", "return myStampFragment!!");
                return myStampFragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
