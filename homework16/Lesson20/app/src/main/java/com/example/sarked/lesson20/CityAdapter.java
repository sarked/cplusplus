package com.example.sarked.lesson20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CityAdapter extends ArrayAdapter<City> {
    private ArrayList<City> list;

    public CityAdapter(Context ctx, ArrayList<City> cities){
        super(ctx, R.layout.city_view, cities);
        list = cities;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.city_view, null);
        TextView city = (TextView) convertView.findViewById(R.id.city);
        city.setText(list.get(position).name + " (" + list.get(position).iata + ")");
        return convertView;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.city_view, null);
        TextView city = (TextView) convertView.findViewById(R.id.city);
        city.setText(list.get(position).name + " (" + list.get(position).iata + ")");
        return convertView;
    }
}
