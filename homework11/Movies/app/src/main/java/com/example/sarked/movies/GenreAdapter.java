package com.example.sarked.movies;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<Genre> {

    //???????? V
    private ArrayList<Genre> list;
    public GenreAdapter(@NonNull Context context, ArrayList<Genre> genre) {
        super(context, R.layout.list_genres, genre);
        list=genre;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_genres,null);


        TextView a = (TextView) convertView.findViewById(R.id.txtgenre);
        a.setText(list.get(position).name+" (топ "+list.get(position).films.size()+")");
        return convertView;

    }
}
