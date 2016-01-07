package com.admin.app.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.admin.app.R;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/7
 * 描述：控件下面弹出框
 */
public class BelowView {
    private View convertView;
    private Context mContext;
    private PopupWindow mPopupWindow;
    private int animationStyle;
    private int background = -1;

    public BelowView(Context context, View convertView) {
        this.mContext = context;
        this.convertView = convertView;
    }

    public BelowView(Context context, int resource) {
        this.mContext = context;
        this.convertView = View.inflate(context, resource, null);
    }

    public void showBelowView(View view, boolean CanceledOnTouchOutside, int xoff, int yoff) {
        mPopupWindow = new PopupWindow(convertView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        mPopupWindow.setOutsideTouchable(CanceledOnTouchOutside);
        if (animationStyle == 0) {
        } else {
            mPopupWindow.setAnimationStyle(animationStyle);
        }
        if (-1 == background) {
            mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            mPopupWindow.setBackgroundDrawable(mContext.getDrawable(background));
        }
        mPopupWindow.showAsDropDown(view, xoff, yoff);
    }

    public void setBackgroundRes(int background) {
        this.background = background;
    }

    public void setAnimation(int animationStyle) {
        this.animationStyle = animationStyle;
    }

    public View getBelowView() {
        return convertView;
    }

    public void dismissBelowView() {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }
    }
}
