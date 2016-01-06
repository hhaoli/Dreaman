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
public class CategoryAdapter extends RecyclerViewAdapter<String> {

    public CategoryAdapter(RecyclerView recyclerView, int layoutResID) {
        super(recyclerView, layoutResID);
    }

    @Override
    protected void onBindData(ViewHolderHelper helper, int position, String s) {
        helper.setText(R.id.category_name, s);
        helper.setImageResource(R.id.category_icon, R.mipmap.ic_launcher);
    }
}
