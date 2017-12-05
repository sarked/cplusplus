package com.example.sarked.catalog;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter{
    private ArrayList <Category> list;
    private AssetManager assets;

    public CategoryAdapter(@NonNull Context context, ArrayList <Category> category) {
        super(context, R.layout.category_layout, category);
        list=category;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.category_layout,null);
        TextView a = (TextView) convertView.findViewById(R.id.cat_name);
        a.setText(list.get(position).title);
        ((MainActivity)getContext()).setFont(a);

        TextView b = (TextView) convertView.findViewById(R.id.cat_quant);
        b.setText("На складе: "+list.get(position).goods.size());
        ((MainActivity)getContext()).setFont(b);

        ImageView c = (ImageView)convertView.findViewById(R.id.cat_img);
        c.setImageResource(list.get(position).res);

        return convertView;
    }
}
