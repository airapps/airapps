package cn.airapps.airapps.devframe;

import android.app.Application;
import android.content.Context;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by buhe on 16/9/24.
 */
public class DevFrameManager extends SimpleViewManager<DevFrame> {

    private Context applicationContext;
    private Application application;

    public DevFrameManager(Context applicationContext, Application application) {
        this.applicationContext = applicationContext;
        this.application = application;
    }

    @Override
    public String getName() {
        return DevFrame.class.getSimpleName();
    }

    @Override
    protected DevFrame createViewInstance(ThemedReactContext reactContext) {
        return new DevFrame(applicationContext,reactContext,application);
    }

    @ReactProp(name = "devURL")
    public void setDevURL(DevFrame devFrame,String devURL){
        devFrame.setDevURL(devURL);
    }
}
