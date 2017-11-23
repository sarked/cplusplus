package com.example.sarked.fragments;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapter extends ArrayAdapter <Article> {
    private ArrayList<Article> list;
    public TitleAdapter(@NonNull Context context, ArrayList <Article> art) {
        super(context, R.layout.news_adapter, art);
        list=art;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_adapter, null, false);
        ((TextView)convertView.findViewById(R.id.titleText)).setText(Data.articles.get(position).title);
        return convertView;
    }
}
