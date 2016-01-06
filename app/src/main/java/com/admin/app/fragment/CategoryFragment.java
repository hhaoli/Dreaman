package com.admin.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.admin.app.R;
import com.admin.app.adapter.CategoryAdapter;
import com.admin.app.interfaces.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：鸿浩
 * 邮箱：hhaoli@sina.cn
 * 时间：2016/1/6
 * 描述：
 */
public class CategoryFragment extends BaseFragment implements OnItemClickListener {

    private static final String POSITION = "position";
    private int position;
    private TextView mTitle;
    private RecyclerView mRecyclerView;
    private String[] mStrings;
    private List<String[]> mList;

    public static Fragment newInstance(int position) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int layoutResID() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        position = bundle.getInt(POSITION);
        mTitle = findViewByID(R.id.category_title);
        mRecyclerView = findViewByID(R.id.category_recycler_view);
        mStrings = mActivity.getResources().getStringArray(R.array.category);
        String[] array1 = mActivity.getResources().getStringArray(R.array.foods1);
        String[] array2 = mActivity.getResources().getStringArray(R.array.foods2);
        String[] array3 = mActivity.getResources().getStringArray(R.array.foods3);
        String[] array4 = mActivity.getResources().getStringArray(R.array.foods4);
        String[] array5 = mActivity.getResources().getStringArray(R.array.foods5);
        mList = new ArrayList<>();
        mList.add(array1);
        mList.add(array2);
        mList.add(array3);
        mList.add(array4);
        mList.add(array5);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        CategoryAdapter adapter = new CategoryAdapter(mRecyclerView, R.layout.item_category);
        adapter.setOnItemClickListener(this);
        mTitle.setText(mStrings[position]);
        adapter.setDatas(Arrays.asList(mList.get(position)));
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 3));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    public void OnItemClick(ViewGroup parent, View itemView, int position) {

    }
}
