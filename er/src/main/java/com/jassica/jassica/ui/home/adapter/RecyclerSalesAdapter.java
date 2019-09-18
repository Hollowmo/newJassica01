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
import com.jassica.jassica.bean.SalesBean;
import com.jassica.jassica.utils.GlideUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
 * 首页type---Sales
 * */
class RecyclerSalesAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final ArrayList<SalesBean> salesBeans;

    public RecyclerSalesAdapter(Context context, ArrayList<SalesBean> salesBeans) {

        this.context = context;
        this.salesBeans = salesBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerSalesVh(LayoutInflater.from(context).inflate(R.layout.sales_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerSalesVh vh = (RecyclerSalesVh) viewHolder;
        // 商品图片
        GlideUtil.loadImageDefaultPlaceHolder(salesBeans.get(i).getImageSrc(),vh.salesImg,context);
        // 商品名称
        vh.salesTvGoodsName.setText(salesBeans.get(i).getGoodsName());
        // 商品价格
        vh.salesTvPrice.setText(salesBeans.get(i).getAppPrice0()+" THB");
        // 商品RMB 价格
        vh.salesTvRmbprice.setText("{约￥"+salesBeans.get(i).getRmbAppPrice() + "}");
        String extendString5 = salesBeans.get(i).getExtendString5();
        if ( extendString5.equals("") ) {
            vh.salesTvExtendString5.setVisibility(View.GONE);
        } else {
            vh.salesTvExtendString5.setText(salesBeans.get(i).getExtendString5());
        }
    }

    @Override
    public int getItemCount() {
        return salesBeans != null ? salesBeans.size() : 0;
    }

    static class RecyclerSalesVh extends RecyclerView.ViewHolder {
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

        public RecyclerSalesVh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
