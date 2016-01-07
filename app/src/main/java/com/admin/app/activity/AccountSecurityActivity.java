package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.admin.app.R;
import com.admin.app.util.StringUtils;
import com.admin.app.view.ItemView;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/7
 * 描述：
 */
public class AccountSecurityActivity extends BaseActivity implements View.OnClickListener {
    private ItemView mPassword;
    private ItemView mPhone;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, AccountSecurityActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_account_security;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.account_security).setLeftOnClickListener(this);
        mPassword = findViewByID(R.id.account_password);
        mPhone = findViewByID(R.id.account_phone);
    }

    @Override
    protected void setListener() {
        mPassword.setOnClickListener(this);
        mPhone.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mPhone.setRightText(StringUtils.getPhone("18712345678"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.account_password:
                ChangePasswordActivity.launch(this, false);//来源设置
                break;
            case R.id.account_phone:
                BoundPhoneActivity.launch(this);
                break;
        }
    }
}
