package com.jassica.jassica.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.bean.HelpContentBean;
import com.jassica.jassica.mvp.prestent.HelpPrestent;
import com.jassica.jassica.mvp.view.HelpView;
import com.jassica.jassica.ui.me.adapter.HelpContentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * 帮助中心
 * */
public class HelpCententActivity extends BaseActivity<HelpView, HelpPrestent> implements HelpView {


    @BindView(R.id.help_rlv)
    RecyclerView helpRlv;
    @BindView(R.id.img_help)
    ImageView imgHelp;
    private String input;
    private ArrayList<HelpContentBean.DatasBean.DataListBean> list = new ArrayList<>();
    private HelpContentAdapter helpContentAdapter;

    protected HelpPrestent initPresenter() {
        return new HelpPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(HelpCententActivity.this);
        return R.layout.activity_help_centent;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getHelpContent();
    }

    @Override
    protected void initView() {
        super.initView();
        helpRlv.setLayoutManager(new LinearLayoutManager(this));
        helpContentAdapter = new HelpContentAdapter(list, this);
        helpRlv.setAdapter(helpContentAdapter);
    }

    @Override
    public void setHelpContent(HelpContentBean bean) {
        List<HelpContentBean.DatasBean.DataListBean> dataList = bean.getDatas().getDataList();
        list.addAll(dataList);
        helpContentAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.img_help)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (list != null) {
            list.clear();
        }
    }
}
