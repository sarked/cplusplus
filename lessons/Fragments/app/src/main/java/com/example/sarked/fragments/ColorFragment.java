package com.example.sarked.fragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Sarked on 22.11.2017.
 */

public class ColorFragment extends Fragment {
    public ColorFragment (){

    }

    //переопределяем методы для работы с фрагментами
    @Override
    public void onCreate (Bundle bundle){
        super.onCreate(bundle);
    }
    //возвращает построенный в методе виджет, он будет использоватсья в качестве View




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle){
        View view = inflater.inflate(R.layout.color_page, parent, false);
        Random rnd = new Random();
        LinearLayout l=(LinearLayout)view.findViewById(R.id.page);
        l.setBackgroundColor(Color.rgb(
                rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)


        ));
        return view;
    }
}
