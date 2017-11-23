package com.example.sarked.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//переопределили адаптер, говорим ему что он создается из коллекции контактов и использует наш заготовленный лайаут_контактс
public class ContactsAdapter extends ArrayAdapter<Contact> {

    private ArrayList <Contact> list;
    public ContactsAdapter(Context ctx, ArrayList<Contact> contacts){

        super(ctx,R.layout.list_contacts,contacts);
        list=contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_contacts,null);


        TextView a = (TextView) convertView.findViewById(R.id.name);
        TextView b = (TextView) convertView.findViewById(R.id.tel);
        a.setText(list.get(position).name);
        b.setText(list.get(position).phone);
        return convertView;


        //тут линерлайаут и две текствьюшки
    }
}
