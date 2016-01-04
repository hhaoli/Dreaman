package com.admin.app.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.admin.app.interfaces.OnItemClickListener;
import com.admin.app.interfaces.OnItemLongClickListener;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/4
 * 描述：
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    protected Context mContext;
    protected OnItemClickListener mOnItemClickListener;
    protected OnItemLongClickListener mOnItemLongClickListener;
    protected ViewHolderHelper mViewHolderHelper;
    protected RecyclerView mRecyclerView;

    public RecyclerViewHolder(RecyclerView recyclerView, View itemView, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
        super(itemView);
        this.mRecyclerView = recyclerView;
        this.mContext = mRecyclerView.getContext();
        this.mOnItemClickListener = onItemClickListener;
        this.mOnItemLongClickListener = onItemLongClickListener;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        mViewHolderHelper = new ViewHolderHelper(mRecyclerView, this.itemView);
        mViewHolderHelper.setRecyclerViewHolder(this);
    }

    public ViewHolderHelper getViewHolderHelper() {
        return mViewHolderHelper;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == this.itemView.getId() && null != mOnItemClickListener) {
            mOnItemClickListener.OnItemClick(mRecyclerView, v, getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == this.itemView.getId() && null != mOnItemLongClickListener) {
            return mOnItemLongClickListener.onItemLongClick(mRecyclerView, v, getAdapterPosition());
        }
        return false;
    }
}
