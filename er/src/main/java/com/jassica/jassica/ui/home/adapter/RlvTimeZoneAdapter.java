package com.jassica.jassica.ui.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.TimeZoneBean;
import com.jassica.jassica.utils.GlideUtil;
import com.jassica.jassica.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvTimeZoneAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final ArrayList<TimeZoneBean.DatasBean.GoodsListBean> goodsListBeans;

    public RlvTimeZoneAdapter(Context context, ArrayList<TimeZoneBean.DatasBean.GoodsListBean> goodsListBeans) {
        this.context = context;
        this.goodsListBeans = goodsListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RlvTimeZoneViewHolder(LayoutInflater.from(context).inflate(R.layout.item_timezone, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        RlvTimeZoneViewHolder vh = (RlvTimeZoneViewHolder) viewHolder;
        TimeZoneBean.DatasBean.GoodsListBean goodsListBean = goodsListBeans.get(i);
        // 商品图片
        GlideUtil.loadImage(context.getResources().getDrawable(R.drawable.default_image),goodsListBean.getImageSrc(),vh.itemTimezoneImg,context);
        // 商品名称
        vh.itemTimezoneGoodname.setText(goodsListBean.getGoodsName());
        vh.itemTimezoneBrandname.setText(goodsListBean.getBrandName());

        if (goodsListBean.getPromotionTypeText().equals("")) {
            vh.itemTimezoneTvPromotionTypeText.setVisibility(View.INVISIBLE);
        } else {
            vh.itemTimezoneTvPromotionTypeText.setText(goodsListBean.getPromotionTypeText());
        }
        // 商品 THB 价格
        vh.itemTimezoneTvAppPrice.setText(String.valueOf(Double.valueOf(goodsListBean.getAppPrice0()))+ " THB");
        // 商品 rmb 价格
        vh.itemTimezoneTvRmbPrice.setText("( 约 ￥" + goodsListBean.getRmbAppPrice() + ")");
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showShort(i+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsListBeans.size() != 0 ? goodsListBeans.size() : 0;
    }

    static class RlvTimeZoneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_timezone_img)
        ImageView itemTimezoneImg;
        @BindView(R.id.rl_timezone)
        RelativeLayout rlTimezone;
        @BindView(R.id.item_timezone_tv_promotionTypeText)
        TextView itemTimezoneTvPromotionTypeText;
        @BindView(R.id.item_timezone_goodname)
        TextView itemTimezoneGoodname;
        @BindView(R.id.item_timezone_brandname)
        TextView itemTimezoneBrandname;
        @BindView(R.id.item_timezone_tv_app_price)
        TextView itemTimezoneTvAppPrice;
        @BindView(R.id.item_timezone_tv_rmb_price)
        TextView itemTimezoneTvRmbPrice;

          RlvTimeZoneViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
