package com.admin.app.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.admin.app.R;
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
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_header_item1:
                Toast.makeText(mActivity, "item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_header_item2:
                Toast.makeText(mActivity, "item2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_header_item3:
                Toast.makeText(mActivity, "item3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_header_item4:
                Toast.makeText(mActivity, "item4", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
