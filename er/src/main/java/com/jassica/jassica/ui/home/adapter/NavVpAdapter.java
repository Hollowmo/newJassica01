package com.jassica.jassica.ui.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.ItemDataImage;

import java.util.ArrayList;

class NavVpAdapter extends PagerAdapter {
    private final Context context;
    private final ArrayList<ItemDataImage> navList;

    public NavVpAdapter(Context context, ArrayList<ItemDataImage> navList) {
        this.context = context;
        this.navList = navList;
    }

    @Override
    public int getCount() {
        int count = navList.size() % 10;
        int driver = navList.size() / 10;
        return count == 0 ? driver : driver + 1;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.main_item_nav, null);
        RecyclerView rlNav = inflate.findViewById(R.id.rl_nav);
        rlNav.setLayoutManager(new GridLayoutManager(context, 5, LinearLayoutManager.VERTICAL, false));
        ArrayList<ItemDataImage> list = new ArrayList<>();
        //每页最多显示6个，小于数据集总数，且小于下一页开始的位置索引
        for (int i = position * 10; i < (position + 1) * 10 && i < navList.size(); i++) {
            list.add(navList.get(i));
        }
        RecyclerNavAdapter masterRlvAdpater = new RecyclerNavAdapter(context, list);
        rlNav.setAdapter(masterRlvAdpater);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
