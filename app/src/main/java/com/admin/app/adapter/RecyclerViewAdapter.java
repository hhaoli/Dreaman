package com.admin.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.admin.app.holder.RecyclerViewHolder;
import com.admin.app.holder.ViewHolderHelper;
import com.admin.app.interfaces.OnItemChildCheckedChangeListener;
import com.admin.app.interfaces.OnItemChildClickListener;
import com.admin.app.interfaces.OnItemChildLongClickListener;
import com.admin.app.interfaces.OnItemClickListener;
import com.admin.app.interfaces.OnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;


public abstract class RecyclerViewAdapter<Data> extends RecyclerView.Adapter<RecyclerViewHolder> {

    protected final int mLayoutResID;
    protected Context mContext;
    protected List<Data> mDatas;
    protected OnItemChildClickListener mOnItemChildClickListener;
    protected OnItemChildLongClickListener mOnItemChildLongClickListener;
    protected OnItemChildCheckedChangeListener mOnItemChildCheckedChangeListener;
    protected OnItemClickListener mOnItemClickListener;
    protected OnItemLongClickListener mOnItemLongClickListener;
    protected RecyclerView mRecyclerView;

    public RecyclerViewAdapter(RecyclerView recyclerView, int layoutResID) {
        this.mRecyclerView = recyclerView;
        this.mContext = mRecyclerView.getContext();
        this.mLayoutResID = layoutResID;
        mDatas = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder holder = new RecyclerViewHolder(mRecyclerView, LayoutInflater.from(mContext).inflate(mLayoutResID, parent, false), mOnItemClickListener, mOnItemLongClickListener);
        holder.getViewHolderHelper().setOnItemChildClickListener(mOnItemChildClickListener);
        holder.getViewHolderHelper().setOnItemChildLongClickListener(mOnItemChildLongClickListener);
        holder.getViewHolderHelper().setOnItemChildCheckedChangeListener(mOnItemChildCheckedChangeListener);
        setOnItemChildListener(holder.getViewHolderHelper());
        return holder;
    }

    //为item的孩子节点设置监听器，并不是每一个数据列表都要为item的子控件添加事件监听器，所以这里采用了空实现，需要设置事件监听器时重写该方法即可
    protected void setOnItemChildListener(ViewHolderHelper helper) {

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        onBindData(holder.getViewHolderHelper(), position, getItem(position));
    }

    protected abstract void onBindData(ViewHolderHelper helper, int position, Data data);

    //设置item的点击事件监听器
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    // 设置item的长按事件监听器
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    //设置item中的子控件点击事件监听器
    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    //设置item中的子控件长按事件监听器
    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    //设置item子控件选中状态变化事件监听器
    public void setOnItemChildCheckedChangeListener(OnItemChildCheckedChangeListener onItemChildCheckedChangeListener) {
        mOnItemChildCheckedChangeListener = onItemChildCheckedChangeListener;
    }

    public Data getItem(int position) {
        return mDatas.get(position);
    }

    //获取数据集合
    public List<Data> getDatas() {
        return mDatas;
    }

    // 在集合头部添加新的数据集合（下拉从服务器获取最新的数据集合，例如新浪微博加载最新的几条微博数据）
    public void addNewDatas(List<Data> datas) {
        if (datas != null) {
            mDatas.addAll(0, datas);
            notifyItemRangeInserted(0, datas.size());
        }
    }

    // 在集合尾部添加更多数据集合（上拉从服务器获取更多的数据集合，例如新浪微博列表上拉加载更晚时间发布的微博数据）
    public void addMoreDatas(List<Data> datas) {
        if (datas != null) {
            mDatas.addAll(mDatas.size(), datas);
            notifyItemRangeInserted(mDatas.size(), datas.size());
        }
    }

    //设置全新的数据集合，如果传入null，则清空数据列表（第一次从服务器加载数据，或者下拉刷新当前界面数据表）
    public void setDatas(List<Data> datas) {
        if (datas != null) {
            mDatas = datas;
        } else {
            mDatas.clear();
        }
        notifyDataSetChanged();
    }

    //清空数据列表
    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    // 删除指定索引数据条目
    public void removeItem(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    // 删除指定数据条目
    public void removeItem(Data data) {
        removeItem(mDatas.indexOf(data));
    }

    // 在指定位置添加数据条目
    public void addItem(int position, Data data) {
        mDatas.add(position, data);
        notifyItemInserted(position);
    }

    // 在集合头部添加数据条目
    public void addFirstItem(Data data) {
        addItem(0, data);
    }

    //在集合末尾添加数据条目
    public void addLastItem(Data data) {
        addItem(mDatas.size(), data);
    }

    //替换指定索引的数据条目
    public void setItem(int location, Data newData) {
        mDatas.set(location, newData);
        notifyItemChanged(location);
    }

    //替换指定数据条目
    public void setItem(Data oldData, Data newData) {
        setItem(mDatas.indexOf(oldData), newData);
    }

    //移动数据条目的位置
    public void moveItem(int fromPosition, int toPosition) {
        mDatas.add(toPosition, mDatas.remove(fromPosition));
        notifyItemMoved(fromPosition, toPosition);
    }
}
