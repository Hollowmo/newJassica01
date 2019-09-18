package com.jassica.jassica.ui.commodity.fragmennt;


import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.NewProductBean;
import com.jassica.jassica.mvp.prestent.NewProductPrestent;
import com.jassica.jassica.mvp.view.NewProductView;
import com.jassica.jassica.ui.commodity.adapter.NewProductAdapter;
import com.jassica.jassica.widget.AppUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 新品
 */
public class NewProductFragment extends BaseFragment<NewProductView, NewProductPrestent> implements NewProductView {

    @BindView(R.id.new_product_rlv)
    RecyclerView newProductRlv;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;

    private ArrayList<NewProductBean.DatasBean.GoodsListBean> mGoodsListBeans;
    private NewProductAdapter mNewProductAdapter;
    private int mPage = 1;

    @Override
    protected NewProductPrestent initPresenter() {
        return new NewProductPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_new_product;
    }

    @Override
    protected void initData() {
        HashMap<String, String> map = new HashMap<>();
        //?version=1.0&deviceId=C728A87ABE9D49ACB64C34679D68414C&pageSize=20&sort=newGoodsStartTime_desc&page=1
        map.put(Api.VERSION, AppUtils.getVersionCode(getContext())+"");
        map.put(Api.DEVICEID,"C728A87ABE9D49ACB64C34679D68414C");
        map.put(Api.PAGESIZE,"20");
        map.put(Api.SORT,"newGoodsStartTime_desc");
        map.put(Api.PAGE,mPage+"");
        mPresenter.getNewProduct(map);
    }

    @Override
    protected void initView() {

        mSrl.setEnableRefresh(false);

        newProductRlv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mGoodsListBeans = new ArrayList<>();
        mNewProductAdapter = new NewProductAdapter(getActivity(), mGoodsListBeans);
        newProductRlv.setAdapter(mNewProductAdapter);

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
    public void getNewProductDatas(NewProductBean bean) {
        List<NewProductBean.DatasBean.GoodsListBean> goodsList = bean.getDatas().getGoodsList();
        Log.d("ads",goodsList.toString());
        mGoodsListBeans.addAll(goodsList);
        mNewProductAdapter.notifyDataSetChanged();
    }
}