package com.jassica.jassica.ui.home.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.HomeBannerBean;
import com.jassica.jassica.mvp.prestent.BannerPrestent;
import com.jassica.jassica.mvp.view.BannerView;
import com.jassica.jassica.net.RxUtils;
import com.jassica.jassica.ui.home.activity.Main2Activity;
import com.jassica.jassica.ui.home.activity.SerachActivity;
import com.jassica.jassica.ui.home.adapter.HomeBannerAdapter;
import com.jassica.jassica.ui.main.activity.MainScanActivity;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.internal.schedulers.RxThreadFactory;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment<BannerView, BannerPrestent> implements BannerView {

    @BindView(R.id.home_rlv)
    RecyclerView mHomerlv;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;
    @BindView(R.id.btn_main)
    ImageView mBtnmain;
    @BindView(R.id.main_scan)
    ImageView mMainScan;
    @BindView(R.id.main_king)
    ImageView mMainKing;
    @BindView(R.id.main_search)
    ImageView mMainSearch;
    @BindView(R.id.main_toolbar)
    Toolbar mMainToolbar;

    private ArrayList<HomeBannerBean.DatasBean.ItemListBean> homeBannerBeans = new ArrayList<>();
    private HomeBannerAdapter homeBannerAdapter;

    @Override
    protected BannerPrestent initPresenter() {
        return new BannerPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        super.initView();
        mMainToolbar.setTitle("");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mHomerlv.setLayoutManager(linearLayoutManager);
        homeBannerAdapter = new HomeBannerAdapter(getContext(), homeBannerBeans);
        mHomerlv.setAdapter(homeBannerAdapter);
        mSrl.setEnableLoadMore(false);
        mSrl.setRefreshHeader(new MaterialHeader(getActivity()));
        mHomerlv.setHasFixedSize(true);//滑动更快
        mHomerlv.setNestedScrollingEnabled(false);

        //点击悬浮按钮回到顶部并显示隐藏的toolbar与底部导航栏
        mBtnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHomerlv.smoothScrollToPosition(0);
            }
        });

        initRecy();

        //上拉刷新 下拉加载
        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mSrl.finishLoadMore(1000);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getBanner();
                homeBannerBeans.clear();
            }
        });
    }



    //下拉隐藏底部导航栏
    @SuppressLint("ClickableViewAccessibility")
    private void initRecy() {
        mHomerlv.setOnTouchListener(new View.OnTouchListener() {
            private float mEndY;
            private float mStartY;

            @SuppressLint("RestrictedApi")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mStartY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mEndY = event.getY();
                        float v1 = mEndY - mStartY;
                        if (v1 > 0) {
                            mBtnmain.setVisibility(View.GONE);
                        } else if (v1 < 0) {
                            mBtnmain.setVisibility(View.VISIBLE);
                        }
                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }
                return gestureDetector.onTouchEvent(event);
            }
        });
    }

    GestureDetector gestureDetector = new GestureDetector(getContext(),
            new GestureDetector.OnGestureListener() {
                @Override
                public boolean onDown(MotionEvent e) {
                    return false;
                }

                @Override
                public void onShowPress(MotionEvent e) {
                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    // do something
                    return true;
                }

                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    return false;
                }
            });


    @Override
    protected void initData() {
        super.initData();
        //数据回来之前加载动画
        showLoading();
        mPresenter.getBanner();
    }

    @OnClick({R.id.main_scan, R.id.main_search,R.id.btn_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //扫一扫
            case R.id.main_scan:
                Intent scan = new Intent(getActivity(), MainScanActivity.class);
                startActivity(scan);
                break;
            //搜索
            case R.id.main_search:
                Intent intent = new Intent(getActivity(), SerachActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_main:
                break;
        }
    }

    @Override
    public void setBanner(HomeBannerBean bean) {
        List<HomeBannerBean.DatasBean.ItemListBean> data = bean.getDatas().getItemList();
        homeBannerBeans.addAll(data);
        hideLoading(); 
        homeBannerAdapter.notifyDataSetChanged();
        //数据加载完毕隐藏
        mSrl.finishRefresh(500);
    }
}
