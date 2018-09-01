package up.mash.gourmet_mash_up;

import android.support.multidex.MultiDexApplication;

public class GourmetApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        patchEOFException();
    }

    private void patchEOFException() {
        System.setProperty("http.keepAlive", "false");
    }
}
