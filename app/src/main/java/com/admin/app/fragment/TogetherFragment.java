package com.admin.app.fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.admin.app.R;
import com.admin.app.adapter.HomeAdapter;
import com.admin.app.adapter.TogetherAdapter;
import com.admin.app.interfaces.OnItemChildClickListener;
import com.admin.app.interfaces.OnItemClickListener;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.CircleImageView;

import java.util.Arrays;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class TogetherFragment extends BaseFragment implements AppBarLayout.OnOffsetChangedListener, View.OnClickListener, OnItemClickListener, OnItemChildClickListener {
    private AppBarLayout mAppBarLayout;
    private LinearLayout mHeader;
    private RelativeLayout mInfo;
    private CircleImageView mAvatar;
    private TextView mUsername;
    private TextView mAssets;
    private TextView mTimes;
    private TextView mMoney;
    private TextView mNumber;

    private TextView mFriends;
    private TextView mRanking;
    private TextView mQRCode;
    private TextView mShoppingCart;
    private TextView mNews;
    private RecyclerView mRecyclerView;

    @Override
    protected int layoutResID() {
        return R.layout.fragment_together;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mAppBarLayout = findViewByID(R.id.together_app_bar);
        mHeader = findViewByID(R.id.together_header);
        mInfo = findViewByID(R.id.together_info);
        mAvatar = findViewByID(R.id.together_avatar);
        mUsername = findViewByID(R.id.together_username);
        mAssets = findViewByID(R.id.together_assets);
        mTimes = findViewByID(R.id.together_times);
        mMoney = findViewByID(R.id.together_money);
        mNumber = findViewByID(R.id.together_number);
        mFriends = findViewByID(R.id.together_friends);
        mRanking = findViewByID(R.id.together_ranking);
        mQRCode = findViewByID(R.id.together_qr_code);
        mShoppingCart = findViewByID(R.id.together_shopping_cart);
        mNews = findViewByID(R.id.together_news);
        mRecyclerView = findViewByID(R.id.together_recycler_view);
    }

    @Override
    protected void setListener() {
        mInfo.setOnClickListener(this);
        mFriends.setOnClickListener(this);
        mRanking.setOnClickListener(this);
        mQRCode.setOnClickListener(this);
        mShoppingCart.setOnClickListener(this);
        mNews.setOnClickListener(this);
    }

    String[] mStrings = {"一 月Jan.", "二 月Feb.", "三 月Mar.", "四 月Apr.", "五 月May.", "六 月Jun.", "七 月Jul.", "八 月Aug.", "九 月Sep.", "十 月Oct.", "十一月Nov.", "十二月Dec."};

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        mAvatar.setImageResource(R.mipmap.icon_add);
        mUsername.setText("苦情茶来一杯");
        mAssets.setText("538.90");
        mTimes.setText("53次");
        mMoney.setText("639.00");
        mNumber.setText("653人");


        if (mStrings.length < 7) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mHeader.getLayoutParams();
            layoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        }
        GridLayoutManager manager = new GridLayoutManager(mActivity, 2);
        mRecyclerView.setLayoutManager(manager);
        TogetherAdapter adapter = new TogetherAdapter(mRecyclerView, R.layout.item_together);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemChildClickListener(this);
        adapter.setDatas(Arrays.asList(mStrings));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        mAppBarLayout.setMinimumWidth(verticalOffset);
    }

    @Override
    public void onResume() {
        super.onResume();
        mAppBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mAppBarLayout.removeOnOffsetChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.together_info:
                ToastUtils.show("info");
                break;
            case R.id.together_friends:
                ToastUtils.show("friends");
                break;
            case R.id.together_ranking:
                ToastUtils.show("ranking");
                break;
            case R.id.together_qr_code:
                ToastUtils.show("qr_code");
                break;
            case R.id.together_shopping_cart:
                ToastUtils.show("shopping_cart");
                break;
            case R.id.together_news:
                ToastUtils.show("news");
                break;
        }
    }

    @Override
    public void OnItemClick(ViewGroup parent, View itemView, int position) {
        ToastUtils.show("position==" + position);
    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        switch (childView.getId()) {
            case R.id.item_together_btn_reduce:
                ToastUtils.show("降价");
                break;
            case R.id.item_together_btn_level:
                ToastUtils.show("等级");
                break;
        }
    }
}
