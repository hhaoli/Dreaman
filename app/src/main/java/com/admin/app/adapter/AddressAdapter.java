package com.admin.app.adapter;

import android.support.v7.widget.RecyclerView;

import com.admin.app.R;
import com.admin.app.holder.ViewHolderHelper;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/8
 * 描述：
 */
public class AddressAdapter extends RecyclerViewAdapter<String> {
    public AddressAdapter(RecyclerView recyclerView, int layoutResID) {
        super(recyclerView, layoutResID);
    }

    @Override
    protected void onBindData(ViewHolderHelper helper, int position, String s) {
        helper.setText(R.id.item_address_username, s);
        helper.setText(R.id.item_address_phone, "18712345678");
        helper.setText(R.id.item_address, "福建省厦门市集美区集美大道冰冰小区83号");
    }
}
