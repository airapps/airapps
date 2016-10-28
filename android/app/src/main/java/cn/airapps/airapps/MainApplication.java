package cn.airapps.airapps;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.pili.rnpili.PiliPackage;
import com.qiniu.pili.droid.report.QosEnv;
import com.qiniu.pili.droid.streaming.StreamingEnv;
import com.umeng.analytics.MobclickAgent;

import java.util.Arrays;
import java.util.List;

import cn.airapps.umeng.UmengAir;


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
