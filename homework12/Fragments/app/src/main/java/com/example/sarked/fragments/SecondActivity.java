package com.example.sarked.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//нашли на страничке текствьюшку
        TextView a = (TextView)findViewById(R.id.txtInActivity);
        //извлекли пришедшее значение и перезаписали
        Bundle data=getIntent().getExtras();
        a.setText(data.getString("1"));
    }
}
