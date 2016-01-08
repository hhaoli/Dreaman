package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.admin.app.R;
import com.admin.app.adapter.AddressAdapter;
import com.admin.app.util.UIUtils;
import com.admin.app.view.TitleBuilder;

import java.util.Arrays;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/8
 * 描述：
 */
public class AddressListActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private FrameLayout mBtnAdd;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, AddressListActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_address_list;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.shipping_address).setLeftOnClickListener(this);
        mRecyclerView = findViewByID(R.id.address_recycler_view);
        mBtnAdd = findViewByID(R.id.address_add);
    }

    @Override
    protected void setListener() {
        mBtnAdd.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        AddressAdapter adapter = new AddressAdapter(mRecyclerView, R.layout.item_address);
        adapter.setDatas(Arrays.asList(UIUtils.getResources().getStringArray(R.array.category_food)));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.address_add:
                AddressActivity.launch(this,true);
                break;
        }
    }
}
