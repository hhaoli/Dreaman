package com.admin.app.fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.adapter.HomeAdapter;
import com.admin.app.adapter.TogetherAdapter;
import com.admin.app.view.CircleImageView;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class TogetherFragment extends BaseFragment implements AppBarLayout.OnOffsetChangedListener {
    private AppBarLayout mAppBarLayout;
    private LinearLayout mHeader;
    private RelativeLayout mInfo;
    private CircleImageView mAvatar;
    private TextView mUsername;
    private TextView mAssets;
    private TextView mToday;
    private TextView mJoin;
    private TextView mTimes;
    private TextView mObtain;
    private TextView mMoney;
    private TextView mCurrent;
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
        mToday = findViewByID(R.id.together_today);
        mJoin = findViewByID(R.id.together_join);
        mTimes = findViewByID(R.id.together_times);
        mObtain = findViewByID(R.id.together_obtain);
        mMoney = findViewByID(R.id.together_money);
        mCurrent = findViewByID(R.id.together_current);
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
    }

    String[] mStrings = {
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "四 月Apr.", "五 月May.", "六 月Jun.",
            "七 月Jul.", "八 月Aug.", "九 月Sep.",
            "十 月Oct.", "十一月Nov.", "十二月Dec."};

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        if (mStrings.length < 7) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mHeader.getLayoutParams();
            layoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        }
        GridLayoutManager manager = new GridLayoutManager(mActivity, 2);
        mRecyclerView.setLayoutManager(manager);
        TogetherAdapter adapter = new TogetherAdapter(getContext(), mStrings);
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
}
