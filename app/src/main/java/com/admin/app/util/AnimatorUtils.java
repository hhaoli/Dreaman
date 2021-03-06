package com.admin.app.util;

import android.animation.PropertyValuesHolder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class AnimatorUtils {
    public static final String ROTATION = "rotation";
    public static final String SCALE = "scale";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSLATION = "translation";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";

    private AnimatorUtils() {
        //No instances.
    }

    public static PropertyValuesHolder rotation(float... values) {
        return PropertyValuesHolder.ofFloat(ROTATION, values);
    }

    public static PropertyValuesHolder translation(float... values) {
        return PropertyValuesHolder.ofFloat(TRANSLATION, values);
    }

    public static PropertyValuesHolder translationX(float... values) {
        return PropertyValuesHolder.ofFloat(TRANSLATION_X, values);
    }

    public static PropertyValuesHolder translationY(float... values) {
        return PropertyValuesHolder.ofFloat(TRANSLATION_Y, values);
    }

    public static PropertyValuesHolder scale(float... values) {
        return PropertyValuesHolder.ofFloat(SCALE, values);
    }

    public static PropertyValuesHolder scaleX(float... values) {
        return PropertyValuesHolder.ofFloat(SCALE_X, values);
    }

    public static PropertyValuesHolder scaleY(float... values) {
        return PropertyValuesHolder.ofFloat(SCALE_Y, values);
    }
}
