package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputType;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.EditTextWithDel;
import com.admin.app.view.Switch;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/4
 * 描述：
 */
public class LoginActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private EditTextWithDel mAccount;
    private EditText mPassword;
    private Switch mSwitch;
    private TextView mLogin;
    private TextView mRegister;
    private TextView mForgot;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.login).setLeftOnClickListener(this);
        mAccount = findViewByID(R.id.login_account);
        mPassword = findViewByID(R.id.login_password);
        mSwitch = findViewByID(R.id.login_switch);
        mLogin = findViewByID(R.id.login);
        mRegister = findViewByID(R.id.login_register);
        mForgot = findViewByID(R.id.login_forgot);
    }

    @Override
    protected void setListener() {
        mSwitch.setOnCheckedChangeListener(this);
        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mForgot.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mForgot.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        mForgot.getPaint().setAntiAlias(true);//抗锯齿
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            mPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

        } else {
            mPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        CharSequence text = mPassword.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, text.length());// 将光标移动到最后
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.login:
                ToastUtils.show(R.string.login);
                break;
            case R.id.login_register:
                ToastUtils.show(R.string.register_an_account);
                break;
            case R.id.login_forgot:
                ToastUtils.show(R.string.forgot_password);
                break;
        }
    }
}
