package com.example.sarked.subd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter extends ArrayAdapter<Contact> {

    private ArrayList<Contact> list;
    public ContactsAdapter(Context ctx, ArrayList<Contact> contacts){

        super(ctx,R.layout.list_contects,contacts);
        list=contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_contects,null);


        TextView a = (TextView) convertView.findViewById(R.id.name);
        TextView b = (TextView) convertView.findViewById(R.id.tel);
        TextView c = (TextView) convertView.findViewById(R.id.id);
        a.setText(list.get(position).name);
        b.setText(list.get(position).phone);
        c.setText(String.valueOf(list.get(position).id));
        return convertView;


    }
}