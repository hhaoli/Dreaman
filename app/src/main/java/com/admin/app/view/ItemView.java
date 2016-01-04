package com.admin.app.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.util.UIUtils;

public class ItemView extends RelativeLayout {
    private ImageView mIcon;
    private ImageView mArrow;
    private TextView mLeftText;
    private TextView mRightText;

    public ItemView(Context context) {
        this(context, null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.item_view, this);
        mIcon = (ImageView) findViewById(R.id.item_view_icon);
        mArrow = (ImageView) findViewById(R.id.item_view_arrow);
        mLeftText = (TextView) findViewById(R.id.item_view_left_text);
        mRightText = (TextView) findViewById(R.id.item_view_right_text);
        if (attrs == null) return;
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.ItemView);
        for (int i = 0; i < array.getIndexCount(); i++) {
            int index = array.getIndex(i);
            switch (index) {
                case R.styleable.ItemView_item_icon:
                    mIcon.setImageResource(array.getResourceId(index, 0));
                    break;
                case R.styleable.ItemView_item_arrow:
                    mArrow.setImageResource(array.getResourceId(index, 0));
                    break;
                case R.styleable.ItemView_item_arrow_visibility:
                    setVisibility(mArrow, array.getInt(index, 1));
                    break;
                case R.styleable.ItemView_item_left_text:
                    mLeftText.setText(array.getString(index));
                    break;
                case R.styleable.ItemView_item_right_text:
                    mRightText.setText(array.getString(index));
                    break;
                case R.styleable.ItemView_item_left_color:
                    mLeftText.setTextColor(array.getColor(index, UIUtils.getColor(R.color.gray)));
                    break;
                case R.styleable.ItemView_item_right_color:
                    mRightText.setTextColor(array.getColor(index, UIUtils.getColor(R.color.gray)));
                    break;
                case R.styleable.ItemView_item_left_size:
                    mLeftText.setTextSize(TypedValue.COMPLEX_UNIT_SP, array.getDimension(index, 16));
                    break;
                case R.styleable.ItemView_item_right_size:
                    mRightText.setTextSize(TypedValue.COMPLEX_UNIT_SP, array.getDimension(index, 16));
                    break;
            }
        }
        array.recycle();
    }

    private void setVisibility(ImageView v, int visible) {
        switch (visible) {
            case 0:
                v.setVisibility(View.GONE);
                break;
            case 1:
                v.setVisibility(View.VISIBLE);
                break;
            case 2:
                v.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void setIcon(int resId) {
        mIcon.setImageResource(resId);
    }

    public void setArrow(int resId) {
        mArrow.setImageResource(resId);
    }

    public void setLeftText(int resId) {
        mLeftText.setText(resId);
    }

    public void setLeftText(String text) {
        mLeftText.setText(text);
    }

    public void setLeftTextColor(int resId) {
        mLeftText.setTextColor(UIUtils.getColor(resId));
    }

    public void setLeftTextColor(String color) {
        mLeftText.setTextColor(Color.parseColor(color));
    }

    public void setLeftTextSize(int size) {
        mLeftText.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setRightText(int resId) {
        mRightText.setText(resId);
    }

    public void setRightText(String text) {
        mRightText.setText(text);
    }

    public void setRightTextColor(int resId) {
        mRightText.setTextColor(UIUtils.getColor(resId));
    }

    public void setRightTextColor(String color) {
        mRightText.setTextColor(Color.parseColor(color));
    }

    public void setRightTextSize(int size) {
        mRightText.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }
}
