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

public class GoodsAdapter extends ArrayAdapter{
    private ArrayList <Goods> list;
    private AssetManager assets;

    public GoodsAdapter(@NonNull Context context, ArrayList <Goods> goods) {
        super(context, R.layout.goods_layout, goods);
        list=goods;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.goods_layout,null);
        TextView a = (TextView) convertView.findViewById(R.id.good_name);
        a.setText(list.get(position).title);
        ((GoodsList)getContext()).setFont(a);

        ImageView c = (ImageView)convertView.findViewById(R.id.good_img);
        c.setImageResource(list.get(position).icon);

        return convertView;
    }
}
