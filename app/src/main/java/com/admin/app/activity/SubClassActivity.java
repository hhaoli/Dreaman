package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/6
 * 描述：
 */
public class SubclassActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mCategory;
    private LinearLayout mSales;
    private LinearLayout mPrice;
    private LinearLayout mDistance;
    private ImageView mCategoryArrow;
    private ImageView mSalesArrow;
    private ImageView mPriceArrow;
    private ImageView mDistanceArrow;
    private RecyclerView mRecyclerView;

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
                .setLeftOnClickListener(this)
                .setRightOnClickListener(this);
        mCategory = findViewByID(R.id.subclass_category);
        mSales = findViewByID(R.id.subclass_sales);
        mPrice = findViewByID(R.id.subclass_price);
        mDistance = findViewByID(R.id.subclass_distance);
        mCategoryArrow = findViewByID(R.id.subclass_category_arrow);
        mSalesArrow = findViewByID(R.id.subclass_sales_arrow);
        mPriceArrow = findViewByID(R.id.subclass_price_arrow);
        mDistanceArrow = findViewByID(R.id.subclass_distance_arrow);
        mRecyclerView = findViewByID(R.id.subclass_recycler_view);
    }

    @Override
    protected void setListener() {
        mCategory.setOnClickListener(this);
        mSales.setOnClickListener(this);
        mPrice.setOnClickListener(this);
        mDistance.setOnClickListener(this);
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
            case R.id.toolbar_iv_right:
                ToastUtils.show("搜索");
                break;
            case R.id.subclass_category:
                defaultArrow();
                mCategoryArrow.setImageResource(R.mipmap.arrow_down_blue);
                break;
            case R.id.subclass_sales:
                defaultArrow();
                mSalesArrow.setImageResource(R.mipmap.arrow_up_and_down_blue);
                break;
            case R.id.subclass_price:
                defaultArrow();
                mPriceArrow.setImageResource(R.mipmap.arrow_up_and_down_blue);
                break;
            case R.id.subclass_distance:
                defaultArrow();
                mDistanceArrow.setImageResource(R.mipmap.arrow_up_and_down_blue);
                break;
        }
    }

    private void defaultArrow() {
        mCategoryArrow.setImageResource(R.mipmap.arrow_down_gray);
        mSalesArrow.setImageResource(R.mipmap.arrow_up_and_down_gray);
        mPriceArrow.setImageResource(R.mipmap.arrow_up_and_down_gray);
        mDistanceArrow.setImageResource(R.mipmap.arrow_up_and_down_gray);
    }
}
