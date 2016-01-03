package com.admin.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.admin.app.R;
import com.admin.app.holder.BaseRecyclerViewHolder;
import com.admin.app.holder.TogetherHolder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/3
 * 描述：
 */
public class TogetherAdapter extends BaseRecyclerViewAdapter<String> {


    public TogetherAdapter(Context context, String[] strings) {
        super(context, strings);
    }

    @Override
    protected BaseRecyclerViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_together, null);
        return new TogetherHolder(view);
    }
}
