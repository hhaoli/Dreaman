package com.admin.app.holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.util.IconUtils;
import com.admin.app.util.UIUtils;
import com.admin.app.view.CircleImageView;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/3
 * 描述：
 */
public class HomeHolder extends BaseRecyclerViewHolder<String> {
    public FrameLayout mBtn;
    public ImageView mColor;
    public TextView mText;
    public CircleImageView mIcon;

    public HomeHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        mBtn = findViewByID(R.id.item_home_btn);
        mColor = findViewByID(R.id.item_home_color);
        mText = findViewByID(R.id.item_home_tv);
        mIcon = findViewByID(R.id.item_home_icon);
    }

    @Override
    protected void onBindData(final String s, int position) {
        mText.setText(s);
        mIcon.setImageResource(IconUtils.getHomeIcon(position));
        mColor.setBackgroundColor(UIUtils.getColor(IconUtils.getHomeColor(position)));
    }
}
