package up.mash.gourmet_mash_up.view;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;

public class GourmetBottomNavigation extends BottomNavigationView {

    public GourmetBottomNavigation(Context context) {
        super(context);
    }

    public GourmetBottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GourmetBottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setSelectedItemId(int itemId) {
        super.setSelectedItemId(itemId);
    }
}
