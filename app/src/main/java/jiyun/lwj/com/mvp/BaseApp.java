package jiyun.lwj.com.mvp;

import android.app.Application;

/**
 * Created by asus on 2019/3/5.
 */

public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
    }

    public static BaseApp getInstance(){
        return sBaseApp;
    }
}
