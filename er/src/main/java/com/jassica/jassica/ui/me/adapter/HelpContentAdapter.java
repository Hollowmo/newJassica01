package com.jassica.jassica.ui.me.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.HelpContentBean;
import com.jassica.jassica.ui.me.activity.HelpCententActivity;

import java.util.ArrayList;
import java.util.List;

public class HelpContentAdapter extends RecyclerView.Adapter<HelpContentAdapter.ViewHolder> {
     List<HelpContentBean.DatasBean.DataListBean> list;
     Context context;

    public HelpContentAdapter(List<HelpContentBean.DatasBean.DataListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.help_content_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        viewHolder.help_tv.setText(list.get(position).getTitle());
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView help_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            help_tv = itemView.findViewById(R.id.help_tv);
        }
    }
}
