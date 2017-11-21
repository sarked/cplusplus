package com.example.sarked.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item>{
    private ArrayList<Item> list;
    public ItemAdapter(@NonNull Context context, ArrayList<Item> item) {
        super(context, R.layout.list_genres, item);
        list=item;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_genres,null);

        TextView a = (TextView) convertView.findViewById(R.id.txtgenre);
        a.setText(list.get(position).name);
        return convertView;
    }
}
