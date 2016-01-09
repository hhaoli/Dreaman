package com.admin.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.admin.app.R;
import com.admin.app.activity.CollectActivity;
import com.admin.app.holder.ViewHolderHelper;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/9
 * 描述：
 */
public class CollectGoodsAdapter extends RecyclerViewAdapter<String> {
    private String mType;

    public CollectGoodsAdapter(RecyclerView recyclerView, int layoutResID, String type) {
        super(recyclerView, layoutResID);
        this.mType = type;
    }

    @Override
    protected void onBindData(ViewHolderHelper helper, int position, String s) {
        helper.setText(R.id.item_collect_goods_name, s);
        helper.setText(R.id.item_collect_goods_price, "￥98.00");
        helper.setText(R.id.item_collect_goods_old_price, "￥125.00");
        helper.setText(R.id.item_collect_goods_reduce, "￥27.00");
        helper.setText(R.id.item_collect_goods_member, "228");
        if (CollectActivity.PRODUCT.equals(mType)) {
            helper.setVisibility(R.id.item_collect_goods_check, View.VISIBLE);
            helper.setOnItemChildCheckedChangeListener(R.id.item_collect_goods_check);
        } else if (CollectActivity.HISTORY.equals(mType)) {
            helper.setVisibility(R.id.item_collect_goods_check, View.GONE);
        }
    }
}
