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
 * 时间：2016/1/7
 * 描述：
 */
public class BoundPhoneActivity extends BaseActivity implements View.OnClickListener {
    private TextView mPhone;
    private EditTextWithDel mNumber;
    private EditText mCode;
    private TextView mBtnCode;
    private TextView mNext;
    private TimeCount mTimeCount;
    private long firstTime = 0;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, BoundPhoneActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_bound_phone;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.bound_phone).setLeftOnClickListener(this);
        mPhone = findViewByID(R.id.bound_phone);
        mNumber = findViewByID(R.id.bound_phone_number);
        mCode = findViewByID(R.id.bound_phone_code);
        mBtnCode = findViewByID(R.id.bound_phone_btn_code);
        mNext = findViewByID(R.id.bound_phone_next);
    }

    @Override
    protected void setListener() {
        mBtnCode.setOnClickListener(this);
        mNext.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mTimeCount = new TimeCount(60000, 1000);
        mPhone.setText("当前绑定手机号码为" + "1871234567" + "\n请输入新的手机号码");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.bound_phone_btn_code:
                String number=mNumber.getText().toString().trim();
                if (TextUtils.isEmpty(number)){
                    ToastUtils.show("请输入手机号码");
                    return;
                }
                if (number.length()!=11){
                    ToastUtils.show("手机号码有错");
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
            case R.id.bound_phone_next:
                BoundPhone2Activity.launch(this);
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
                mBtnCode.setText("倒计时"+time + "秒");
            }
        }

        @Override
        public void onFinish() {
            mBtnCode.setText(R.string.get_verification_code);
            mBtnCode.setClickable(true);
        }
    }
}
