package com.jassica.jassica.ui.classify.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.ClassifyBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NegativeTagFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<ClassifyBean.DatasBean.CategoryListBeanXX.CategoryListBeanX.CategoryListBean> list;

    public NegativeTagFragmentAdapter(Context context, List<ClassifyBean.DatasBean.CategoryListBeanXX.CategoryListBeanX.CategoryListBean> list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_tag_layout, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder) viewHolder;
        vh.mTagText.setText(list.get(i).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tag_text)
        TextView mTagText;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
