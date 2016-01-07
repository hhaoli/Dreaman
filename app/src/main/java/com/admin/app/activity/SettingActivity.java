package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.view.ItemView;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/6
 * 描述：
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private ItemView mInfo;
    private ItemView mSafety;
    private ItemView mNews;
    private ItemView mCommon;
    private ItemView mAbout;
    private TextView mExit;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, SettingActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.setting).setLeftOnClickListener(this);
        mInfo = findViewByID(R.id.setting_info);
        mSafety = findViewByID(R.id.setting_safety);
        mNews = findViewByID(R.id.setting_news);
        mCommon = findViewByID(R.id.setting_common);
        mAbout = findViewByID(R.id.setting_about);
        mExit = findViewByID(R.id.setting_exit);
    }

    @Override
    protected void setListener() {
        mInfo.setOnClickListener(this);
        mSafety.setOnClickListener(this);
        mNews.setOnClickListener(this);
        mCommon.setOnClickListener(this);
        mAbout.setOnClickListener(this);
        mExit.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.setting_info:
                InfoActivity.launch(this);
                break;
            case R.id.setting_safety:
                AccountSecurityActivity.launch(this);
                break;
            case R.id.setting_news:
                break;
            case R.id.setting_common:
                break;
            case R.id.setting_about:
                break;
            case R.id.setting_exit:
                break;
        }
    }
}
