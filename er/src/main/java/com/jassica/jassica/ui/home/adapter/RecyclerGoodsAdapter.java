package com.jassica.jassica.ui.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.GoodsBean;
import com.jassica.jassica.utils.GlideUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
* 首页type---Goods
* */
class RecyclerGoodsAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final ArrayList<GoodsBean> goodList;

    public RecyclerGoodsAdapter(Context context, ArrayList<GoodsBean> goodList) {

        this.context = context;
        this.goodList = goodList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerGoodsViewHolder(LayoutInflater.from(context).inflate(R.layout.sales_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerGoodsViewHolder vh = (RecyclerGoodsViewHolder) viewHolder;
        // 商品图片
        GlideUtil.loadImageDefaultPlaceHolder(goodList.get(i).getImageUrl(),vh.salesImg,context);
        // 商品名称
        vh.salesTvGoodsName.setText(goodList.get(i).getGoodsName());
        // 商品价格
        vh.salesTvPrice.setText(goodList.get(i).getGoodsPrice()+" THB");
        // 商品RMB 价格
        vh.salesTvRmbprice.setText("{约￥"+goodList.get(i).getRmbAppPrice() + "}");
        String extendString5 = goodList.get(i).getExtendString5();
        if ( extendString5.equals("") ) {
            vh.salesTvExtendString5.setVisibility(View.INVISIBLE);
        } else {
            vh.salesTvExtendString5.setText(goodList.get(i).getExtendString5());
        }

    }

    @Override
    public int getItemCount() {
        return goodList !=null ? goodList.size() :0;
    }

    static class RecyclerGoodsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sales_img)
        ImageView salesImg;

        @BindView(R.id.sales_tv_goodsName)
        TextView salesTvGoodsName;
        @BindView(R.id.sales_tv_price)
        TextView salesTvPrice;
        @BindView(R.id.sales_tv_rmbprice)
        TextView salesTvRmbprice;
        @BindView(R.id.sales_tv_extendString5)
        TextView salesTvExtendString5;

         RecyclerGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
