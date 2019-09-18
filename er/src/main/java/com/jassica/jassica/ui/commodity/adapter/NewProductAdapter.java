package com.jassica.jassica.ui.commodity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jassica.jassica.R;
import com.jassica.jassica.bean.NewProductBean;
import com.jassica.jassica.ui.commodity.activity.ParticularsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * 热销
 * */
public class NewProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @BindView(R.id.hot_img)
    ImageView mHotImg;
    @BindView(R.id.hot_name)
    TextView mHotName;
    @BindView(R.id.hot_describe)
    TextView mHotDescribe;
    @BindView(R.id.hot_red_price)
    TextView mHotRedPrice;
    @BindView(R.id.hot_price)
    TextView mHotPrice;
    @BindView(R.id.hot_ll)
    LinearLayout mHotLl;
    private Context context;
    private List<NewProductBean.DatasBean.GoodsListBean> list;

    public void setList(List<NewProductBean.DatasBean.GoodsListBean> list) {
        this.list = list;
    }

    public NewProductAdapter(Context context, List<NewProductBean.DatasBean.GoodsListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hot_item, null, false);
        return new HotHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        HotHolder hotHolder = (HotHolder) viewHolder;

        Glide.with(context).load(list.get(i).getImageSrc()).into(hotHolder.hotImg);
        hotHolder.hotName.setText(list.get(i).getBrandName());
        hotHolder.hotDescribe.setText(list.get(i).getGoodsName());
        hotHolder.hotRedPrice.setText(list.get(i).getBatchNumPriceVoList().get(0).getPrice() + " THB");
        hotHolder.hotPrice.setText("(约￥" + list.get(i).getRmbAppPrice() + ")");


        hotHolder.hotLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ParticularsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HotHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hot_ll)
        LinearLayout hotLl;
        @BindView(R.id.hot_img)
        ImageView hotImg;
        @BindView(R.id.hot_name)
        TextView hotName;
        @BindView(R.id.hot_describe)
        TextView hotDescribe;
        @BindView(R.id.hot_red_price)
        TextView hotRedPrice;
        @BindView(R.id.hot_price)
        TextView hotPrice;

        public HotHolder(@io.reactivex.annotations.NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
