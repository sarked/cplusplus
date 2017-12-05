package com.example.sarked.catalog;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

import com.example.sarked.catalog.PageFragment;

public class InfoPagerAdapter extends FragmentStatePagerAdapter {
    public InfoPagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new PageFragment();

    }

    @Override
    public int getCount() {
        return 6;
    }
}
