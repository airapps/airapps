package cn.airapps.airapps.devframe;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.facebook.react.BuildConfig;
import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.shell.MainReactPackage;

import cn.airapps.airapps.MainActivity;

/**
 * Created by buhe on 16/9/24.
 */
public class DevFrame extends View {
    private String devURL;
    private final Context applicationContext;
    private Context context;
    private Application application;

    public DevFrame(Context applicationContext,Context context,Application application) {
        super(context);
        this.applicationContext = applicationContext;
        this.context = context;
        this.application = application;
    }

    public void setDevURL(String devURL) {
        this.devURL = devURL;
            ReactRootView mReactRootView = new ReactRootView(MainActivity.hack);
            ReactInstanceManager mReactInstanceManager = ReactInstanceManager.builder()
                    .setApplication(application)
//                    .setBundleAssetName("index.android.bundle")
//                    .setJSMainModuleName("index.android")
                    .addPackage(new MainReactPackage())
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    //.setUseOldBridge(true) // uncomment this line if your app crashes
                    .build();
            mReactRootView.startReactApplication(mReactInstanceManager, "AirKit", null);
    }
}
