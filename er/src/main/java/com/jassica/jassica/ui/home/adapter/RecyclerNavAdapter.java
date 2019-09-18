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

class RecyclerNavAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final ArrayList<ItemDataImage> navList;

    public RecyclerNavAdapter(Context context, ArrayList<ItemDataImage> navList) {
        this.context = context;
        this.navList = navList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerNavVh(LayoutInflater.from(context).inflate(R.layout.nav_item_img,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RecyclerNavVh vh = (RecyclerNavVh) viewHolder;
        GlideUtil.loadImageDefaultPlaceHolder(navList.get(i).getImageUrl(),vh.navImg,context);
    }

    @Override
    public int getItemCount() {
        return navList !=null ? navList.size() : 0;
    }

    static class RecyclerNavVh extends RecyclerView.ViewHolder {
        @BindView(R.id.nav_img)
        ImageView navImg;

          RecyclerNavVh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
