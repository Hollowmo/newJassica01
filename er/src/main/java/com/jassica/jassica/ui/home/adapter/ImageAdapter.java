package com.jassica.jassica.ui.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.HomeBannerBean;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<HomeBannerBean.DatasBean.ItemListBean> imagelist;

    public ImageAdapter(Context context, ArrayList<HomeBannerBean.DatasBean.ItemListBean> imagelist) {
        this.context = context;
        this.imagelist = imagelist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        RecyclerView.ViewHolder holder = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_none, null);
        holder = new ImageAdapter.MyImage(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if(itemViewType==1){
            MyImage myImage = (MyImage) viewHolder;
            
        }
    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    public class MyImage extends RecyclerView.ViewHolder {
        private ImageView image1;
        private ImageView image2;
        private ImageView image3;
        private ImageView image4;
        private ImageView image5;

        public MyImage(@NonNull View itemView) {
            super(itemView);

        }
    }

}
