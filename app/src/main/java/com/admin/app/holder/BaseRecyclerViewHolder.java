package com.admin.app.holder;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public abstract class BaseRecyclerViewHolder<Data> extends RecyclerView.ViewHolder {

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }

    public void setData(Data data,int position) {
        onBindData(data,position);
    }

    /**
     * 实例化控件
     */
    protected <V extends View> V findViewByID(@IdRes int id) {
        return (V) itemView.findViewById(id);
    }


    protected abstract void initView(View itemView);

    protected abstract void onBindData(Data data, int position);
}
