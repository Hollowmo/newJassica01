package com.jassica.jassica.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseActivity;
import com.jassica.jassica.base.BaseApp;
import com.jassica.jassica.base.Constants;
import com.jassica.jassica.bean.SerachBean;
import com.jassica.jassica.mvp.prestent.EmptyPrestent;
import com.jassica.jassica.mvp.view.EmptyView;
import com.jassica.jassica.ui.home.adapter.SearchHistoryRlvAdapter;
import com.jassica.jassica.ui.home.adapter.SerachAdapter;
import com.jassica.jassica.utils.ListDataSave;
import com.jassica.jassica.utils.ToastUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *  搜索框
 * */
public class SerachActivity extends BaseActivity<EmptyView, EmptyPrestent> implements EmptyView {


    @BindView(R.id.search_out)
    ImageView searchOut;
    @BindView(R.id.search_rlv1)
    RecyclerView searchRlv1;
    @BindView(R.id.serach_rlv2)
    RecyclerView serachRlv2;
    @BindView(R.id.serach_input)
    EditText serachInput;
    @BindView(R.id.search_sousuo)
    TextView searchSousuo;
    @BindView(R.id.search_empty)
    ImageView searchEmpty;
    @BindView(R.id.serach_text2)
    TextView serachText2;
    @BindView(R.id.rl_search_history)
    RelativeLayout rlSearchHistory;

    private ListDataSave mListDataSave;
    private ArrayList<String> mSearchList;
    private int mIndex;
    private SearchHistoryRlvAdapter mAdapter;
    private ArrayList<SerachBean.DatasBean.KeywordListBean> list;
    private SerachAdapter adapter;

    @Override
    protected EmptyPrestent initPresenter() {
        return new EmptyPrestent();
    }

    @Override
    protected int getLayoutId() {
        setStatusBar(SerachActivity.this);
        return R.layout.activity_serach;
    }

    @Override
    protected void initView() {
        SerachRlv1();
        SerachRlv2();
    }

    private void SerachRlv1() {
        searchRlv1.setLayoutManager(new GridLayoutManager(this,4 ));
        list = new ArrayList<>();
        adapter = new SerachAdapter(list, this);
        searchRlv1.setAdapter(adapter);
        initSearchData();
    }

    private void initSearchData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.NAVIGATION_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<SerachBean> data = api.getSerachData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerachBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SerachBean bean) {
                        List<SerachBean.DatasBean.KeywordListBean> keywordList = bean.getDatas().getKeywordList();
                        list.addAll(keywordList);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void SerachRlv2() {
        mSearchList = new ArrayList<>();
        mListDataSave = new ListDataSave(BaseApp.getInstance(), "search");
        BingdingSearchRlv();
        getHistorySearchMethod();

    }

    private void getHistorySearchMethod() {
        if (getHistorySearch().size() > 0) {
            rlSearchHistory.setVisibility(View.VISIBLE);
        } else {
            rlSearchHistory.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {
        super.initData();
         }

    private void BingdingSearchRlv() {
        List<String> list = getHistorySearch();
        List<String> removeList = getRemoveList(list);
        int size = removeList.size();
        if (size > 5) {
            mIndex = size - 5;
        }
        for (int i = 0; i < mIndex; i++) {
            removeList.remove(5 + mIndex - i - 1);
        }
        mSearchList.addAll(removeList);
        serachRlv2.setLayoutManager(new GridLayoutManager(this, 5));
        mAdapter = new SearchHistoryRlvAdapter(this, mSearchList);
        serachRlv2.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        super.initListener();
        searchSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = serachInput.getText().toString();
                if (!TextUtils.isEmpty(s)) {
                    mSearchList.add(s);
                    mListDataSave.setDataList(Constants.LIST_SEARCH, mSearchList);
                    ToastUtil.showShort(s);
                    startActivity(new Intent(SerachActivity.this, Main2Activity.class));
                    finish();
                } else {
                    ToastUtil.showShort("请先输入关键字");
                }
            }
        });
    }

    /**
     * 去除重复
     *
     * @param list 搜索历史的数据
     * @return
     */
    private List<String> getRemoveList(List<String> list) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.addAll(list);
        ArrayList<String> strings = new ArrayList<>();
        strings.addAll(set);
        return strings;
    }

    /**
     * 获取搜索历史
     */
    private List<String> getHistorySearch() {
        return mListDataSave.getDataList(Constants.LIST_SEARCH);
    }

    @OnClick({R.id.search_out, R.id.search_empty})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_out:
                finish();
                break;
            case R.id.search_empty:
                mSearchList.clear();
                mAdapter.notifyDataSetChanged();
                getHistorySearchMethod();
                break;
        }
    }
}
