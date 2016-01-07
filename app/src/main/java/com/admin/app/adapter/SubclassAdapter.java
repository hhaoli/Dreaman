package com.admin.app.adapter;

import android.support.v7.widget.RecyclerView;

import com.admin.app.R;
import com.admin.app.holder.ViewHolderHelper;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/6
 * 描述：
 */
public class SubclassAdapter extends RecyclerViewAdapter {
    public SubclassAdapter(RecyclerView recyclerView, int layoutResID) {
        super(recyclerView, layoutResID);
    }

    @Override
    protected void onBindData(ViewHolderHelper helper, int position, Object o) {
        helper.setText(R.id.item_subclass_name,"空气抱枕");
        helper.setText(R.id.item_subclass_price,"￥86");
        helper.setText(R.id.item_subclass_original_price,"125");
        helper.setText(R.id.item_subclass_number,"210");
    }
}
