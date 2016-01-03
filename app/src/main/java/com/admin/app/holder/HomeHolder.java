package com.admin.app.holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.admin.app.R;
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
        int index = position % 6;
        switch (index) {
            case 0:
                mIcon.setImageResource(R.mipmap.icon_home_item6);
                break;
            case 1:
                mIcon.setImageResource(R.mipmap.icon_home_item1);
                break;
            case 2:
                mIcon.setImageResource(R.mipmap.icon_home_item2);
                break;
            case 3:
                mIcon.setImageResource(R.mipmap.icon_home_item3);
                break;
            case 4:
                mIcon.setImageResource(R.mipmap.icon_home_item4);
                break;
            case 5:
                mIcon.setImageResource(R.mipmap.icon_home_item5);
                break;
        }
    }
}
