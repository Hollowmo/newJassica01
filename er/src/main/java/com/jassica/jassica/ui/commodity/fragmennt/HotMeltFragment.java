package com.jassica.jassica.ui.commodity.fragmennt;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.NewHotBean;
import com.jassica.jassica.mvp.prestent.HotPrestent;
import com.jassica.jassica.mvp.view.HotView;
import com.jassica.jassica.ui.commodity.adapter.HotAdapter;
import com.jassica.jassica.widget.AppUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 热销
 */
public class HotMeltFragment extends BaseFragment<HotView, HotPrestent> implements HotView {

    @BindView(R.id.hot_rlv)
    RecyclerView hotRlv;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;

    private ArrayList<NewHotBean.DatasBean.GoodsListBean> hotBeans;
    private HotAdapter hotAdapter;
    private int mPage = 1;

    @Override
    protected HotPrestent initPresenter() {
        return new HotPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot_melt;
    }

    @Override
    protected void initData() {
        mPresenter.getHot(getMap(getContext(),mPage));
    }

    private static HashMap<String,String> getMap(Context context,int page) {
        HashMap<String, String> map = new HashMap<>();
        map.put(Api.VERSION, AppUtils.getVersionCode(context)+"");
        map.put(Api.DEVICEID,"C728A87ABE9D49ACB64C34679D68414C");
        map.put(Api.PAGESIZE,"20");
        map.put(Api.SORT,"sale_desc");
        map.put(Api.PAGE,String.valueOf(page));
        return map;
    }

    @Override
    protected void initView() {
        super.initView();
        mSrl.setEnableRefresh(false);
        HotRLv();
    }

    private void HotRLv() {
        hotRlv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        hotBeans = new ArrayList<>();
        hotAdapter = new HotAdapter(getActivity(), hotBeans);
        hotRlv.setAdapter(hotAdapter);

        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPage++;
                initData();
                mSrl.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
              /*  mPage = 0;
                bannerlsit.clear();
                mlist.clear();
                initData();

                mSrl.finishRefresh();*/
            }
        });

    }

    @Override
    public void getHotDatas(NewHotBean bean) {
        List<NewHotBean.DatasBean.GoodsListBean> goodsList = bean.getDatas().getGoodsList();
        hotBeans.addAll(goodsList);
        hotAdapter.notifyDataSetChanged();
    }
}
