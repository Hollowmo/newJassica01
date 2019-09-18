package com.jassica.jassica.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.widget.FlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

public class SearchHistoryRlvAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<String> mSearchList;

    public SearchHistoryRlvAdapter(Context context, ArrayList<String> searchList) {

        mContext = context;
        mSearchList = searchList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.serach_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.fl.removeAllViews();
        TextView label = (TextView) View.inflate(mContext, R.layout.city_item, null);
        label.setText(mSearchList.get(i));
        // 监听方法
        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.fl.addView(label);
    }

    @Override
    public int getItemCount() {
        return mSearchList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fl)
        FlowLayout fl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
