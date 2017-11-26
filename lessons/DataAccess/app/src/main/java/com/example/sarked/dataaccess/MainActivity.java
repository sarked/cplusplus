package com.example.sarked.dataaccess;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//получает данные при запуске активности
        //SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
        //данные по умолчанию:
        int size = prefs.getInt("textsize",16);


        Button a = (Button)findViewById(R.id.btn);
        Button b = (Button)findViewById(R.id.size);
        //ставим шрифт
        final TextView txt=(TextView)findViewById(R.id.txt) ;
        txt.setTextSize(size);

        //попытка использовать файл из raw

//        FileInputStream fin= null;
//        try {
//            fin = openFileInput("text.txt");
//            InputStreamReader reader=new InputStreamReader(fin);
//
//            byte [] bytes=new byte[65535];
//            reader.read(bytes);
//            String text = new String (bytes);
//            txt.setText(text);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }



        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });


        final String items []={"10", "12", "16", "20","24","28"};
        final AlertDialog.Builder dialog = new AlertDialog.Builder (this);
        dialog.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String w=items[which];
                Toast.makeText(MainActivity.this, w, Toast.LENGTH_SHORT).show();

                int size=Integer.parseInt(w);
                //в данной активности
                //SharedPreferences prefs=getPreferences(MODE_PRIVATE);
                //между активностями:
                SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);

                txt.setTextSize(size);

                //после всего должен быть Apply или Commit
                prefs.edit().putInt("textsize",size).apply();

            }
        });
        //dialog.create();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.create().show();
            }
        });


    }
}
