package com.example.sarked.demons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DemonAdapter extends ArrayAdapter<Demon> {

    private ArrayList<Demon> list;
    public DemonAdapter(Context ctx, ArrayList<Demon> contacts){

        super(ctx,R.layout.list_demons,contacts);
        list=contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_demons,null);


        TextView a = (TextView) convertView.findViewById(R.id.name);
        TextView c = (TextView) convertView.findViewById(R.id.id);
        a.setText(list.get(position).name);
        c.setText(String.valueOf(list.get(position).id));
        return convertView;


    }
}