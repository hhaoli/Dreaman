package com.admin.app.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.admin.app.R;
import com.admin.app.constant.ConstantValue;
import com.admin.app.fragment.FragmentFactory;
import com.admin.app.fragment.GrabFragment;
import com.admin.app.fragment.HomeFragment;
import com.admin.app.fragment.SelfFragment;
import com.admin.app.fragment.TogetherFragment;
import com.admin.app.util.AnimatorUtils;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup mTabs;
    private FrameLayout mMenu;
    private CircleImageView mMenuOpen;
    private CircleImageView mMenuClose;
    private CircleImageView mMenuCategory;
    private CircleImageView mMenuSearch;
    private CircleImageView mMenuHot;
    private CircleImageView mMenuAround;
    private int index = 0;
    private HomeFragment mHomeFragment;
    private TogetherFragment mTogetherFragment;
    private GrabFragment mGrabFragment;
    private SelfFragment mSelfFragment;
    private FragmentManager mFragmentManager;
    private boolean isOpen = false;//是否有打开菜单,默认关闭
    private long firstTime = 0;//点击退出时记录时间

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTabs = findViewByID(R.id.main_tabs);
        mMenu = findViewByID(R.id.main_menu);
        mMenuOpen = findViewByID(R.id.menu_open);
        mMenuClose = findViewByID(R.id.menu_close);
        mMenuCategory = findViewByID(R.id.menu_category);
        mMenuSearch = findViewByID(R.id.menu_search);
        mMenuHot = findViewByID(R.id.menu_hot);
        mMenuAround = findViewByID(R.id.menu_around);
    }

    @Override
    protected void setListener() {
        mTabs.setOnCheckedChangeListener(this);
        mMenu.setOnClickListener(this);
        mMenuOpen.setOnClickListener(this);
        mMenuClose.setOnClickListener(this);
        mMenuCategory.setOnClickListener(this);
        mMenuSearch.setOnClickListener(this);
        mMenuHot.setOnClickListener(this);
        mMenuAround.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mFragmentManager = getSupportFragmentManager();
        onTabSelected(0);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        int position = intent.getIntExtra(ConstantValue.MAIN_INDEX, 0);
        onTabSelected(position);
    }

    private void onTabSelected(int position) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();//必须放在这里,每次调用都要实例化
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (null == mHomeFragment) {
                    mHomeFragment = (HomeFragment) FragmentFactory.getFragment(0);
                    transaction.add(R.id.main_container, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case 1:
                if (null == mTogetherFragment) {
                    mTogetherFragment = (TogetherFragment) FragmentFactory.getFragment(1);
                    transaction.add(R.id.main_container, mTogetherFragment);
                } else {
                    transaction.show(mTogetherFragment);
                }
                break;
            case 2:
                if (null == mGrabFragment) {
                    mGrabFragment = (GrabFragment) FragmentFactory.getFragment(2);
                    transaction.add(R.id.main_container, mGrabFragment);
                } else {
                    transaction.show(mGrabFragment);
                }
                break;
            case 3:
                if (null == mSelfFragment) {
                    mSelfFragment = (SelfFragment) FragmentFactory.getFragment(3);
                    transaction.add(R.id.main_container, mSelfFragment);
                } else {
                    transaction.show(mSelfFragment);
                }
                break;
        }
        index = position;
        transaction.commitAllowingStateLoss();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mTogetherFragment != null) {
            transaction.hide(mTogetherFragment);
        }
        if (mGrabFragment != null) {
            transaction.hide(mGrabFragment);
        }
        if (mSelfFragment != null) {
            transaction.hide(mSelfFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_menu:
                hideMenu();
                break;
            case R.id.menu_open:
                showMenu();
                break;
            case R.id.menu_close:
                hideMenu();
                break;
            case R.id.menu_category:
                hideMenu();
                ToastUtils.show("分类");
                break;
            case R.id.menu_search:
                hideMenu();
                ToastUtils.show("搜索");
                break;
            case R.id.menu_hot:
                hideMenu();
                ToastUtils.show("热门");
                break;
            case R.id.menu_around:
                hideMenu();
                ToastUtils.show("逛逛");
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_home:
                onTabSelected(0);
                break;
            case R.id.main_together:
                onTabSelected(1);
                break;
            case R.id.main_grab:
                onTabSelected(2);
                break;
            case R.id.main_self:
                onTabSelected(3);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(ConstantValue.MAIN_INDEX, index);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        index = savedInstanceState.getInt(ConstantValue.MAIN_INDEX);
    }

    @Override
    public void onBackPressed() {
        if (isOpen) {
            hideMenu();
            return;
        }
        long secondTime = System.currentTimeMillis();
        //如果两次按键的时间间隔大于1000毫秒,则不退出
        if (secondTime - firstTime > 1000) {
            ToastUtils.show("再按一次退出客户端");
            firstTime = secondTime;//更新firstTime
        } else {
            exitApp();
        }
    }

    private void showMenu() {
        isOpen = true;
        mMenu.setVisibility(View.VISIBLE);
        List<Animator> animList = new ArrayList<>();
        Animator anim = ObjectAnimator.ofPropertyValuesHolder(mMenuClose, AnimatorUtils.rotation(0f, 225f));
        animList.add(anim);
        animList.add(showItemAnimator(mMenuCategory));
        animList.add(showItemAnimator(mMenuSearch));
        animList.add(showItemAnimator(mMenuHot));
        animList.add(showItemAnimator(mMenuAround));
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(400);
//        animSet.setInterpolator(new OvershootInterpolator());
        animSet.playTogether(animList);
        animSet.start();
    }

    private void hideMenu() {
        isOpen = false;
        List<Animator> animList = new ArrayList<>();
        Animator anim = ObjectAnimator.ofPropertyValuesHolder(mMenuClose, AnimatorUtils.rotation(225f, 0f));
        animList.add(anim);
        animList.add(hideItemAnimator(mMenuCategory));
        animList.add(hideItemAnimator(mMenuSearch));
        animList.add(hideItemAnimator(mMenuHot));
        animList.add(hideItemAnimator(mMenuAround));
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(400);
//        animSet.setInterpolator(new AnticipateInterpolator());
        animSet.playTogether(animList);
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mMenu.setVisibility(View.GONE);
            }
        });
        animSet.start();
    }

    private Animator showItemAnimator(View item) {
        float dx = mMenuClose.getX() - item.getX();
        float dy = mMenuClose.getY() - item.getY();
        item.setRotation(0f);
        item.setTranslationX(dx);
        item.setTranslationY(dy);
        Animator anim = ObjectAnimator.ofPropertyValuesHolder(item,
                AnimatorUtils.rotation(0f, 720f),
                AnimatorUtils.translationX(dx, 0f),
                AnimatorUtils.translationY(dy, 0f)
        );
        return anim;
    }

    private Animator hideItemAnimator(final View item) {
        float dx = mMenuClose.getX() - item.getX();
        float dy = mMenuClose.getY() - item.getY();
        Animator anim = ObjectAnimator.ofPropertyValuesHolder(item,
                AnimatorUtils.rotation(720f, 0f),
                AnimatorUtils.translationX(0f, dx),
                AnimatorUtils.translationY(0f, dy)
        );
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                item.setTranslationX(0f);
                item.setTranslationY(0f);
            }
        });
        return anim;
    }
}
