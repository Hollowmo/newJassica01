package com.jassica.jassica.ui.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.SerachBean;
import com.jassica.jassica.utils.ToastUtil;
import com.jassica.jassica.widget.FlowLayout;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SerachAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SerachBean.DatasBean.KeywordListBean> list;
    private Context context;

    public SerachAdapter(List<SerachBean.DatasBean.KeywordListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RlvItem(LayoutInflater.from(context).inflate(R.layout.serach_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RlvItem rlvItem = (RlvItem) holder;
        // 清空 fl 里的数据，不然会把其他集合里的数据添加进来
        rlvItem.fl.removeAllViews();
        //获取视图,视图可以自定义,可以添加自己想要的效果
        TextView label = (TextView) View.inflate(context, R.layout.city_item, null);
        //获取数据
        final String hotName = list.get(position).getHotName();
        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(hotName);
            }
        });
        //绑定数据
        label.setText(hotName);
        rlvItem.fl.addView(label);
        //加到容器中,parent是FlowLayout
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class RlvItem extends RecyclerView.ViewHolder {
        @BindView(R.id.fl)
        FlowLayout fl;

        RlvItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
