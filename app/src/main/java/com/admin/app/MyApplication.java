package com.admin.app;

import android.app.Application;
import android.os.Handler;

import com.admin.app.util.PreferencesUtils;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class MyApplication extends Application {

    private static MyApplication instance;
    private static long mainThreadId;
    private static Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mainThreadId = android.os.Process.myTid();
        mainHandler = new Handler();
//        KLog.init(BuildConfig.LOG_DEBUG);//debug打印
        PreferencesUtils.instance().init(this);//数据存储
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public static long getMainThreadId() {
        return mainThreadId;
    }

    public static Handler getMainHandler() {
        return mainHandler;
    }
}
