package com.admin.app.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;

import com.admin.app.MyApplication;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class UIUtils {
    public static Context getContext() {
        return MyApplication.getInstance();
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    public static int getColor(int resId) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return ContextCompat.getColor(getContext(), resId);
        } else {
            return getResources().getColor(resId);
        }
    }

    /**
     * 让task在主线程中执行
     */
    public static void runOnUiThread(Runnable task) {
        int myTid = android.os.Process.myTid();
        if (myTid == getMainThreadId()) {
            task.run();
        } else {
            getMainHandler().post(task);
        }
    }

    public static long getMainThreadId() {
        return MyApplication.getMainThreadId();
    }

    public static Handler getMainHandler() {
        return MyApplication.getMainHandler();
    }

    /**
     * 执行延时任务
     */
    public static void postDelayed(Runnable task, long delayed) {
        getMainHandler().postDelayed(task, delayed);
    }

    /**
     * 移除任务
     */
    public static void removeCallbacks(Runnable task) {
        getMainHandler().removeCallbacks(task);
    }
}
