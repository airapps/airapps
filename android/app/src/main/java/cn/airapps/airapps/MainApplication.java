package cn.airapps.airapps;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;


public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new AirReactNativeHost(this);

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("AirApps Env","--------------------");

        Log.i("AirApps Env",BuildConfig.AMAP_ANDROID_KEY);

        Log.i("AirApps Env","--------------------");

    }
}
