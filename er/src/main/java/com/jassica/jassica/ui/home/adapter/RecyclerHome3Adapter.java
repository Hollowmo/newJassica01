package com.jassica.jassica.ui.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.ItemDataImage;
import com.jassica.jassica.utils.GlideUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

class RecyclerHome3Adapter extends RecyclerView.Adapter {
    private final Context context;
    private final ArrayList<ItemDataImage> home3List;

    public RecyclerHome3Adapter(Context context, ArrayList<ItemDataImage> home3List) {
        this.context = context;
        this.home3List = home3List;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerHome3ViewHolder(LayoutInflater.from(context).inflate(R.layout.home3_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerHome3ViewHolder viewHolder1 = (RecyclerHome3ViewHolder) viewHolder;
        GlideUtil.loadImageDefaultPlaceHolder(home3List.get(i).getImageUrl(),viewHolder1.home3Iv,context);
    }

    @Override
    public int getItemCount() {
        return home3List !=null ? home3List.size() : 0;
    }

    static class RecyclerHome3ViewHolder  extends RecyclerView.ViewHolder {
        @BindView(R.id.home3_iv)
        ImageView home3Iv;
        public RecyclerHome3ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
