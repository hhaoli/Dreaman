package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/8
 * 描述：新建地址、编辑地址
 */
public class AddressActivity extends BaseActivity implements View.OnClickListener {

    public static final String IS_ADD = "add";
    private boolean isAdd;
    private EditText mConsignee;
    private EditText mPhone;
    private LinearLayout mBtnArea;
    private EditText mAddress;
    private TextView mBtnSave;
    private TitleBuilder mTitleBuilder;

    public static void launch(Activity activity, boolean isAdd) {
        Intent intent = new Intent(activity, AddressActivity.class);
        intent.putExtra(IS_ADD, isAdd);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_address;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        isAdd = getIntent().getBooleanExtra(IS_ADD, false);
        mTitleBuilder = new TitleBuilder(this);
        if (isAdd) {
            mTitleBuilder.setTitle(R.string.new_address);
        } else {
            mTitleBuilder.setTitle(R.string.shipping_address);
            mTitleBuilder.setRightText(R.string.edit);
            mTitleBuilder.setRightOnClickListener(this);
        }
        mTitleBuilder.setLeftOnClickListener(this);

        mConsignee = findViewByID(R.id.address_consignee);
        mPhone = findViewByID(R.id.address_phone);
        mBtnArea = findViewByID(R.id.address_area);
        mAddress = findViewByID(R.id.address_detail);
        mBtnSave = findViewByID(R.id.address_save);

    }

    @Override
    protected void setListener() {
        mBtnArea.setOnClickListener(this);
        mBtnSave.setOnClickListener(this);
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
            case R.id.toolbar_tv_right:
                break;
            case R.id.address_area:
                break;
            case R.id.address_save:
                break;
        }
    }
}
