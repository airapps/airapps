package cn.airapps.airapps;

import android.app.Application;
import android.os.Handler;
import android.util.Log;

import com.facebook.common.internal.ByteStreams;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
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
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by buhe on 16/9/26.
 */
public class AirReactNativeHost extends ReactNativeHost {

    String URL = "http://192.168.180.97:8081/index.android.bundle?platform=android&dev=true&hot=false&minify=false";
    private static final int HTTP_NOT_MODIFIED = 304;
    String TAG = "AirReactNativeHost";
    private final OkHttpClient client = new OkHttpClient();


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
                new UmengAir()
        );
    }


    public String loadJSBundleSync(final String urlString) {
        String fileName = "AirApps";
        final File directory = new File(getApplication().getFilesDir(), fileName);
        if (!directory.exists()) {
            directory.mkdir();
        }
        try {
            Request request = new Request.Builder()
                    .url(urlString)
                    .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) return null;
            boolean hasCachedSourceFile = false;
            final File sourceFile = new File(directory, "AirApps.js");

            if (response.networkResponse() == null || response.networkResponse().code() == HTTP_NOT_MODIFIED) {
                // If we're getting a cached response don't rewrite the file to disk.
                Log.d(TAG, "Got cached OkHttp response for " + urlString);
                if (sourceFile.exists()) {
                    hasCachedSourceFile = true;
                    Log.d(TAG, "Have cached source file for " + urlString);
                }
            }

            if (!hasCachedSourceFile) {
                Log.d(TAG, "Do not have cached source file for " + urlString);
                InputStream inputStream = response.body().byteStream();

                FileOutputStream fileOutputStream = new FileOutputStream(sourceFile);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                // TODO: close the streams using the try () syntax
                ByteStreams.copy(inputStream, bufferedOutputStream);
                bufferedOutputStream.flush();
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                bufferedOutputStream.close();
                fileOutputStream.close();
                inputStream.close();
            }

            printSourceFile(sourceFile.getAbsolutePath());

        } catch (Exception e) {

        }

        // Guess whether we'll use the cache based on whether the source file is saved.
        final File sourceFile = new File(directory, fileName);
        return sourceFile.getAbsolutePath();
    }

    private void printSourceFile(String path) {
        Log.d(TAG, "Printing bundle:");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);

            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputReader);

            String line;
            do {
                line = bufferedReader.readLine();
                Log.d(TAG, line);
            } while (line != null);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                }
            }
        }
    }


    protected ReactInstanceManager createReactInstanceManager() {
        //需要优化成异步
        String jsBundleFile = loadJSBundleSync(URL);
        ReactInstanceManager.Builder builder = ReactInstanceManager.builder()
                .setApplication(this.getApplication())
                .setJSMainModuleName(getJSMainModuleName())
                .setUseDeveloperSupport(getUseDeveloperSupport())
                .setRedBoxHandler(getRedBoxHandler())
                .setUIImplementationProvider(getUIImplementationProvider())
                .setInitialLifecycleState(LifecycleState.BEFORE_CREATE);

        for (ReactPackage reactPackage : getPackages()) {
            builder.addPackage(reactPackage);
        }

        if (jsBundleFile != null) {
            builder.setJSBundleFile(jsBundleFile);
        } else {
            builder.setBundleAssetName(Assertions.assertNotNull(getBundleAssetName()));
        }
        return builder.build();
    }
}
