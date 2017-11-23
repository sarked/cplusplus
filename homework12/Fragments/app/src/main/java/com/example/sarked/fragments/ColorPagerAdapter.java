package com.example.sarked.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;



//наследуем FragmentPagerAdapter - в памяти хранятся только левый и правы объект
//наследуем FragmentStatePagerAdapter - в памяти хранятся все объекты
//на самом деле нет конкретно в этом случае (знай разницу между адаптерами)
public class ColorPagerAdapter extends FragmentStatePagerAdapter {
    public ColorPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ColorFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public String getPageTitle(int position){
        return "Color#"+position;
    }
}
