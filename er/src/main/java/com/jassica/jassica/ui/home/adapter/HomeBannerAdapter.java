package com.jassica.jassica.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jassica.jassica.R;
import com.jassica.jassica.bean.GoodsBean;
import com.jassica.jassica.bean.HomeBannerBean;
import com.jassica.jassica.bean.ItemDataImage;
import com.jassica.jassica.bean.RateBean;
import com.jassica.jassica.bean.SalesBean;
import com.jassica.jassica.ui.home.activity.BannerShowActivity;
import com.jassica.jassica.ui.home.activity.ExchangeActivity;
import com.jassica.jassica.ui.home.activity.HotBrandItemActivity;
import com.jassica.jassica.ui.me.activity.HelpCententActivity;
import com.jassica.jassica.ui.me.activity.TimeZoneActivity;
import com.jassica.jassica.utils.GlideUtil;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * 首页
 * */
public class HomeBannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<HomeBannerBean.DatasBean.ItemListBean> bannerlist;
    private static final int TYPE_AD = 0;
    private static final int TYPE_TITLE = 1;
    private static final int TYPE_RATE = 2;
    private static final int TYPE_NAV = 3;
    private static final int TYPE_HOME1 = 4;
    private static final int TYPE_COUPONGIFTS = 5;
    private static final int TYPE_SALES = 6;
    private static final int TYPE_DISCOUNT = 7;
    private static final int TYPE_HOTBRAND = 8;
    private static final int TYPE_HOME10 = 9;
    private static final int TYPE_HOME8 = 10;
    private static final int TYPE_HOME3 = 11;
    private static final int TYPE_GOODS = 12;
    private static final int TYPE_NONE = -1;
    private final LayoutInflater inflater;
    private final Gson gson;


    public HomeBannerAdapter(Context context, ArrayList<HomeBannerBean.DatasBean.ItemListBean> bannerlist) {
        this.context = context;
        this.bannerlist = bannerlist;
        inflater = LayoutInflater.from(context);
        gson = new Gson();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemViewType) {
        if (itemViewType == TYPE_AD) {
            View inflate = inflater.inflate(R.layout.banner_home, null);
            return new AdBanner(inflate);
        } else if (itemViewType == TYPE_TITLE) {
            View inflate = inflater.inflate(R.layout.main_item_title, null);
            return new TitleVH(inflate);
        } else if (itemViewType == TYPE_RATE) {
            View inflate = inflater.inflate(R.layout.main_item_rate, null);
            return new RateVH(inflate);
        } else if (itemViewType == TYPE_NAV) {
            View inflate = inflater.inflate(R.layout.main_item_nav_vp, null);
            return new NavVh(inflate);
        } else if (itemViewType == TYPE_HOME1) {
            View inflate = inflater.inflate(R.layout.main_item_home1, null);
            return new Home1VH(inflate);
        } else if (itemViewType == TYPE_COUPONGIFTS) {
            View inflate = inflater.inflate(R.layout.main_item_home1, null);
            return new CoupongiftsVH(inflate);
        } else if (itemViewType == TYPE_SALES) {
            View inflate = inflater.inflate(R.layout.main_item_sales, null);
            return new SalesVH(inflate);
        } else if (itemViewType == TYPE_DISCOUNT) {
            View inflate = inflater.inflate(R.layout.main_item_nav, null);
            return new DiscountVH(inflate);
        } else if (itemViewType == TYPE_HOTBRAND) {
            View inflate = inflater.inflate(R.layout.main_item_sales, null);
            return new HotBrandVH(inflate);
        } else if (itemViewType == TYPE_HOME10) {
            View inflate = inflater.inflate(R.layout.main_item_nav, null);
            return new Home10VH(inflate);
        } else if (itemViewType == TYPE_HOME8) {
            View inflate = inflater.inflate(R.layout.main_item_nav, null);
            return new Home8VH(inflate);
        } else if (itemViewType == TYPE_HOME3) {
            View inflate = inflater.inflate(R.layout.main_item_nav, null);
            return new Home3VH(inflate);
        } else if (itemViewType == TYPE_GOODS) {
            View inflate = inflater.inflate(R.layout.main_item_nav, null);
            return new GoodsVH(inflate);
        } else if (itemViewType == TYPE_NONE) {
            View inflate = inflater.inflate(R.layout.item_none, null);
            return new NoneVh(inflate);
        }
        return null;
    }

    /**
     * @param context
     * @param SpanCount
     * @param recyclerView
     * @param List
     */
    private void setGridLayoutMananger(Context context, int SpanCount, RecyclerView recyclerView, ArrayList<ItemDataImage> List) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, SpanCount));
        RecyclerNavAdapter recyclerNavAdapter = new RecyclerNavAdapter(context, List);
        recyclerView.setAdapter(recyclerNavAdapter);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        int itemViewType = getItemViewType(position);
        String itemData = bannerlist.get(position).getItemData();
        Type type = new TypeToken<ArrayList<ItemDataImage>>() {
        }.getType();
        /**
         *  Ad
         */
        if (itemViewType == TYPE_AD) {
            AdBanner myBanner = (AdBanner) viewHolder;
            ArrayList<ItemDataImage> list = gson.fromJson(itemData, type);
            myBanner.banner_item.setImages(list);
            myBanner.banner_item.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    ItemDataImage bean = (ItemDataImage) path;
                    GlideUtil.loadImage(context.getResources().getDrawable(R.drawable.default_image), bean.getImageUrl(), imageView, context);
                }
            }).start();

            myBanner.banner_item.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Intent intent = new Intent(context, HelpCententActivity.class);
                    context.startActivity(intent);
                }
            });

            /**
             *  Title
             */
        } else if (itemViewType == TYPE_TITLE) {
            TitleVH vh = (TitleVH) viewHolder;
            final ArrayList<ItemDataImage> titleList = gson.fromJson(itemData, type);
            // 标题
            vh.ItemtvText.setText(titleList.get(0).getText());
            // 副标题
            vh.tvSubtext.setText(titleList.get(1).getText() + " >");

            vh.tvSubtext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (titleList.get(0).getText().equals("限时折扣")) {
                        Intent intent = new Intent(context, TimeZoneActivity.class);
                        context.startActivity(intent);
                    }

                }
            });

            /**
             *  Rate
             */
        } else if (itemViewType == TYPE_RATE) {
            RateVH vh = (RateVH) viewHolder;
            RateBean rateBean = gson.fromJson(itemData, RateBean.class);
            if (rateBean != null) {
                GlideUtil.loadImageDefaultPlaceHolder(rateBean.getTargetCountryLogo(), vh.ivChy, context);
                GlideUtil.loadImageDefaultPlaceHolder(rateBean.getOriginalCountryLogo(), vh.ivThb, context);
                // 银联金额
                vh.tvYinlianNumber.setText(rateBean.getUnionPay() + "");
                // 支付宝金额
                vh.tvZfbNumber.setText(rateBean.getAliPay() + "");
                // 微信金额
                vh.tvWechatNumber.setText(rateBean.getWx() + "");

                vh.rate_ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ExchangeActivity.class);
                        context.startActivity(intent);
                    }
                });
            }
            /**
             *  Nav
             */
        } else if (itemViewType == TYPE_NAV) {
            NavVh vh = (NavVh) viewHolder;
            ArrayList<ItemDataImage> NavList = gson.fromJson(itemData, type);
//            setGridLayoutMananger(context, 5, vh.rlNav, NavList);
            vh.itenNavVp.setAdapter(new NavVpAdapter(context, NavList));


            /**
             *  Home1
             */
        } else if (itemViewType == TYPE_HOME1) {
            Home1VH vh = (Home1VH) viewHolder;
            ArrayList<ItemDataImage> home1List = gson.fromJson(itemData, type);
            if (home1List != null && home1List.size() > 0) {
                GlideUtil.loadImageDefaultPlaceHolder(home1List.get(0).getImageUrl(), vh.ItemImg, context);
            }

            /**
             *  Coupongifts
             */
        } else if (itemViewType == TYPE_COUPONGIFTS) {
            CoupongiftsVH vh = (CoupongiftsVH) viewHolder;
            ArrayList<ItemDataImage> coupongifitsList = gson.fromJson(itemData, type);
            if (coupongifitsList != null && coupongifitsList.size() > 0) {
                GlideUtil.loadImageDefaultPlaceHolder(coupongifitsList.get(0).getImageUrl(), vh.ItemImg, context);
            }
            /**
             *  Sales
             */
        } else if (itemViewType == TYPE_SALES) {
            SalesVH vh = (SalesVH) viewHolder;
            ArrayList<ItemDataImage> salesList = gson.fromJson(itemData, type);
            if (salesList != null && salesList.size() > 0) {
                String goodsData = salesList.get(0).getGoodsData();
                GlideUtil.loadImageDefaultPlaceHolder(salesList.get(0).getImageUrl(), vh.salesItemImg, context);
                Type type1 = new TypeToken<ArrayList<SalesBean>>() {
                }.getType();
                ArrayList<SalesBean> salesBeans = gson.fromJson(goodsData, type1);
                vh.recyclerSales.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                RecyclerSalesAdapter recyclerSalesAdapter = new RecyclerSalesAdapter(context, salesBeans);
                vh.recyclerSales.setAdapter(recyclerSalesAdapter);
                recyclerSalesAdapter.notifyDataSetChanged();
            }

            /**
             *  Discount
             */
        } else if (itemViewType == TYPE_DISCOUNT) {
            DiscountVH vh = (DiscountVH) viewHolder;
            ArrayList<ItemDataImage> discountList = gson.fromJson(itemData, type);
            Type type1 = new TypeToken<ArrayList<SalesBean>>() {
            }.getType();
            ArrayList<SalesBean> salesBeans = gson.fromJson(discountList.get(0).getGoodsData(), type1);
            vh.rlNav.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            RecyclerSalesAdapter recyclerSalesAdapter = new RecyclerSalesAdapter(context, salesBeans);
            vh.rlNav.setAdapter(recyclerSalesAdapter);
            recyclerSalesAdapter.notifyDataSetChanged();

            /**
             *  Hotbrand
             */
        } else if (itemViewType == TYPE_HOTBRAND) {
            HotBrandVH vh = (HotBrandVH) viewHolder;
            ArrayList<ItemDataImage> hotBrandList = gson.fromJson(itemData, type);
            String goodsData = hotBrandList.get(0).getGoodsData();
            GlideUtil.loadImageDefaultPlaceHolder(hotBrandList.get(0).getImageUrl(), vh.salesItemImg, context);
            Type type1 = new TypeToken<ArrayList<SalesBean>>() {
            }.getType();
            ArrayList<SalesBean> salesBeans = gson.fromJson(goodsData, type1);
            vh.recyclerSales.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            RecyclerSalesAdapter recyclerSalesAdapter = new RecyclerSalesAdapter(context, salesBeans);
            vh.recyclerSales.setAdapter(recyclerSalesAdapter);
            recyclerSalesAdapter.notifyDataSetChanged();
            /**
             *  Home10
             */
        } else if (itemViewType == TYPE_HOME10) {
            Home10VH vh = (Home10VH) viewHolder;
            ArrayList<ItemDataImage> home10List = gson.fromJson(itemData, type);
            setGridLayoutMananger(context, 4, vh.rlNav, home10List);
            /**
             *  Home8
             */
        } else if (itemViewType == TYPE_HOME8) {
            Home8VH vh = (Home8VH) viewHolder;
            ArrayList<ItemDataImage> home10List = gson.fromJson(itemData, type);
            setGridLayoutMananger(context, 5, vh.rlNav, home10List);
            /**
             *  Home3
             */
        } else if (itemViewType == TYPE_HOME3) {
            Home3VH vh = (Home3VH) viewHolder;
            ArrayList<ItemDataImage> home3List = gson.fromJson(itemData, type);
            vh.rlNav.setLayoutManager(new GridLayoutManager(context, 2));
            RecyclerHome3Adapter recyclerHome3Adapter = new RecyclerHome3Adapter(context, home3List);
            vh.rlNav.setAdapter(recyclerHome3Adapter);

            /**
             *  Home5
             */
        } else if (itemViewType == TYPE_GOODS) {
            GoodsVH vh = (GoodsVH) viewHolder;
            Type type1 = new TypeToken<ArrayList<GoodsBean>>() {
            }.getType();
            ArrayList<GoodsBean> goodsList = gson.fromJson(itemData, type1);
            if (goodsList != null && goodsList.size() > 0) {
                vh.rlNav.setLayoutManager(new GridLayoutManager(context, 2));
                RecyclerGoodsAdapter recyclerGoodsAdapter = new RecyclerGoodsAdapter(context, goodsList);
                vh.rlNav.setAdapter(recyclerGoodsAdapter);
            }

        } else if (itemViewType == TYPE_NONE) {

        }

    }

    @Override
    public int getItemCount() {
        return bannerlist.size();
    }

    @Override
    public int getItemViewType(int position) {
        String itemType = bannerlist.get(position).getItemType();
        if ("ad".equalsIgnoreCase(itemType)) {
            return TYPE_AD;
        } else if ("title".equalsIgnoreCase(itemType)) {
            return TYPE_TITLE;
        } else if ("rate".equalsIgnoreCase(itemType)) {
            return TYPE_RATE;
        } else if ("nav".equalsIgnoreCase(itemType)) {
            return TYPE_NAV;
        } else if ("home1".equalsIgnoreCase(itemType)) {
            return TYPE_HOME1;
        } else if ("coupongifts".equalsIgnoreCase(itemType)) {
            return TYPE_COUPONGIFTS;
        } else if ("sales".equalsIgnoreCase(itemType)) {
            return TYPE_SALES;
        } else if ("discount".equalsIgnoreCase(itemType)) {
            return TYPE_DISCOUNT;
        } else if ("hotbrand".equalsIgnoreCase(itemType)) {
            return TYPE_HOTBRAND;
        } else if ("home10".equalsIgnoreCase(itemType)) {
            return TYPE_HOME10;
        } else if ("home8".equalsIgnoreCase(itemType)) {
            return TYPE_HOME8;
        } else if ("home3".equalsIgnoreCase(itemType)) {
            return TYPE_HOME3;
        } else if ("goods".equalsIgnoreCase(itemType)) {
            return TYPE_GOODS;
        } else {
            return TYPE_NONE;
        }
    }

