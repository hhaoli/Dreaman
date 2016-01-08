package com.admin.app.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.admin.app.R;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class TitleBuilder {

    private RelativeLayout toolbar;
    private TextView title;
    private TextView tv_left;
    private TextView tv_right;
    private ImageView iv_left;
    private ImageView iv_right;

    public TitleBuilder(Activity activity) {
        toolbar = (RelativeLayout) activity.findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv_left = (TextView) toolbar.findViewById(R.id.toolbar_tv_left);
        tv_right = (TextView) toolbar.findViewById(R.id.toolbar_tv_right);
        iv_left = (ImageView) toolbar.findViewById(R.id.toolbar_iv_left);
        iv_right = (ImageView) toolbar.findViewById(R.id.toolbar_iv_right);
    }

    public TitleBuilder(View view) {
        toolbar = (RelativeLayout) view.findViewById(R.id.toolbar);
        title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tv_left = (TextView) toolbar.findViewById(R.id.toolbar_tv_left);
        tv_right = (TextView) toolbar.findViewById(R.id.toolbar_tv_right);
        iv_left = (ImageView) toolbar.findViewById(R.id.toolbar_iv_left);
        iv_right = (ImageView) toolbar.findViewById(R.id.toolbar_iv_right);
    }

    public TitleBuilder setTitle(String text) {
        title.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        title.setText(text);
        return this;
    }

    public TitleBuilder setTitle(int resId) {
        title.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        title.setText(resId);
        return this;
    }

    public TitleBuilder setLeftText(String text) {
        tv_left.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        tv_left.setText(text);
        return this;
    }

    public TitleBuilder setLeftText(int resId) {
        tv_left.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        tv_left.setText(resId);
        return this;
    }

    public TitleBuilder setRightText(String text) {
        tv_right.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
        tv_right.setText(text);
        return this;
    }

    public TitleBuilder setRightText(int resId) {
        tv_right.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        tv_right.setText(resId);
        return this;
    }

    public TitleBuilder setLeftImage(int resId) {
        iv_left.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        iv_left.setImageResource(resId);
        return this;
    }

    public TitleBuilder setRightImage(int resId) {
        iv_right.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        iv_right.setImageResource(resId);
        return this;
    }

    public TitleBuilder setTitleOnClickListener(View.OnClickListener listener) {
        if (title.getVisibility() == View.VISIBLE) {
            title.setOnClickListener(listener);
        }
        return this;
    }

    public TitleBuilder setLeftOnClickListener(View.OnClickListener listener) {
        iv_left.setOnClickListener(listener);
        tv_left.setOnClickListener(listener);
        return this;
    }

    public TitleBuilder setRightOnClickListener(View.OnClickListener listener) {
        iv_right.setOnClickListener(listener);
        tv_right.setOnClickListener(listener);
        return this;
    }
}
