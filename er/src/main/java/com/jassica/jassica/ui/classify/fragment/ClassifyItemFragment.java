package com.jassica.jassica.ui.classify.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.mvp.prestent.EmptyPrestent;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.ui.classify.adapter.NegativeRightFragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyItemFragment extends BaseFragment<EmptyView, EmptyPrestent> {

    private static final String CATEGORY_LIST = "categorylist";

    @BindView(R.id.rv_right)
    RecyclerView rvRight;
    private NegativeRightFragmentAdapter mClassifyAdapter;

    public static ClassifyItemFragment getInstance(ArrayList<ClassifyBean.DatasBean.CategoryListBeanXX.CategoryListBeanX> categoryList) {
        ClassifyItemFragment classifyItemFragment = new ClassifyItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(CATEGORY_LIST, categoryList);
        classifyItemFragment.setArguments(bundle);
        return classifyItemFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify_item;
    }

    @Override
    protected void initView() {
        super.initView();
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<ClassifyBean.DatasBean.CategoryListBeanXX.CategoryListBeanX>   categorylist = arguments.getParcelableArrayList(CATEGORY_LIST);
            //右侧的列表
            rvRight.setLayoutManager(new LinearLayoutManager(getContext()));
            mClassifyAdapter = new NegativeRightFragmentAdapter(getContext(), categorylist);
            rvRight.setAdapter(mClassifyAdapter);
            mClassifyAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected EmptyPrestent initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
