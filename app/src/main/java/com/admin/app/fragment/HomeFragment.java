package com.admin.app.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.adapter.HomeAdapter;
import com.admin.app.util.DateUtils;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.CircleImageView;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private TextView mYear;
    private TextView mMonth;
    private TextView mDay;
    private CircleImageView mItem1;
    private CircleImageView mItem2;
    private CircleImageView mItem3;
    private CircleImageView mItem4;
    private RecyclerView mRecyclerView;
    String[] mStrings = {"一 月Jan.", "二 月Feb.", "三 月Mar.", "四 月Apr.", "五 月May.", "六 月Jun.", "七 月Jul.", "八 月Aug.", "九 月Sep.", "十 月Oct.", "十一月Nov.", "十二月Dec."};


    @Override
    protected int layoutResID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mYear = findViewByID(R.id.home_header_year);
        mMonth = findViewByID(R.id.home_header_month);
        mDay = findViewByID(R.id.home_header_day);
        mItem1 = findViewByID(R.id.home_header_item1);
        mItem2 = findViewByID(R.id.home_header_item2);
        mItem3 = findViewByID(R.id.home_header_item3);
        mItem4 = findViewByID(R.id.home_header_item4);
        mRecyclerView = findViewByID(R.id.home_recycler_view);
    }

    @Override
    protected void setListener() {
        mItem1.setOnClickListener(this);
        mItem2.setOnClickListener(this);
        mItem3.setOnClickListener(this);
        mItem4.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        String[] date = DateUtils.getDate(System.currentTimeMillis());
        mYear.setText(date[0]);
        mMonth.setText(date[1]);
        mDay.setText(date[2]);
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        HomeAdapter adapter = new HomeAdapter(getContext(), mStrings);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_header_item1:
                ToastUtils.show("item1");
                break;
            case R.id.home_header_item2:
                ToastUtils.show("item2");
                break;
            case R.id.home_header_item3:
                ToastUtils.show("item3");
                break;
            case R.id.home_header_item4:
                ToastUtils.show("item4");
                break;
        }
    }
}
