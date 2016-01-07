package com.admin.app.util;

import android.text.TextUtils;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/7
 * 描述：
 */
public class StringUtils {

    public static String getPhone(String phone) {
        if (TextUtils.isEmpty(phone) || phone.length() != 11) return "";
        StringBuffer bf = new StringBuffer("");
        bf.append(phone.substring(0, 3));
        bf.append("****");
        bf.append(phone.substring(6, 10));
        return bf.toString();
    }
}
