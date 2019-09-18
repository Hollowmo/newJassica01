package com.jassica.jassica.ui.commodity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.ScreenBean;
import com.jassica.jassica.widget.FlowLayout;

import java.util.List;

public class DiscountsRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<ScreenBean.DatasBean.PromotionMapBean> mBrandMapBeans;

    public DiscountsRlvAdapter(Context context, List<ScreenBean.DatasBean.PromotionMapBean> brandMapBeans) {
        mContext = context;
        mBrandMapBeans = brandMapBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.brand_item, null, false);
        return new BrandViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        BrandViewHolder brandViewHolder = (BrandViewHolder) viewHolder;
        // 清空 fl 里的数据，不然会把其他集合里的数据添加进来
        brandViewHolder.fl.removeAllViews();;
        //获取视图,视图可以自定义,可以添加自己想要的效果
        TextView label = (TextView) View.inflate(mContext, R.layout.city_item, null);
//        TextView mTv_hotCity1 = label.findViewById(R.id.mTv_hotCity1);
//        TextView mTv_hotCity2 = label.findViewById(R.id.mTv_hotCity2);
//        TextView mTv_hotCity3 = label.findViewById(R.id.mTv_hotCity3);
        //获取数据
        ScreenBean.DatasBean.PromotionMapBean Coupon = mBrandMapBeans.get(position);
        String coupon = Coupon.getCoupon();
        String isgift = Coupon.getIsGift();
        String monthpromotion = Coupon.getMonthPromotion();
        //绑定数据
        label.setText(coupon);
        label.setText(isgift);
        label.setText(monthpromotion);

        // 监听方法
        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //加到容器中,parent是FlowLayout
        brandViewHolder.fl.addView(label);

    }

    @Override
    public int getItemCount() {
        return mBrandMapBeans.size();
    }

    class BrandViewHolder extends RecyclerView.ViewHolder {
        FlowLayout fl;

        public BrandViewHolder(@NonNull View itemView) {
            super(itemView);
            fl = itemView.findViewById(R.id.brand_rlv);
        }
    }
}
