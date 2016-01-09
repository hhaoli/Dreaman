package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.adapter.CollectGoodsAdapter;
import com.admin.app.adapter.CollectShopAdapter;
import com.admin.app.interfaces.OnItemChildCheckedChangeListener;
import com.admin.app.util.UIUtils;
import com.admin.app.view.DividerItemDecoration;
import com.admin.app.view.TitleBuilder;

import java.util.Arrays;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/8
 * 描述：
 */
public class CollectActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, OnItemChildCheckedChangeListener {
    private RecyclerView mRecyclerView;
    private RelativeLayout mViewDelete;
    private CheckBox mCheckBox;
    private TextView mBtnDelete;
    private TitleBuilder mTitleBuilder;
    public static final String PRODUCT = "product";
    public static final String SHOP = "shop";
    public static final String HISTORY = "history";
    private static final String TYPE = "type";
    private String mType;

    public static void launch(Activity activity, String type) {
        Intent intent = new Intent(activity, CollectActivity.class);
        intent.putExtra(TYPE, type);
        activity.startActivity(intent);
    }


    @Override
    protected int layoutResID() {
        return R.layout.activity_collect;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mType = getIntent().getStringExtra(TYPE);
        mTitleBuilder = new TitleBuilder(this);

        mRecyclerView = findViewByID(R.id.collect_recycler_view);
        mViewDelete = findViewByID(R.id.shopping_cart_delete_view);
        mCheckBox = findViewByID(R.id.shopping_cart_delete_check);
        mBtnDelete = findViewByID(R.id.shopping_cart_delete);
    }

    @Override
    protected void setListener() {
        mTitleBuilder.setLeftOnClickListener(this);
        mTitleBuilder.setRightOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mCheckBox.setOnCheckedChangeListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        if (SHOP.equals(mType)) {
            mTitleBuilder.setTitle(R.string.shop_favorites);
            CollectShopAdapter shopAdapter = new CollectShopAdapter(mRecyclerView, R.layout.item_collect_shop);
            shopAdapter.setDatas(Arrays.asList(UIUtils.getResources().getStringArray(R.array.category_food)));
            shopAdapter.setOnItemChildCheckedChangeListener(this);
            mRecyclerView.setAdapter(shopAdapter);
        } else if (HISTORY.equals(mType)) {
            mTitleBuilder.setTitle(R.string.history);
            CollectGoodsAdapter adapter = new CollectGoodsAdapter(mRecyclerView, R.layout.item_collect_goods, mType);
            adapter.setDatas(Arrays.asList(UIUtils.getResources().getStringArray(R.array.category_food)));
            adapter.setOnItemChildCheckedChangeListener(this);
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        } else if (PRODUCT.equals(mType)) {
            mTitleBuilder.setTitle(R.string.product_collection);
            CollectGoodsAdapter adapter = new CollectGoodsAdapter(mRecyclerView, R.layout.item_collect_goods, mType);
            adapter.setDatas(Arrays.asList(UIUtils.getResources().getStringArray(R.array.category_food)));
            adapter.setOnItemChildCheckedChangeListener(this);
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.toolbar_tv_right:
                mTitleBuilder.setRightText("");
                mViewDelete.setVisibility(View.GONE);
                break;
            case R.id.shopping_cart_delete:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onItemChildCheckedChanged(ViewGroup parent, CompoundButton childView, int position, boolean isChecked) {
        if (isChecked) {
            mTitleBuilder.setRightText(R.string.cancel);
            mViewDelete.setVisibility(View.VISIBLE);
        } else {
//            mTitleBuilder.setRightText("");
//            mViewDelete.setVisibility(View.GONE);
        }
    }
}
