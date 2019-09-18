package com.jassica.jassica.ui.commodity.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ParticularsAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> mStrings;

    public ParticularsAdapter(FragmentManager fm, ArrayList<Fragment> list,ArrayList<String> mStrings) {
        super(fm);
        this.list = list;
        this.mStrings = mStrings;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStrings.get(position);
    }
}
