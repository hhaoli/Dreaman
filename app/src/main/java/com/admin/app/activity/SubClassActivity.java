package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.adapter.SubclassAdapter;
import com.admin.app.util.ToastUtils;
import com.admin.app.util.UIUtils;
import com.admin.app.view.BelowView;
import com.admin.app.view.TitleBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/6
 * 描述：
 */
public class SubclassActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mCategory;
    private TextView mSalesTv;
    private LinearLayout mPrice;
    private TextView mPriceTv;
    private TextView mDistanceTv;
    private ImageView mCategoryArrow;
    private ImageView mPriceArrow;
    private RecyclerView mRecyclerView;
    private boolean isOrder = false;
    private List<String> strings;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, SubclassActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_subclass;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.category)
                .setRightImage(R.mipmap.icon_search)
                .setTitleOnClickListener(this)
                .setLeftOnClickListener(this)
                .setRightOnClickListener(this);
        mCategory = findViewByID(R.id.subclass_category);
        mSalesTv = findViewByID(R.id.subclass_sales);
        mPrice = findViewByID(R.id.subclass_price);
        mPriceTv = findViewByID(R.id.subclass_price_tv);
        mDistanceTv = findViewByID(R.id.subclass_distance);
        mCategoryArrow = findViewByID(R.id.subclass_category_arrow);
        mPriceArrow = findViewByID(R.id.subclass_price_arrow);
        mRecyclerView = findViewByID(R.id.subclass_recycler_view);
        strings = Arrays.asList(UIUtils.getResources().getStringArray(R.array.category_food));
    }

    @Override
    protected void setListener() {
        mCategory.setOnClickListener(this);
        mSalesTv.setOnClickListener(this);
        mPrice.setOnClickListener(this);
        mDistanceTv.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(manager);
        SubclassAdapter adapter = new SubclassAdapter(mRecyclerView, R.layout.item_subclass);
        adapter.setDatas(strings);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_title:
                break;
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.toolbar_iv_right:
                ToastUtils.show("搜索");
                break;
            case R.id.subclass_category:
                BelowView category = new BelowView(this, R.layout.item_category);
                category.showBelowView(v, true, 0, 0);
                break;
            case R.id.subclass_sales:
                defaultColor();
                mSalesTv.setTextColor(UIUtils.getColor(R.color.blue));
                break;
            case R.id.subclass_price:
                defaultColor();
                mPriceTv.setTextColor(UIUtils.getColor(R.color.blue));
                if (isOrder) {
                    mPriceArrow.setImageResource(R.mipmap.arrow_up_blue);
                    isOrder = true;
                } else {
                    mPriceArrow.setImageResource(R.mipmap.arrow_down_blue);
                    isOrder = false;
                }
                break;
            case R.id.subclass_distance:
                defaultColor();
                mDistanceTv.setTextColor(UIUtils.getColor(R.color.blue));
                break;
        }
    }

    private void defaultColor() {
        mSalesTv.setTextColor(UIUtils.getColor(R.color.gray));
        mPriceTv.setTextColor(UIUtils.getColor(R.color.gray));
        mDistanceTv.setTextColor(UIUtils.getColor(R.color.gray));
        if (isOrder) {
            mPriceArrow.setImageResource(R.mipmap.arrow_up_gray);
        } else {
            mPriceArrow.setImageResource(R.mipmap.arrow_down_gray);
        }
    }
}
