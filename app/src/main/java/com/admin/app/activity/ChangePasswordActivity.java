package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
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
public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {
    private EditTextWithDel mPhone;
    private EditText mCode;
    private TextView mBtnCode;
    private TextView mNext;
    private TimeCount mTimeCount;
    private long firstTime = 0;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, ChangePasswordActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.change_password).setLeftOnClickListener(this);
        mPhone = findViewByID(R.id.change_phone);
        mCode = findViewByID(R.id.change_code);
        mBtnCode = findViewByID(R.id.change_btn_code);
        mNext = findViewByID(R.id.change_next);
    }

    @Override
    protected void setListener() {
        mBtnCode.setOnClickListener(this);
        mNext.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mTimeCount = new TimeCount(60000, 1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.change_btn_code:
                String mobile = mPhone.getText().toString().trim();
                if (TextUtils.isEmpty(mobile)) {
                    ToastUtils.show("请输入手机号");
                    return;
                }
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 120 * 1000) {
                    firstTime = secondTime;
                    mTimeCount.start();
                } else {
                    ToastUtils.show("两次获取验证码时间太短,请稍后再试");
                    return;//防止连续点击
                }
                break;
            case R.id.change_next:
                String code = mCode.getText().toString().trim();
                if (TextUtils.isEmpty(code)) {
                    ToastUtils.show("请输入验证码");
                    return;
                }
                ChangePassword2Activity.launch(this);
                break;
        }
    }

    // 计时重发
    private class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mBtnCode.setClickable(false);
            long time = millisUntilFinished / 1000;
            if (time < 10) {
                mBtnCode.setText("倒计时0" + time + "秒");
            } else {
                mBtnCode.setText("倒计时" + time + "秒");
            }
        }

        @Override
        public void onFinish() {
            mBtnCode.setText(R.string.get_verification_code);
            mBtnCode.setClickable(true);
        }
    }
}
