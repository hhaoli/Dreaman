package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.widget.RadioGroup;

import com.admin.app.R;
import com.admin.app.fragment.CategoryFragment;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/5
 * 描述：
 */
public class CategoryActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mTabs;
    private FragmentManager mManager;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, CategoryActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_category;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.category).setLeftOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTabs = findViewByID(R.id.category_tabs);
    }

    @Override
    protected void setListener() {
        mTabs.setOnCheckedChangeListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mManager = getSupportFragmentManager();
        showFragment(0);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.category_tabs1:
                showFragment(0);
                break;
            case R.id.category_tabs2:
                showFragment(1);
                break;
            case R.id.category_tabs3:
                showFragment(2);
                break;
            case R.id.category_tabs4:
                showFragment(3);
                break;
            case R.id.category_tabs5:
                showFragment(4);
                break;
        }

    }

    private void showFragment(int position) {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.replace(R.id.category_container, CategoryFragment.newInstance(position));
        transaction.commit();
    }
}
