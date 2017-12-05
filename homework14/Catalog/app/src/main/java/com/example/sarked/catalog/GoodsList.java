package com.example.sarked.catalog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class GoodsList extends AppCompatActivity {
    private GoodsList self;

    public void setFont(TextView tv){
        AssetManager am=getAssets();
        Typeface font=Typeface.createFromAsset(am, "myfont.TTF");
        tv.setTypeface(font);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        self=this;
        getOrientation();

        TextView title = (TextView)findViewById(R.id.goods_list_title);
        final ListView list = (android.widget.ListView)findViewById(R.id.goods_list_list);
        setFont(title);

        Bundle data=getIntent().getExtras();
        title.setText((data.getString("title"))+" в продаже:");

        final Collection collection = (Collection) getIntent().getSerializableExtra("collection");

        final ArrayList<Goods> arrayList = new ArrayList<>(collection);
        GoodsAdapter adapter1 = new GoodsAdapter(this,arrayList);

        list.setAdapter(adapter1);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),arrayList.get(position).quality,Toast.LENGTH_SHORT).show();
                openInfo(arrayList.get(position),arrayList);

                //перезаписывался последних посещенных товаров для главной
                SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);

                ArrayList<String> sharedNames = new ArrayList<String>();
                ArrayList<Integer> sharedPics = new ArrayList<Integer>();
                sharedNames.add(prefs.getString("name1","Текст 1"));
                sharedPics.add(prefs.getInt("img1",0));
                sharedNames.add(prefs.getString("name2","Текст 2"));
                sharedPics.add(prefs.getInt("img2",0));
                sharedNames.add(prefs.getString("name3","Текст 3"));
                sharedPics.add(prefs.getInt("img3",0));

                prefs.edit().putString("name3",sharedNames.get(1)).putInt("img3",sharedPics.get(1))
                        .putString("name2",sharedNames.get(0)).putInt("img2",sharedPics.get(0))
                        .putString("name1",arrayList.get(position).title).putInt("img1",arrayList.get(position).icon)
                        .apply();
            }
        });

    }
    public void openInfo (Goods good, ArrayList<Goods> arrayList){
        FragmentManager fm = getSupportFragmentManager();
        InfoFragment fragment = (InfoFragment) fm.findFragmentById(R.id.fragment_info);
        fragment.openInfo(good,arrayList);
    }

    //проверка ориентации
    public void getOrientation(){
        LinearLayout main = (LinearLayout)findViewById(R.id.main_layout);
        TextView title = (TextView)findViewById(R.id.goods_list_title);
        FragmentManager fm = getSupportFragmentManager();
        InfoFragment fragment = (InfoFragment) fm.findFragmentById(R.id.fragment_info);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //скрытие фрагмента менеджером
            //задать ориентацию лаяута вертиклаьную
            fm.beginTransaction().hide(fragment).commit();
            main.setOrientation(LinearLayout.VERTICAL);
            title.setVisibility(View.VISIBLE);
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //открытие фрагмента менеджером
            //задать ориентацию лаяута горизонтальную
            fm.beginTransaction().show(fragment).commit();
            main.setOrientation(LinearLayout.HORIZONTAL);
            title.setVisibility(View.GONE);

        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}
