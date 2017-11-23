package com.example.sarked.fragments;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //1
    public static MainActivity self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2
        self=this;

        //часть для задачи с цветами
//        ViewPager a = (ViewPager)findViewById(R.id.color);
//        ColorPagerAdapter adapter=new ColorPagerAdapter(getSupportFragmentManager());
//        a.setAdapter(adapter);
        getOrientation();


    }

    //метод открытия статьи по нажатию
    public void openArticle (int position){
        FragmentManager fm = getSupportFragmentManager();
        ArticleNewsFragment fragment = (ArticleNewsFragment)fm.findFragmentById(R.id.fragmenttxt);
        fragment.openArticle(position);
    }
    //проверка ориентации
    public void getOrientation(){
        FragmentManager fm = getSupportFragmentManager();
        ArticleNewsFragment fragment = (ArticleNewsFragment)fm.findFragmentById(R.id.fragmenttxt);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //скрытие фрагмента менеджером
            fm.beginTransaction().hide(fragment).commit();
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //открытие фрагмента менеджером
            fm.beginTransaction().show(fragment).commit();
        }
    }


}
