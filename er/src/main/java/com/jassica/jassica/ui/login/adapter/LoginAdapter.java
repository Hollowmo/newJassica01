package com.jassica.jassica.ui.login.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class LoginAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> list;
    private ArrayList<String> string;

    public LoginAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> string) {
        super(fm);
        this.list = list;
        this.string = string;
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
        return string.get(position);
    }
}
