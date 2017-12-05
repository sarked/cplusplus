package com.example.sarked.catalog;

import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //для работающего:
        setContentView(R.layout.activity_info);
        //для вьюпейджера:
        //setContentView(R.layout.pager);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //проблема в том, что не знаю откуда взаимодействовать с элементами. Они сами находятся во фрагменте PageFragment, Интент передается сюда, в InfoActivity, а многостраничность задается вообще в InfoPageAdapter, кстати, как туда передать список, чтобы ограничить количество страниц

// дальше эксперимент
//        ViewPager a = (ViewPager)findViewById(R.id.pager);
//        InfoPagerAdapter pagerAdapter=new InfoPagerAdapter(getSupportFragmentManager());
//        a.setAdapter(pagerAdapter);

        //дальше рабочее
        TextView title = (TextView)findViewById(R.id.info_name);
        TextView descr = (TextView)findViewById(R.id.info_description);
        ImageView img = (ImageView)findViewById(R.id.info_img);
//
        Bundle data=getIntent().getExtras();
        Goods good = (Goods)  getIntent().getSerializableExtra("item");
        Collection collection = (Collection) getIntent().getSerializableExtra("collection");


        title.setText(good.title);
        descr.setText(data.getString("descr"));
        img.setImageResource(good.icon);
    }

//    public void swapPage (Goods good, Bundle data){
//        FragmentManager fm = getSupportFragmentManager();
//        PageFragment fragment = (PageFragment) fm.findFragmentById(R.id.pager);
//        fragment.swapPage(good,data);
//    }
}
