package com.example.sarked.dataaccess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
        int size = prefs.getInt("textsize",16);
        final TextView txt=(TextView)findViewById(R.id.secondtxt) ;
        txt.setTextSize(size);

    }
}
