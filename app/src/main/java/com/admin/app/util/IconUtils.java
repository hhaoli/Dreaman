package com.admin.app.util;

import com.admin.app.R;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/3
 * 描述：
 */
public class IconUtils {
    /**
     * 首页条目图片
     */
    public static int getHomeIcon(int position) {
        int index = position % 6;
        switch (index) {
            case 0:
                return R.mipmap.icon_home_item1;
            case 1:
                return R.mipmap.icon_home_item2;
            case 2:
                return R.mipmap.icon_home_item3;
            case 3:
                return R.mipmap.icon_home_item4;
            case 4:
                return R.mipmap.icon_home_item5;
            case 5:
                return R.mipmap.icon_home_item6;
            default:
                return 0;
        }
    }

    public static int getHomeColor(int position) {
        int index = position % 6;
        switch (index) {
            case 0:
                return R.color.blue;
            case 1:
                return R.color.orange;
            case 2:
                return R.color.green;
            case 3:
                return R.color.red;
            case 4:
                return R.color.gray;
            case 5:
                return R.color.yellow;
            default:
                return 0;
        }
    }

    public static int getReduce(int position) {
        int index = position % 6;
        switch (index) {
            case 0:
                return R.mipmap.icon_reduce_item1;
            case 1:
                return R.mipmap.icon_reduce_item2;
            case 2:
                return R.mipmap.icon_reduce_item3;
            case 3:
                return R.mipmap.icon_reduce_item4;
            case 4:
                return R.mipmap.icon_reduce_item5;
            case 5:
                return R.mipmap.icon_reduce_item6;
            default:
                return 0;
        }
    }

    public static int getLevel(int position) {
        int index = position % 4;
        switch (index) {
            case 0:
                return R.mipmap.icon_level_item1;
            case 1:
                return R.mipmap.icon_level_item2;
            case 2:
                return R.mipmap.icon_level_item3;
            case 3:
                return R.mipmap.icon_level_item4;
            default:
                return 0;
        }

    }

}
