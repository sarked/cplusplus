package com.example.sarked.movies;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class Films extends AppCompatActivity {

    private Films self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);
        self=this;


        TextView title = (TextView)findViewById(R.id.filmtitle);
        final ListView list = (android.widget.ListView)findViewById(R.id.filmlist);





        Bundle data=getIntent().getExtras();
        title.setText(" Лучшие фильмы в жанре «"+data.getString("title")+"»:");

        Collection a = (Collection) getIntent().getSerializableExtra("obj");


        final ArrayList<Item> arrayList = new ArrayList<>(a);
        ItemAdapter adapter1 = new ItemAdapter(this,arrayList);
        //final ArrayAdapter <String> adapter1 = new ArrayAdapter <> (this, R.layout.list_genres, arrayList);

        list.setAdapter(adapter1);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder (self);
                dialog.setTitle (arrayList.get(position).name);
                dialog.setMessage(arrayList.get(position).descriotion);
                dialog.create().show();
            }
        });

    }
}
