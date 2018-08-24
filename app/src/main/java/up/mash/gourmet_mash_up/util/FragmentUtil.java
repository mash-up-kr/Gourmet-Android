package up.mash.gourmet_mash_up.util;

import android.support.v4.app.FragmentManager;

public class FragmentUtil {

    public static Boolean removeBackStackIfexisted(FragmentManager fm) {
        return fm.popBackStackImmediate();
    }

}
