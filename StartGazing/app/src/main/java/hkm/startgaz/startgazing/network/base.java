package hkm.startgaz.startgazing.network;

import android.app.Application;

import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKClient;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKResponse;

import hkm.startgaz.startgazing.R;
import me.drakeet.library.CrashWoodpecker;

/**
 * Created by hesk on 8/10/15.
 */
public class base extends Application {
    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();
        CrashWoodpecker.fly().to(this);
        //inside onCreate
        PDKClient.configureInstance(this, getString(R.string.pinterest_ID));
        PDKClient.getInstance().onConnect(this);

    }
}