//    =====================================找控件===============================================

    static class AdBanner extends RecyclerView.ViewHolder {
        Banner banner_item;

        AdBanner(@NonNull View itemView) {
            super(itemView);
            banner_item = itemView.findViewById(R.id.banner);
        }
    }

    static class TitleVH extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv_title)
        TextView ItemtvText;
        @BindView(R.id.tv_subtext)
        TextView tvSubtext;
        @BindView(R.id.title_rlv)
        RelativeLayout title_rlv;

        TitleVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class RateVH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_thb)
        ImageView ivThb;
        @BindView(R.id.home_taiguo)
        TextView homeTaiguo;
        @BindView(R.id.rl_thb)
        RelativeLayout rlThb;
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.iv_chy)
        ImageView ivChy;
        @BindView(R.id.home_chain)
        TextView homeChain;
        @BindView(R.id.tv_yinlian)
        TextView tvYinlian;
        @BindView(R.id.tv_yinlian_number)
        TextView tvYinlianNumber;
        @BindView(R.id.tv_zfb)
        TextView tvZfb;
        @BindView(R.id.tv_zfb_number)
        TextView tvZfbNumber;
        @BindView(R.id.tv_wechat)
        TextView tvWechat;
        @BindView(R.id.tv_wechat_number)
        TextView tvWechatNumber;
        @BindView(R.id.rate_ll)
        LinearLayout rate_ll;

        RateVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //自定义导航模块
    static class NavVh extends RecyclerView.ViewHolder {
        @BindView(R.id.nav_rl)
        RelativeLayout navRl;
        @BindView(R.id.item_nav_vp)
        ViewPager itenNavVp;

        NavVh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class Home1VH extends RecyclerView.ViewHolder {
        @BindView(R.id.home1_rl)
        RelativeLayout Home1Rl;
        @BindView(R.id.item_img)
        ImageView ItemImg;

        Home1VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class CoupongiftsVH extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView ItemImg;

        CoupongiftsVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class SalesVH extends RecyclerView.ViewHolder {
        @BindView(R.id.sales_item_img)
        ImageView salesItemImg;
        @BindView(R.id.recycler_sales)
        RecyclerView recyclerSales;

        SalesVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class DiscountVH extends RecyclerView.ViewHolder {
        @BindView(R.id.rl_nav)
        RecyclerView rlNav;

        DiscountVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class HotBrandVH extends RecyclerView.ViewHolder {
        @BindView(R.id.sales_rl)
        RelativeLayout salesRl;
        @BindView(R.id.sales_item_img)
        ImageView salesItemImg;
        @BindView(R.id.recycler_sales)
        RecyclerView recyclerSales;

        HotBrandVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class Home10VH extends RecyclerView.ViewHolder {
        @BindView(R.id.rl_nav)
        RecyclerView rlNav;

        Home10VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class Home8VH extends RecyclerView.ViewHolder {
        @BindView(R.id.rl_nav)
        RecyclerView rlNav;

        Home8VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class Home3VH extends RecyclerView.ViewHolder {
        @BindView(R.id.rl_nav)
        RecyclerView rlNav;

        Home3VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class GoodsVH extends RecyclerView.ViewHolder {
        @BindView(R.id.goods_rl)
        RelativeLayout goodRl;
        @BindView(R.id.rl_nav)
        RecyclerView rlNav;

        GoodsVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class NoneVh extends RecyclerView.ViewHolder {
        NoneVh(@NonNull View itemView) {
            super(itemView);
        }
    }
}
