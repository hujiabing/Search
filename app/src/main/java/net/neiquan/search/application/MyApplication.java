package net.neiquan.search.application;

import android.app.Application;

/**
 * 作者:  hjb
 * 时间: 2016/2/28.
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
