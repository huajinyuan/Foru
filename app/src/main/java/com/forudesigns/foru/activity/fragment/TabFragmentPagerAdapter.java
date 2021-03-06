package com.forudesigns.foru.activity.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;

    public TabFragmentPagerAdapter(FragmentManager fm,
                                   List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return position + "";
    }

    @Override
    public int getCount() {
        return data.size();
    }


}
