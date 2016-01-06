package com.admin.app.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.activity.ChangePasswordActivity;
import com.admin.app.activity.LoginActivity;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.CircleImageView;
import com.admin.app.view.ItemView;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class SelfFragment extends BaseFragment implements View.OnClickListener {

    //登录状态
    private CircleImageView mIcon;
    private TextView mName;
    private LinearLayout mBtnProduct;
    private TextView mProduct;
    private LinearLayout mBtnShop;
    private TextView mShop;
    private LinearLayout mBtnHistory;
    private TextView mHistory;
    //未登录状态
    private CircleImageView mIcon2;
    private LinearLayout mBtnProduct2;
    private LinearLayout mBtnShop2;
    private LinearLayout mBtnHistory2;


    private TextView mPayment;
    private TextView mUsed;
    private TextView mEvaluated;
    private TextView mReturn;
    private ItemView mOrder;
    private ItemView mCoins;
    private ItemView mTicket;
    private ItemView mFriend;
    private ItemView mFeedback;
    private ItemView mSetting;
    private ItemView mBusiness;

    @Override
    protected int layoutResID() {
        return R.layout.fragment_self;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mIcon = findViewByID(R.id.self_header1_icon);
        mName = findViewByID(R.id.self_header1_name);
        mBtnProduct = findViewByID(R.id.self_header1_btn_product);
        mProduct = findViewByID(R.id.self_header1_tv_product);
        mBtnShop = findViewByID(R.id.self_header1_btn_shop);
        mShop = findViewByID(R.id.self_header1_tv_shop);
        mBtnHistory = findViewByID(R.id.self_header1_btn_history);
        mHistory = findViewByID(R.id.self_header1_tv_history);

        mIcon2 = findViewByID(R.id.self_header2_icon);
        mBtnProduct2 = findViewByID(R.id.self_header2_btn_product);
        mBtnShop2 = findViewByID(R.id.self_header2_btn_shop);
        mBtnHistory2 = findViewByID(R.id.self_header2_btn_history);


        mOrder = findViewByID(R.id.self_order);
        mCoins = findViewByID(R.id.self_coins);
        mTicket = findViewByID(R.id.self_ticket);
        mFriend = findViewByID(R.id.self_friend);
        mFeedback = findViewByID(R.id.self_feedback);
        mSetting = findViewByID(R.id.self_setting);
        mBusiness = findViewByID(R.id.self_business);
        mPayment = findViewByID(R.id.self_payment);
        mUsed = findViewByID(R.id.self_used);
        mEvaluated = findViewByID(R.id.self_evaluated);
        mReturn = findViewByID(R.id.self_return);
    }

    @Override
    protected void setListener() {
        mIcon.setOnClickListener(this);
        mBtnProduct.setOnClickListener(this);
        mBtnShop.setOnClickListener(this);
        mBtnHistory.setOnClickListener(this);

        mIcon2.setOnClickListener(this);
        mBtnProduct2.setOnClickListener(this);
        mBtnShop2.setOnClickListener(this);
        mBtnHistory2.setOnClickListener(this);

        mOrder.setOnClickListener(this);
        mCoins.setOnClickListener(this);
        mTicket.setOnClickListener(this);
        mFriend.setOnClickListener(this);
        mFeedback.setOnClickListener(this);
        mSetting.setOnClickListener(this);
        mBusiness.setOnClickListener(this);
        mPayment.setOnClickListener(this);
        mUsed.setOnClickListener(this);
        mEvaluated.setOnClickListener(this);
        mReturn.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.self_header1_btn_product:
                break;
            case R.id.self_header1_btn_shop:
                break;
            case R.id.self_header1_btn_history:
                break;
            case R.id.self_header2_icon:
                break;
            case R.id.self_header2_btn_product:
                break;
            case R.id.self_header2_btn_shop:
                break;
            case R.id.self_header2_btn_history:
                break;
            case R.id.self_payment:
                ToastUtils.show(R.string.pending_payment);
                break;
            case R.id.self_used:
                ToastUtils.show(R.string.to_be_used);
                break;
            case R.id.self_evaluated:
                ToastUtils.show(R.string.to_be_evaluated);
                break;
            case R.id.self_return:
                ToastUtils.show(R.string.return_of_goods);
                break;
            case R.id.self_order:
                LoginActivity.launch(mActivity);
                ToastUtils.show("0");
                break;
            case R.id.self_coins:
                ToastUtils.show("1");
                ChangePasswordActivity.launch(mActivity);
                break;
            case R.id.self_ticket:
                ToastUtils.show("2");
                break;
            case R.id.self_friend:
                ToastUtils.show("3");
                break;
            case R.id.self_feedback:
                ToastUtils.show("4");
                break;
            case R.id.self_setting:
                ToastUtils.show("5");
                break;
            case R.id.self_business:
                ToastUtils.show("6");
                break;
        }
    }
}
