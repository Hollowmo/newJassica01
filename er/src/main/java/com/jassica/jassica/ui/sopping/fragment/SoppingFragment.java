package com.jassica.jassica.ui.sopping.fragment;


import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.ui.main.activity.MainActivity;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 购物车
 */
public class SoppingFragment extends BaseFragment {

    @BindView(R.id.btn_guang_yi_guang)
    TextView btnGuangYiGuang;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sopping;
    }

    @OnClick(R.id.btn_guang_yi_guang)
    public void onViewClicked() {
        MainActivity mAcitivty = (MainActivity) getActivity();
        ViewPager mv = mAcitivty.findViewById(R.id.main_vp);
        // 在切换时避免出现滑动,需强制切换
        try {
            Field mCurItem = mv.getClass().getField("mCurItem");
            mCurItem.setAccessible(true);
            mCurItem.setInt(mv, 0);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mv.setCurrentItem(0);
    }
}
