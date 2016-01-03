package com.admin.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.admin.app.R;
import com.admin.app.view.TitleBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2015/12/31
 * 描述：
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static List<BaseActivity> activityList = new LinkedList<>();
    private TitleBuilder mTitleBuilder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        synchronized (activityList) {
            activityList.add(this);
        }
        setContentView(layoutResID());
        initView(savedInstanceState);
        setListener();
        processLogic(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (activityList) {
            activityList.remove(this);
        }
    }

    /**
     * 设置布局
     */
    protected abstract int layoutResID();

    /**
     * 初始化View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 给View控件添加事件监听器
     */
    protected abstract void setListener();

    /**
     * 处理业务逻辑，状态恢复等操作
     */
    protected abstract void processLogic(Bundle savedInstanceState);

    /**
     * 实例化控件
     */
    protected <V extends View> V findViewByID(@IdRes int id) {
        return (V) findViewById(id);
    }

    public static void exitApp() {
        ListIterator<BaseActivity> iterator = activityList.listIterator();
        while (iterator.hasNext()) {
            Activity next = iterator.next();
            next.finish();
        }
    }
}
