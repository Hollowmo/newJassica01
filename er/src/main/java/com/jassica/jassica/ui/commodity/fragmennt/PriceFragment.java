package com.jassica.jassica.ui.commodity.fragmennt;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.PriceBean;
import com.jassica.jassica.mvp.prestent.PricePrestent;
import com.jassica.jassica.mvp.view.PriceView;
import com.jassica.jassica.ui.commodity.adapter.PriceAdapter;
import com.jassica.jassica.widget.AppUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/*
* 价格
* */
public class PriceFragment extends BaseFragment<PriceView, PricePrestent> implements PriceView {

    @BindView(R.id.price_rlv)
    RecyclerView priceRlv;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;

    private ArrayList<PriceBean.DatasBean.GoodsListBean> hotBeans;
    private PriceAdapter mPriceAdapter;
    private int mPage = 1;

    @Override
    protected PricePrestent initPresenter() {
        return new PricePrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_price;
    }

    @Override
    protected void initData() {
        HashMap<String, String> map = new HashMap<>();
        map.put(Api.VERSION, AppUtils.getVersionCode(getContext())+"");
        map.put(Api.DEVICEID,"C728A87ABE9D49ACB64C34679D68414C");
        map.put(Api.PAGESIZE,"20");
        map.put(Api.SORT,"price_asc");
        map.put(Api.PAGE,mPage+"");
        mPresenter.getPrice(map);
    }

    @Override
    protected void initView() {
        super.initView();
        mSrl.setEnableRefresh(false);
        HotRLv();
    }

    private void HotRLv() {
        priceRlv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        hotBeans = new ArrayList<>();
        mPriceAdapter = new PriceAdapter(getActivity(), hotBeans);
        priceRlv.setAdapter(mPriceAdapter);

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
    public void getPriceDatas(PriceBean bean) {
        List<PriceBean.DatasBean.GoodsListBean> goodsList = bean.getDatas().getGoodsList();
        hotBeans.addAll(goodsList);
        mPriceAdapter.notifyDataSetChanged();
    }
}
