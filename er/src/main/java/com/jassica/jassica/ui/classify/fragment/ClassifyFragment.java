package com.jassica.jassica.ui.classify.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.mvp.prestent.ClassifyPrestent;
import com.jassica.jassica.mvp.view.ClassifyView;
import com.jassica.jassica.utils.ToastUtil;
import com.jassica.jassica.widget.verticaltablayout.QTabView;
import com.jassica.jassica.widget.verticaltablayout.TabAdapter;
import com.jassica.jassica.widget.verticaltablayout.TabView;
import com.jassica.jassica.widget.verticaltablayout.VerticalTabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;

/*
 * 分类
 * */
public class ClassifyFragment extends BaseFragment<ClassifyView, ClassifyPrestent> implements ClassifyView {

    @BindView(R.id.tab)
    VerticalTabLayout mTab;

    private ArrayList<String> mTitlesList = new ArrayList<>();//初始化Tab栏数据;
    private ArrayList<Fragment> mFragmentsList = new ArrayList<>();//添加fragment

    @Override
    protected ClassifyPrestent initPresenter() {
        return new ClassifyPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initView() {
        if (mTitlesList != null) {
            mTitlesList.clear();
        }
        if (mFragmentsList != null) {
            mFragmentsList.clear();
        }
        mTab.removeAllTabs();
        mTab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                SwitchFragment(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }

    // 切换 容器
    private void SwitchFragment(int position) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (!mFragmentsList.get(position).isAdded()) {
            transaction.add(R.id.class_fl, mFragmentsList.get(position));
        } else {
            transaction.replace(R.id.class_fl, mFragmentsList.get(position));
        }
        transaction.commit();
    }

    @Override
    protected void initData() {
        showLoading();
        mPresenter.getNavigation();
    }


    @Override
    public void getDatas(ClassifyBean bean) {
        hideLoading();
        List<ClassifyBean.DatasBean.CategoryListBeanXX> categoryList = bean.getDatas().getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            mTitlesList.add(categoryList.get(i).getCategoryName());
            mFragmentsList.add(ClassifyItemFragment.getInstance((ArrayList<ClassifyBean.DatasBean.CategoryListBeanXX.CategoryListBeanX>) categoryList.get(i).getCategoryList()));
            mTab.setTabAdapter(new TabAdapter() {
                @Override
                public int getCount() {
                    return mTitlesList.size();
                }

                @Override
                public int getBadge(int position) {
                    return 0;
                }

                @Override
                public QTabView.TabIcon getIcon(int position) {
                    return null;
                }

                @Override
                public QTabView.TabTitle getTitle(int position) {
                    QTabView.TabTitle title = null;
                    if (mTitlesList.size() > 0) {
                        title = new QTabView.TabTitle.Builder(Objects.requireNonNull(getActivity()))
                                .setContent(mTitlesList.get(position))
                                .setTextColor(Color.BLUE, Color.BLACK)
                                .build();
                    } else {
                        ToastUtil.showShort("Tab数据集合为空！");
                    }
                    return title;
                }

                @Override
                public int getBackground(int position) {
                    return 0;
                }
            });
        }
        // 显示首次进入默认容器
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        if (!mFragmentsList.get(0).isAdded()) {
            fragmentTransaction.add(R.id.class_fl, mFragmentsList.get(0));
        } else {
            fragmentTransaction.replace(R.id.class_fl, mFragmentsList.get(0));
        }
        fragmentTransaction.commit();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mTitlesList != null) {
            mTitlesList.clear();
        }
        if (mFragmentsList != null) {
            mFragmentsList.clear();
        }
        if (mTab != null) {
            mTab.removeAllTabs();
        }
    }
}