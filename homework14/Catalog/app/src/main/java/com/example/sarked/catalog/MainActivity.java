package com.example.sarked.catalog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void setFont(TextView tv){
        AssetManager am=getAssets();
        Typeface font=Typeface.createFromAsset(am, "myfont.TTF");
        tv.setTypeface(font);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //запретили смену ориентации для главной активности
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView ta=(TextView)findViewById(R.id.txt_a);
        TextView tb=(TextView)findViewById(R.id.txt_b);
        TextView tc=(TextView)findViewById(R.id.txt_c);
        ImageView ia=(ImageView)findViewById(R.id.img_a);
        ImageView ib=(ImageView)findViewById(R.id.img_b);
        ImageView ic=(ImageView)findViewById(R.id.img_c);

        SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);

        ta.setText(prefs.getString("name1","Текст 1"));
        ia.setImageResource(prefs.getInt("img1",0));
        tb.setText(prefs.getString("name2","Текст 2"));
        ib.setImageResource(prefs.getInt("img2",0));
        tc.setText(prefs.getString("name3","Текст 3"));
        ic.setImageResource(prefs.getInt("img3",0));
        setFont(ta);
        setFont(tb);
        setFont(tc);

        TextView txt = (TextView)findViewById(R.id.txt);
        setFont(txt);
        TextView txt2 = (TextView)findViewById(R.id.txt2);
        setFont(txt2);
        final ImageView goblin=(ImageView)findViewById(R.id.goblin);
        goblin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goblin.setVisibility(View.GONE);
            }
        });txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goblin.setVisibility(View.VISIBLE);
            }
        });

        final ListView list = (android.widget.ListView)findViewById(R.id.list);

        final ArrayList<Category> category = new ArrayList<Category>();
        //Category bow = new Category("Луки", items, R.drawable.bow3);
        //category.add(bow);
        category.add(new Category("Клинки", Category.getSwords(),R.drawable.sword1));
        category.add(new Category("Топоры", Category.getStaffs(), R.drawable.axe1));
        category.add(new Category("Булавы", Category.getMaces(),R.drawable.mace2));
        category.add(new Category("Жезлы", Category.getStaffs(), R.drawable.staff1));
        category.add(new Category("Луки", Category.getBows(), R.drawable.bow3));
        category.add(new Category("Броня", Category.getArmors(),R.drawable.armor1));
        category.add(new Category("Зелья", Category.getPoisons(),R.drawable.poison1));
        category.add(new Category("Книги", Category.getBooks(),R.drawable.book4));

        CategoryAdapter adapter = new CategoryAdapter(this, category);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(getApplicationContext(),category.get(position).title,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),GoodsList.class);
                intent.putExtra("title", category.get(position).title);
                intent.putExtra("collection", (Serializable) category.get(position).goods);
                startActivity(intent);
                finish();
            }
        });

    }

}
