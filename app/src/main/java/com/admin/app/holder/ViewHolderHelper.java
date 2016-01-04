package com.admin.app.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.admin.app.interfaces.OnItemChildCheckedChangeListener;
import com.admin.app.interfaces.OnItemChildClickListener;
import com.admin.app.interfaces.OnItemChildLongClickListener;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/4
 * 描述：
 */
public class ViewHolderHelper implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener {

    protected final SparseArray<View> mViews;
    protected View mConvertView;
    protected Context mContext;
    protected int mPosition;
    protected RecyclerViewHolder mRecyclerViewHolder;
    protected RecyclerView mRecyclerView;
    protected ViewGroup mAdapterView;

    protected OnItemChildClickListener mOnItemChildClickListener;
    protected OnItemChildLongClickListener mOnItemChildLongClickListener;
    protected OnItemChildCheckedChangeListener mOnItemChildCheckedChangeListener;

    public ViewHolderHelper(ViewGroup adapterView, View convertView) {
        mViews = new SparseArray<>();
        this.mAdapterView = adapterView;
        this.mConvertView = convertView;
        this.mContext = convertView.getContext();
    }

    public ViewHolderHelper(RecyclerView recyclerView, View convertView) {
        mViews = new SparseArray<>();
        this.mRecyclerView = recyclerView;
        this.mConvertView = convertView;
        this.mContext = convertView.getContext();
    }

    public void setRecyclerViewHolder(RecyclerViewHolder recyclerViewHolder) {
        mRecyclerViewHolder = recyclerViewHolder;
    }

    public RecyclerViewHolder getRecyclerViewHolder() {
        return mRecyclerViewHolder;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public int getPosition() {
        if (mRecyclerViewHolder != null) {
            return mRecyclerViewHolder.getAdapterPosition();
        }
        return mPosition;
    }

    //设置item子控件点击事件监听器
    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    //为id为viewId的item子控件设置点击事件监听器
    public void setOnItemChildClickListener(@IdRes int viewId) {
        getView(viewId).setOnClickListener(this);
    }

    //设置item子控件长按事件监听器
    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    //为id为viewId的item子控件设置长按事件监听器
    public void setOnItemChildLongClickListener(@IdRes int viewId) {
        getView(viewId).setOnLongClickListener(this);
    }

    //设置item子控件选中状态变化事件监听器
    public void setOnItemChildCheckedChangeListener(OnItemChildCheckedChangeListener onItemChildCheckedChangeListener) {
        mOnItemChildCheckedChangeListener = onItemChildCheckedChangeListener;
    }

    //为id为viewId的item子控件设置选中状态变化事件监听器
    public void setOnItemChildCheckedChangeListener(@IdRes int viewId) {
        if (getView(viewId) instanceof CompoundButton) {
            ((CompoundButton) getView(viewId)).setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemChildClickListener != null) {
            if (mRecyclerView != null) {
                mOnItemChildClickListener.onItemChildClick(mRecyclerView, v, getPosition());
            } else if (mAdapterView != null) {
                mOnItemChildClickListener.onItemChildClick(mAdapterView, v, getPosition());
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnItemChildLongClickListener != null) {
            if (mRecyclerView != null) {
                mOnItemChildLongClickListener.onItemChildLongClick(mRecyclerView, v, getPosition());
            } else if (mAdapterView != null) {
                mOnItemChildLongClickListener.onItemChildLongClick(mAdapterView, v, getPosition());
            }
        }
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (mOnItemChildCheckedChangeListener != null) {
            if (mRecyclerView != null) {
                mOnItemChildCheckedChangeListener.onItemChildCheckedChanged(mRecyclerView, buttonView, getPosition(), isChecked);
            } else if (mAdapterView != null) {
                mOnItemChildCheckedChangeListener.onItemChildCheckedChanged(mAdapterView, buttonView, getPosition(), isChecked);
            }
        }
    }

    //通过控件的Id获取对应的控件，如果没有则加入mViews，则从item根控件中查找并保存到mViews中
    public <T extends View> T getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
        }
        return (T) view;
    }


    // 通过ImageView的Id获取ImageView
    public ImageView getImageView(@IdRes int viewId) {
        return getView(viewId);
    }

    // 通过TextView的Id获取TextView
    public TextView getTextView(@IdRes int viewId) {
        return getView(viewId);
    }

    // 获取item的根控件
    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 设置对应id的控件的文本内容
     */
    public ViewHolderHelper setText(@IdRes int viewId, CharSequence text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 设置对应id的控件的文本内容
     */
    public ViewHolderHelper setText(@IdRes int viewId, @StringRes int stringResId) {
        TextView view = getView(viewId);
        view.setText(stringResId);
        return this;
    }

    /**
     * 设置对应id的控件的html文本内容
     */
    public ViewHolderHelper setHtml(@IdRes int viewId, String source) {
        TextView view = getView(viewId);
        view.setText(Html.fromHtml(source));
        return this;
    }

    /**
     * 设置对应id的控件是否选中
     */
    public ViewHolderHelper setChecked(@IdRes int viewId, boolean checked) {
        Checkable view = getView(viewId);
        view.setChecked(checked);
        return this;
    }

    public ViewHolderHelper setTag(@IdRes int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public ViewHolderHelper setTag(@IdRes int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public ViewHolderHelper setVisibility(@IdRes int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }

    public ViewHolderHelper setImageBitmap(@IdRes int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public ViewHolderHelper setImageDrawable(@IdRes int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public ViewHolderHelper setTextColorRes(@IdRes int viewId, @ColorRes int textColorResId) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorResId));
        return this;
    }

    public ViewHolderHelper setTextColor(@IdRes int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public ViewHolderHelper setBackgroundRes(@IdRes int viewId, int backgroundResId) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundResId);
        return this;
    }

    public ViewHolderHelper setBackgroundColor(@IdRes int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public ViewHolderHelper setBackgroundColorRes(@IdRes int viewId, @ColorRes int colorResId) {
        View view = getView(viewId);
        view.setBackgroundColor(mContext.getResources().getColor(colorResId));
        return this;
    }

    public ViewHolderHelper setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }
}
