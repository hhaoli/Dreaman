package com.admin.app.adapter;

import android.support.v7.widget.RecyclerView;

import com.admin.app.R;
import com.admin.app.holder.ViewHolderHelper;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/9
 * 描述：
 */
public class CollectShopAdapter extends RecyclerViewAdapter<String> {
    public CollectShopAdapter(RecyclerView recyclerView, int layoutResID) {
        super(recyclerView, layoutResID);
    }

    @Override
    protected void onBindData(ViewHolderHelper helper, int position, String s) {
        helper.setText(R.id.item_collect_shop_name, s);
        helper.setText(R.id.item_collect_shop_grade, "4.7分");
        helper.setText(R.id.item_collect_shop_sales, "销量123件");
        helper.setText(R.id.item_collect_shop_number, "共125件商品");
        helper.setText(R.id.item_collect_shop_address, "福建省厦门市思明区");
        helper.setOnItemChildCheckedChangeListener(R.id.item_collect_shop_check);
    }
}
