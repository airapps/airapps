package cn.airapps.airapps;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dianwoba.rctamap.AMapPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.horcrux.svg.RNSvgPackage;
import com.pili.rnpili.PiliPackage;
import com.theweflex.react.WeChatPackage;
import com.rnfs.RNFSPackage;

import java.util.Arrays;
import java.util.List;

import cn.airapps.umeng.UmengAir;
import io.rong.imlib.ipc.IMLibPackage;

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
                new IMLibPackage(),
                new RNFSPackage(),
                new WeChatPackage()
        );
    }


    protected ReactInstanceManager createReactInstanceManager() {
        //需要优化成异步

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication().getApplicationContext());
        mPreferences.edit().putString("debug_http_host", "192.168.0.104:8081").commit();

        return super.createReactInstanceManager();
    }
}
