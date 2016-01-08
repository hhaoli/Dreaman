package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/8
 * 描述：
 */
public class ShoppingCartActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private RecyclerView mRecyclerView;
    private LinearLayout mViewSettlement;
    private CheckBox mCheckSettlement;
    private TextView mPriceSettlement;
    private TextView mBtnSettlement;
    private RelativeLayout mViewDelete;
    private CheckBox mCheckDelete;
    private TextView mBtnDelete;
    private TitleBuilder mTitleBuilder;
    private boolean isEdit = false;//是否编辑,默认false


    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, ShoppingCartActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTitleBuilder = new TitleBuilder(this);
        mRecyclerView = findViewByID(R.id.shopping_cart_recycler_view);
        mViewSettlement = findViewByID(R.id.shopping_cart_settlement_view);
        mCheckSettlement = findViewByID(R.id.shopping_cart_settlement_check);
        mPriceSettlement = findViewByID(R.id.shopping_cart_settlement_price);
        mBtnSettlement = findViewByID(R.id.shopping_cart_settlement);
        mViewDelete = findViewByID(R.id.shopping_cart_delete_view);
        mCheckDelete = findViewByID(R.id.shopping_cart_delete_check);
        mBtnDelete = findViewByID(R.id.shopping_cart_delete);
    }

    @Override
    protected void setListener() {
        mTitleBuilder.setLeftOnClickListener(this);
        mTitleBuilder.setRightOnClickListener(this);
        mBtnSettlement.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mCheckSettlement.setOnCheckedChangeListener(this);
        mCheckDelete.setOnCheckedChangeListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mTitleBuilder.setTitle(R.string.shopping_cart);
        mTitleBuilder.setRightText(R.string.edit);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.toolbar_tv_right:
                if (isEdit) {
                    mViewSettlement.setVisibility(View.GONE);
                    mViewDelete.setVisibility(View.VISIBLE);
                    mTitleBuilder.setRightText(R.string.complete);
                } else {
                    mViewSettlement.setVisibility(View.VISIBLE);
                    mViewDelete.setVisibility(View.GONE);
                    mTitleBuilder.setRightText(R.string.edit);
                }
                isEdit = !isEdit;
                break;
            case R.id.shopping_cart_settlement:
                break;
            case R.id.shopping_cart_delete:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.shopping_cart_settlement_check:
                break;
            case R.id.shopping_cart_delete_check:
                break;
        }
    }
}
