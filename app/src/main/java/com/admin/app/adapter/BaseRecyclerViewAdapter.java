package com.admin.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.admin.app.holder.BaseRecyclerViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public abstract class BaseRecyclerViewAdapter<Data> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    private List<Data> mDatas;

    public BaseRecyclerViewAdapter(Context context) {
        init(context, new ArrayList<Data>());
    }

    public BaseRecyclerViewAdapter(Context context, Data[] datas) {
        init(context, Arrays.asList(datas));
    }

    public BaseRecyclerViewAdapter(Context context, List<Data> datas) {
        init(context, datas);
    }

    private void init(Context context, List<Data> datas) {
        this.mDatas = datas;
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }


    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateView(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        Data data = getItem(position);
        holder.setData(data, position);
    }

    protected abstract BaseRecyclerViewHolder onCreateView(ViewGroup parent, int viewType);

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
