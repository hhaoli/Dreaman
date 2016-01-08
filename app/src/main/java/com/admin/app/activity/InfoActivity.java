package com.admin.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.util.ToastUtils;
import com.admin.app.view.CircleImageView;
import com.admin.app.view.PopupView;
import com.admin.app.view.TitleBuilder;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/7
 * 描述：
 */
public class InfoActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RelativeLayout mBtnAvatar;
    private CircleImageView mAvatar;
    private RelativeLayout mBtnUsername;
    private TextView mUsername;
    private RadioGroup mRadioGroup;
    private RelativeLayout mBtnAddress;
    private TextView mSave;
    private PopupView mPopupView;
    private LinearLayout mBtnGallery;
    private LinearLayout mBtnPhoto;
    private ImageView mBtnDelete;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, InfoActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int layoutResID() {
        return R.layout.activity_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new TitleBuilder(this).setTitle(R.string.personal_information).setLeftOnClickListener(this);
        mBtnAvatar = findViewByID(R.id.info_btn_avatar);
        mAvatar = findViewByID(R.id.info_avatar);
        mBtnUsername = findViewByID(R.id.info_btn_username);
        mUsername = findViewByID(R.id.info_username);
        mRadioGroup = findViewByID(R.id.info_sex);
        mBtnAddress = findViewByID(R.id.info_btn_address);
        mSave = findViewByID(R.id.info_save);
    }

    @Override
    protected void setListener() {
        mBtnAvatar.setOnClickListener(this);
        mBtnUsername.setOnClickListener(this);
        mBtnAddress.setOnClickListener(this);
        mSave.setOnClickListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_iv_left:
                finish();
                break;
            case R.id.info_btn_avatar:
                showAvatar();
                break;
            case R.id.info_btn_username:
                NicknameActivity.launch(this);
                break;
            case R.id.info_btn_address:
                AddressListActivity.launch(this);
                break;
            case R.id.info_save:
                break;
            case R.id.popup_avatar_gallery:
                mPopupView.dismiss();
                ToastUtils.show("s");
                break;
            case R.id.popup_avatar_photo:
                mPopupView.dismiss();
                ToastUtils.show("ss");
                break;
            case R.id.popup_avatar_delete:
                mPopupView.dismiss();
                ToastUtils.show("sss");
                break;
        }
    }

    private void showAvatar() {
        View view = View.inflate(this, R.layout.popup_avatar, null);
        mBtnGallery = (LinearLayout) view.findViewById(R.id.popup_avatar_gallery);
        mBtnPhoto = (LinearLayout) view.findViewById(R.id.popup_avatar_photo);
        mBtnDelete = (ImageView) view.findViewById(R.id.popup_avatar_delete);
        mBtnGallery.setOnClickListener(this);
        mBtnPhoto.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mPopupView = new PopupView(this, R.style.PopupViewTheme_Default, view);
        mPopupView.isTop(false);
        mPopupView.setAnimation(R.style.PopupViewBottomAnimation);
        mPopupView.showBottomView(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.info_male:
                break;
            case R.id.info_female:
                break;
        }
    }
}
