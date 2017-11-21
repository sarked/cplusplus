package com.example.sarked.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (android.widget.ListView)findViewById(R.id.list);

        //создать объекты жанров
        //колекция фильмов может быть hashmap ключ-значение (название, описание)
        final ArrayList <Genre> genres = new ArrayList<Genre>();
        Genre horror = new Genre("Ужасы", Genre.getHorrors());
        Genre comedy = new Genre("Комедии", Genre.getComedies());
        Genre scify = new Genre("Фантастика", Genre.getScifi());
        Genre fantasy = new Genre("Фентези", Genre.getFantasy());
        Genre dram = new Genre("Драма", Genre.getDram());
        Genre serial = new Genre("Сериалы", Genre.getSer());
        genres.add(horror);
        genres.add(comedy);
        genres.add(scify);
        genres.add(fantasy);
        genres.add(dram);
        genres.add(serial);

        //ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.list_genres,horrors);
        GenreAdapter adapter = new GenreAdapter(this,genres);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),String.valueOf(genres.get(position).films.size()),Toast.LENGTH_SHORT).show();

                //всобачить вторую активность
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),Films.class);
                intent.putExtra("title", genres.get(position).name);
                //передаем
                intent.putExtra("obj", (Serializable) genres.get(position).films);
                startActivity(intent);
            }
        });
    }
}
