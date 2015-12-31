package com.admin.app.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.admin.app.constant.PreferencesKey;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class PreferencesUtils {
    private Context mContext;
    private SharedPreferences mSharedPreferences;
    private static PreferencesUtils mUtils = null;

    private PreferencesUtils() {
    }

    public static PreferencesUtils instance() {
        if (mUtils == null) {
            synchronized (PreferencesUtils.class) {
                mUtils = new PreferencesUtils();
            }
        }
        return mUtils;
    }

    public void init(Context context) {
        this.mContext = context;
        mSharedPreferences = mContext.getSharedPreferences("app.ini", Context.MODE_PRIVATE);
    }

    public void init(Context context, String fileName) {
        this.mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public int getInt(PreferencesKey dimension) {
        return mSharedPreferences.getInt(dimension.name(), 0);
    }

    public void putInt(PreferencesKey dimension, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(dimension.name(), value);
        editor.commit();
    }

    public String getString(PreferencesKey dimension) {
        return mSharedPreferences.getString(dimension.name(), "");
    }

    public void putString(PreferencesKey dimension, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(dimension.name(), value);
        editor.commit();
    }

    public boolean getBoolean(PreferencesKey dimension) {
        return mSharedPreferences.getBoolean(dimension.name(), false);
    }

    public void putBoolean(PreferencesKey dimension, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(dimension.name(), value);
        editor.commit();
    }

    /**
     * 移除一项
     */
    public boolean remove(String key) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.remove(key);
        return editor.commit();

    }

    /**
     * 清除文件内容
     */
    public boolean clear() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        return editor.commit();

    }

    /**
     * 某一项是否存在
     */
    public boolean contatins(String key) {
        return mSharedPreferences.contains(key);
    }

}
