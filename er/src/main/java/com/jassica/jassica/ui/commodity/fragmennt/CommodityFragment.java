package com.jassica.jassica.ui.commodity.fragmennt;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.api.Api;
import com.jassica.jassica.base.BaseFragment;
import com.jassica.jassica.bean.ScreenBean;
import com.jassica.jassica.mvp.prestent.CommodityPrestent;
import com.jassica.jassica.mvp.view.CommodityView;
import com.jassica.jassica.ui.commodity.adapter.BrandAdapter;
import com.jassica.jassica.ui.commodity.adapter.ClassifyRlvAdapter;
import com.jassica.jassica.ui.commodity.adapter.DiscountsRlvAdapter;
import com.jassica.jassica.ui.home.activity.SerachActivity;
import com.jassica.jassica.utils.TabIndicatorWidthUtil;
import com.jassica.jassica.widget.CustomViewPager;

import java.util.ArrayList;
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

/**
 * 全部商品
 */
public class CommodityFragment extends BaseFragment<CommodityView, CommodityPrestent> implements CommodityView {


    @BindView(R.id.serach_input)
    LinearLayout serachInput;
    @BindView(R.id.tob)
    Toolbar tob;
    @BindView(R.id.commodity_tabl)
    TabLayout commodityTabl;
    @BindView(R.id.commodity_vp)
    CustomViewPager commodityVp;
    @BindView(R.id.commodity_ll)
    LinearLayout commodityLl;

    private EditText mMpopMinPrice;
    private EditText mMPopMaxPrice;
    private TextView mMPopAllBrand;
    private RecyclerView mMPopBrandRlv;
    private RecyclerView mMPopClassifyRlv;
    private RecyclerView mMPopDiscountsRlv;
    private Button mMPopBtnReset;
    private Button mMPopBtnYes;
    private EditText mMPopMinPrice;
    private View mInflate;
    private String[] tabList = new String[]{"热销", "价格", "新品", "筛选"};
    private ArrayList<Fragment> fragments;
    private Toolbar supportActionBar;
    private PopupWindow mPopupWindow;
    private int mLastPosition;
    private ArrayList<ScreenBean.DatasBean.BrandMapBean> mBrandMapBeans;
    private ArrayList<ScreenBean.DatasBean.CategoryMap1Bean> mCategoryMap1Beans;
    private ArrayList<ScreenBean.DatasBean.PromotionMapBean> mPromotionMapBeans;
    private BrandAdapter mBrandAdapter;
    private ClassifyRlvAdapter mCategoryMap1Adapter;
    private DiscountsRlvAdapter mDiscountsRlvAdapter;

    @Override
    protected CommodityPrestent initPresenter() {
        return new CommodityPrestent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_commodity;
    }

    @Override
    protected void initView() {
        super.initView();
        initFragment();
        TabIndicatorWidthUtil.modifyTabIndicatorWidth(commodityTabl, 0, 0);
        tob.setTitle("");
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HotMeltFragment());//热销
        fragments.add(new PriceFragment());//价格
        fragments.add(new NewProductFragment());//新品

        commodityVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        //这里不能自动关联
        //commodityTabl.setupWithViewPager(commodityVp);
        for (int i = 0; i < tabList.length; i++) {
            commodityTabl.addTab(commodityTabl.newTab().setText(tabList[i]));
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.shaiselect_tab, null);
        TextView tvShuaiSelect = inflate.findViewById(R.id.tv_shaiselect);
        tvShuaiSelect.setText(tabList[3]);
        commodityTabl.getTabAt(3).setCustomView(inflate);

        commodityTabl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == tabList.length - 1) {
                    popupWindow();
                    //避免点击筛选的时候选中对应tab
                    commodityTabl.getTabAt(mLastPosition).select();
                } else {
                    commodityVp.setCurrentItem(position);
                    //上一个碎片
                    mLastPosition = position;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        commodityVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                commodityTabl.getTabAt(i).select();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void popupWindow() {
        if(mPopupWindow == null){
            mPopupWindow = new PopupWindow();
            mInflate = LayoutInflater.from(getContext()).inflate(R.layout.pop_item, null);
            mPopupWindow.setContentView(mInflate);
            mPopupWindow = new PopupWindow(mInflate,ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            PopBrandRlv();
            PopClassifyRlv();
            PopDiscountsRlv();
            //显示之前设置
            mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setAnimationStyle(R.style.anim_pop);
            mInflate.findViewById(R.id.pop_view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPopupWindow.dismiss();
                }
            });
        }

        mPopupWindow.showAtLocation(commodityTabl, Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    private void PopDiscountsRlv() {
        mMPopDiscountsRlv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mPromotionMapBeans = new ArrayList<>();
        mDiscountsRlvAdapter = new DiscountsRlvAdapter(getContext(), mPromotionMapBeans);
        mMPopDiscountsRlv.setAdapter(mDiscountsRlvAdapter);
        initDiscountsData();
    }

    private void initDiscountsData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.NAVIGATION_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<ScreenBean> data = api.getScreenData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ScreenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ScreenBean bean) {
                        ScreenBean.DatasBean.PromotionMapBean promotionMap = bean.getDatas().getPromotionMap();
                        mPromotionMapBeans.add(promotionMap);
                        mDiscountsRlvAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void PopClassifyRlv() {
        mMPopClassifyRlv.setLayoutManager(new GridLayoutManager(getContext(),3));
        mCategoryMap1Beans = new ArrayList<>();
        mCategoryMap1Adapter = new ClassifyRlvAdapter(getContext(), mCategoryMap1Beans);
        mMPopClassifyRlv.setAdapter(mCategoryMap1Adapter);
        initClassifyData();
    }

    private void initClassifyData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.NAVIGATION_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<ScreenBean> data = api.getScreenData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ScreenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ScreenBean bean) {
                        List<ScreenBean.DatasBean.CategoryMap1Bean> brandMap = bean.getDatas().getCategoryMap1();
                        mCategoryMap1Beans.addAll(brandMap);
                        mCategoryMap1Adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @SuppressLint("CutPasteId")
    private void PopBrandRlv() {
        mMpopMinPrice = mInflate.findViewById(R.id.pop_min_price);
        mMPopMaxPrice = mInflate.findViewById(R.id.pop_max_price);
        mMPopAllBrand = mInflate.findViewById(R.id.pop_all_brand);
        mMPopBrandRlv = mInflate.findViewById(R.id.pop_brand_rlv);
        mMPopClassifyRlv = mInflate.findViewById(R.id.pop_classify_rlv);
        mMPopDiscountsRlv = mInflate.findViewById(R.id.pop_discounts_rlv);
        mMPopBtnReset = mInflate.findViewById(R.id.pop_btn_reset);
        mMPopBtnYes = mInflate.findViewById(R.id.pop_btn_yes);
        mMPopMinPrice = mInflate.findViewById(R.id.pop_min_price);

        mMPopBrandRlv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mBrandMapBeans = new ArrayList<>();
        mBrandAdapter = new BrandAdapter(getContext(), mBrandMapBeans);
        mMPopBrandRlv.setAdapter(mBrandAdapter);
        initBrandData();
    }

    private void initBrandData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.NAVIGATION_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<ScreenBean> data = api.getScreenData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ScreenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ScreenBean bean) {
                        List<ScreenBean.DatasBean.BrandMapBean> brandMap = bean.getDatas().getBrandMap();
                        mBrandMapBeans.addAll(brandMap);
                        mBrandAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @OnClick(R.id.serach_input)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), SerachActivity.class);
        startActivity(intent);
    }
}
