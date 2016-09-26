package cn.airapps.airapps.devframe;

import android.app.Application;
import android.content.Context;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.pili.rnpili.PiliPlayerViewManager;
import com.pili.rnpili.PiliStreamingViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by buhe on 16/9/24.
 */
public class DevFramePackage implements ReactPackage {

    private Context applicationContext;
    private Application application;

    public DevFramePackage(Context applicationContext, Application application) {
        this.applicationContext = applicationContext;
        this.application = application;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new DevFrameManager(applicationContext,application)
        );
    }
}
