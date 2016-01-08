package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.view.EditTextWithDel;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/8
 * 描述：
 */
public class NicknameActivity extends BaseActivity implements View.OnClickListener {
    private EditTextWithDel mNickname;
    private TextView mBtnSvae;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, NicknameActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_nickname;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.nickname).setLeftOnClickListener(this);
        mNickname = findViewByID(R.id.nickname);
        mBtnSvae = findViewByID(R.id.nickname_save);
    }

    @Override
    protected void setListener() {
        mBtnSvae.setOnClickListener(this);
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
            case R.id.nickname_save:
                break;
        }
    }
}
