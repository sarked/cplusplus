package com.example.sarked.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    //1
    public static MainActivity self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2
        self=this;

        ViewPager a = (ViewPager)findViewById(R.id.color);
        ColorPagerAdapter adapter=new ColorPagerAdapter(getSupportFragmentManager());
        a.setAdapter(adapter);
    }
//
//    //метод открытия статьи по нажатию
//    public void openArticle (int position){
//
//        FragmentManager fm = getSupportFragmentManager();
//        ArticleNewsFragment fragment = (ArticleNewsFragment)fm.findFragmentById(R.id.fragmenttxt);
//        fragment.openArticle(position);
//    }


}
