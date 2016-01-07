package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.view.CircleImageView;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/7
 * 描述：
 */
public class InfoActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RelativeLayout mBtnAvatar;
    private CircleImageView mAvatar;
    private RelativeLayout mBtnUsername;
    private TextView mUsername;
    private RadioGroup mRadioGroup;
    private RelativeLayout mBtnAddress;
    private TextView mSave;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, InfoActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.personal_information).setLeftOnClickListener(this);
        mBtnAvatar = findViewByID(R.id.info_btn_avatar);
        mAvatar = findViewByID(R.id.info_avatar);
        mBtnUsername = findViewByID(R.id.info_btn_username);
        mUsername = findViewByID(R.id.info_username);
        mRadioGroup = findViewByID(R.id.info_sex);
        mBtnAddress = findViewByID(R.id.info_btn_address);
        mSave = findViewByID(R.id.info_save);

    }

    @Override
    protected void setListener() {
        mBtnAvatar.setOnClickListener(this);
        mBtnUsername.setOnClickListener(this);
        mBtnAddress.setOnClickListener(this);
        mSave.setOnClickListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
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
            case R.id.info_btn_avatar:
                showAvatar();
                break;
            case R.id.info_btn_username:
                break;
            case R.id.info_btn_address:
                break;
            case R.id.info_save:
                break;
        }
    }

    private void showAvatar() {
        View view = View.inflate(this, R.layout.popup_area, null);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.info_male:
                break;
            case R.id.info_female:
                break;
        }
    }
}
