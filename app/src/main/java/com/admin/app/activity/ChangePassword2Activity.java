package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.EditTextWithDel;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/5
 * 描述：
 */
public class ChangePassword2Activity extends BaseActivity implements View.OnClickListener {
    private EditTextWithDel mPassword;
    private EditTextWithDel mConfirmPassword;
    private TextView mNext;


    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, ChangePassword2Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_change_password2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.change_password).setLeftOnClickListener(this);
        mPassword = findViewByID(R.id.change_password);
        mConfirmPassword = findViewByID(R.id.change_confirm_password);
        mNext = findViewByID(R.id.change_next);
    }

    @Override
    protected void setListener() {
        mNext.setOnClickListener(this);
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
            case R.id.change_next:
                String password = mPassword.getText().toString().trim();
                if (TextUtils.isEmpty(password)) {
                    ToastUtils.show("请输入密码");
                    return;
                }
                String confirmPassword = mConfirmPassword.getText().toString().trim();
                if (TextUtils.isEmpty(confirmPassword)) {
                    ToastUtils.show("请输入密码");
                    return;
                }
                ChangePassword3Activity.launch(this);
                break;
        }
    }
}
