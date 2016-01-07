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
import com.admin.app.util.StringUtils;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.EditTextWithDel;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/7
 * 描述：
 */
public class BoundPhone2Activity extends BaseActivity implements View.OnClickListener {
    private TextView mPhone;
    private TextView mDetermine;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, BoundPhone2Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_bound_phone2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.bound_phone).setLeftOnClickListener(this);
        mPhone = findViewByID(R.id.bound_phone);
        mDetermine = findViewByID(R.id.bound_phone_determine);
    }

    @Override
    protected void setListener() {
        mDetermine.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mPhone.setText("成功绑定手机号码" + StringUtils.getPhone("1871234567"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.bound_phone_determine:
                ToastUtils.show("成功");
                break;
        }
    }
}
