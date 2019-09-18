package com.jassica.jassica.ui.classify.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.ClassifyBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NegativeRightFragmentAdapter extends RecyclerView.Adapter  {
    private Context mContext;
    private ArrayList<ClassifyBean.DatasBean.CategoryListBeanXX.CategoryListBeanX> list;

    public NegativeRightFragmentAdapter(Context context, ArrayList<ClassifyBean.DatasBean.CategoryListBeanXX.CategoryListBeanX> list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_navigation_right_rlv, null, false);
        return new NegativeRight(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        NegativeRight vh = (NegativeRight) viewHolder;
        String categoryName = list.get(position).getCategoryName();
        vh.mTextView.setText(categoryName);
        vh.mFlawLayout.setLayoutManager(new GridLayoutManager(mContext,3));
        List<ClassifyBean.DatasBean.CategoryListBeanXX.CategoryListBeanX.CategoryListBean> categoryList = list.get(position).getCategoryList();
        if (categoryList != null && categoryList.size() > 0) {
            NegativeTagFragmentAdapter adapter = new NegativeTagFragmentAdapter(mContext, categoryList);
            vh.mFlawLayout.setAdapter(adapter);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     static class NegativeRight extends RecyclerView.ViewHolder {
        @BindView(R.id.item_categoryname)
        TextView mTextView;
        @BindView(R.id.tag_flow_layout)
        RecyclerView mFlawLayout;

          NegativeRight(@NonNull View itemView) {
            super(itemView);
              ButterKnife.bind(this, itemView);
        }
    }
}
