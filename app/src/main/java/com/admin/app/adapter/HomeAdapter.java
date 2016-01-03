package com.admin.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.admin.app.R;
import com.admin.app.holder.BaseRecyclerViewHolder;
import com.admin.app.holder.HomeHolder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/3
 * 描述：
 */
public class HomeAdapter extends BaseRecyclerViewAdapter<String> {
    private static final int RIGHT_ITEM_TYPE = 0;
    private static final int LEFT_ITEM_TYPE = 1;

    public HomeAdapter(Context context, String[] strings) {
        super(context, strings);
    }

    @Override
    protected BaseRecyclerViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case RIGHT_ITEM_TYPE:
                view = View.inflate(parent.getContext(), R.layout.item_home_right, null);
                break;
            case LEFT_ITEM_TYPE:
                view = View.inflate(parent.getContext(), R.layout.item_home_left, null);
                break;
        }
        if (view != null) {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
        }
        return new HomeHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return RIGHT_ITEM_TYPE;
        } else {
            return LEFT_ITEM_TYPE;
        }
    }
}
