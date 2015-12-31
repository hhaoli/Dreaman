package com.admin.app.activity;

import android.content.DialogInterface;
import android.os.Bundle;

import com.admin.app.R;
import com.admin.app.constant.PreferencesKey;
import com.admin.app.util.NetUtils;
import com.admin.app.util.PreferencesUtils;
import com.admin.app.util.UIUtils;
import com.afollestad.materialdialogs.AlertDialogWrapper;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class SplashActivity extends BaseActivity {

    private PreferencesUtils utils;

    @Override
    protected int layoutResID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        if (!NetUtils.isConnected(this)) {//没有网络
            openNetSetting();
        } else {
            utils = PreferencesUtils.instance();
            boolean isFirst = utils.getBoolean(PreferencesKey.IS_FIRST);
            if (isFirst) {
                toGuide();
            } else {
                if (!checkVersion()) {//没有新版本
                    delayToMain();
                } else {//处理更新

                }
            }
        }
    }

    private void toGuide() {

    }

    private void delayToMain() {
        UIUtils.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.launch(SplashActivity.this);
                finish();
            }
        }, 2000);
    }

    private boolean checkVersion() {
        return false;
    }

    private void openNetSetting() {
        new AlertDialogWrapper.Builder(this).setTitle("提示").setMessage("是否开启网络?").setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NetUtils.openNetSetting(SplashActivity.this);
                dialog.dismiss();
                finish();
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.launch(SplashActivity.this);
                dialog.dismiss();
                finish();
            }
        }).create().show();
    }
}
