package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.view.EditTextWithDel;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/5
 * 描述：
 */
public class RegisterStepActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mAvatar;
    private EditTextWithDel mAccount;
    private EditTextWithDel mPassword;
    private EditTextWithDel mConfirm;
    private TextView mRegister;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, RegisterStepActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_register_step;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.register).setLeftOnClickListener(this);
        mAvatar = findViewByID(R.id.register_avatar);
        mAccount = findViewByID(R.id.register_account);
        mPassword = findViewByID(R.id.register_password);
        mConfirm = findViewByID(R.id.register_confirm_password);
        mRegister = findViewByID(R.id.register);
    }

    @Override
    protected void setListener() {
        mRegister.setOnClickListener(this);
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
            case R.id.register_avatar:
                break;
            case R.id.register:
                break;
        }
    }
}
