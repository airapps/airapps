package cn.airapps.airapps;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.burlap.filetransfer.FileTransferPackage;
import com.dianwoba.rctamap.AMapPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.filepicker.FilePickerPackage;
import com.horcrux.svg.RNSvgPackage;
import com.oblador.vectoricons.VectorIconsPackage;
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
                new WeChatPackage(),
                new FilePickerPackage(),
                new FileTransferPackage(),
                new VectorIconsPackage()
        );
    }


    protected ReactInstanceManager createReactInstanceManager() {
        //需要优化成异步

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication().getApplicationContext());
        mPreferences.edit().putString("debug_http_host", BuildConfig.DEBUG_IP + ":8081").commit();

        return super.createReactInstanceManager();
    }
}
