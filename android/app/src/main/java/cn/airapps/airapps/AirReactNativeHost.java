package cn.airapps.airapps;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

import com.dianwoba.rctamap.AMapPackage;
import com.facebook.common.internal.ByteStreams;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.shell.MainReactPackage;
import com.horcrux.svg.RNSvgPackage;
import com.pili.rnpili.PiliPackage;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


import javax.annotation.Nullable;

import cn.airapps.umeng.UmengAir;
import io.rong.imlib.ipc.IMLibPackage;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by buhe on 16/9/26.
 */
public class AirReactNativeHost extends ReactNativeHost {


    public AirReactNativeHost(Application application) {
        super(application);
    }

    @Override
    protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new PiliPackage(),
                new UmengAir(),
                new AMapPackage(),
                new RNSvgPackage(),
                new IMLibPackage()
        );
    }


    protected ReactInstanceManager createReactInstanceManager() {
        //需要优化成异步

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication().getApplicationContext());
        mPreferences.edit().putString("debug_http_host","192.168.181.105:8081").commit();

        return super.createReactInstanceManager();
    }
}
