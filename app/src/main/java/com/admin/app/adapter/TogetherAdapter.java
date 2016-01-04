package com.admin.app.adapter;

import android.support.v7.widget.RecyclerView;

import com.admin.app.R;
import com.admin.app.holder.ViewHolderHelper;
import com.admin.app.util.IconUtils;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/3
 * 描述：
 */
public class TogetherAdapter extends RecyclerViewAdapter<String> {


    public TogetherAdapter(RecyclerView recyclerView, int layoutResID) {
        super(recyclerView, layoutResID);
    }

    @Override
    protected void onBindData(ViewHolderHelper helper, int position, String s) {
        helper.setImageResource(R.id.item_together_icon, R.mipmap.ic_launcher);
        helper.setText(R.id.item_together_name, s);
        helper.setText(R.id.item_together_beans, "123");
        helper.setImageResource(R.id.item_together_icon_money, IconUtils.getReduce(position));
        helper.setText(R.id.item_together_money, "128");
        helper.setImageResource(R.id.item_together_icon_number, IconUtils.getLevel(position));
        helper.setText(R.id.item_together_number, "89");
        helper.setOnItemChildClickListener(R.id.item_together_btn_reduce);
        helper.setOnItemChildClickListener(R.id.item_together_btn_level);

    }
}
