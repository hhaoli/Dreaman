package com.admin.app.util;

import android.widget.Toast;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/3
 * 描述：
 */
public class ToastUtils {
    private static Toast toast;

    /**
     * 显示Toast
     */
    public static void show(CharSequence text) {
        if (toast == null) {
            toast = Toast.makeText(UIUtils.getContext(), text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    public static void show(int resId) {
        if (toast == null) {
            toast = Toast.makeText(UIUtils.getContext(), UIUtils.getString(resId), Toast.LENGTH_SHORT);
        } else {
            toast.setText(UIUtils.getString(resId));
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
