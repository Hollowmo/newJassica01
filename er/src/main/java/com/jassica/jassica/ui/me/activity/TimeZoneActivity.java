package com.jassica.jassica.ui.me.activity;

import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BasePresenter;
import com.jassica.jassica.bean.TimeZoneBean;
import com.jassica.jassica.mvp.prestent.TimeZongPrestent;
import com.jassica.jassica.mvp.view.TimeZongView;
import com.jassica.jassica.ui.home.adapter.RlvTimeZoneAdapter;
import com.jassica.jassica.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

import butterknife.BindView;
import butterknife.OnClick;

public class TimeZoneActivity extends BaseActivity<TimeZongView, TimeZongPrestent> implements TimeZongView {

    @BindView(R.id.exchange_out)
    ImageView exchangeOut;
    @BindView(R.id.exchange_too)
    Toolbar exchangeToo;
    @BindView(R.id.tv_timeout)
    TextView tvTimeout;
    @BindView(R.id.rlv_timezone)
    RecyclerView rlvTimezone;

    private ArrayList<TimeZoneBean.DatasBean.GoodsListBean> goodsListBeans = new ArrayList<>();
    private RlvTimeZoneAdapter mRlvTimeZoneAdapter;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected TimeZongPrestent initPresenter() {
        return new TimeZongPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(TimeZoneActivity.this);
        return R.layout.activity_time_zone;
    }

    @Override
    protected void initData() {
        mPresenter.getTimeZong();
    }

    @Override
    protected void initView() {
        super.initView();
        rlvTimezone.setLayoutManager(new GridLayoutManager(TimeZoneActivity.this, 2));
        mRlvTimeZoneAdapter = new RlvTimeZoneAdapter(this, goodsListBeans);
        rlvTimezone.setAdapter(mRlvTimeZoneAdapter);

        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                initData();
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    @OnClick(R.id.exchange_out)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void getTimeZongDatas(TimeZoneBean bean) {
        List<TimeZoneBean.DatasBean.GoodsListBean> goodsList = bean.getDatas().getGoodsList();
        String time = DateUtil.formatTime(bean.getDatas().getPromotionEndTime());
        tvTimeout.setText("距离结束还剩" + time);
        if (goodsListBeans != null) {
            goodsListBeans.clear();
        }
        goodsListBeans.addAll(goodsList);
        mRlvTimeZoneAdapter.notifyDataSetChanged();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

}
