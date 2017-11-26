package com.example.sarked.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    int c=0;
    int b=0;
    int f=1;
    //метод для первого открытия активности
    public void setVal(){
        TextView cb=(TextView)findViewById(R.id.txt_color);
        TextView bb=(TextView)findViewById(R.id.txt_back);
        TextView fb=(TextView)findViewById(R.id.txt_font);

//первый текст
        if (c==-1){
            cb.setText("Цвет текста: БЕЛЫЙ");
        }
        if (c==-7829368){
            cb.setText("Цвет текста: СЕРЫЙ");
        }
        if (c==-16777216){
            cb.setText("Цвет текста: ЧЕРНЫЙ");
        }
        if (c==-16711936){
            cb.setText("Цвет текста: ЗЕЛЕНЫЙ");
        }
        if (c==-16776961){
            cb.setText("Цвет текста: СИНИЙ");
        }
        if (c==-65536){
            cb.setText("Цвет текста: КРАСНЫЙ");
        }
        if (c==-16711681){
            cb.setText("Цвет текста: БИРЮЗОВЫЙ");
        }
        if (c==0){
            cb.setText("Цвет текста: НЕВИДИМЫЙ");
        }
//второй текст
        if (b==-1){
            bb.setText("Цвет фона текста: БЕЛЫЙ");
        }
        if (b==-7829368){
            bb.setText("Цвет фона текста: СЕРЫЙ");
        }
        if (b==-16777216){
            bb.setText("Цвет фона текста: ЧЕРНЫЙ");
        }
        if (b==-16711936){
            bb.setText("Цвет фона текста: ЗЕЛЕНЫЙ");
        }
        if (b==-16776961){
            bb.setText("Цвет фона текста: СИНИЙ");
        }
        if (b==-65536){
            bb.setText("Цвет фона текста: КРАСНЫЙ");
        }
        if (b==-16711681){
            bb.setText("Цвет фона текста: БИРЮЗОВЫЙ");
        }
        if (b==0){
            bb.setText("Цвет фона текста: НЕВИДИМЫЙ");
        }
//третий
        if (f==0){
            fb.setText("Шрифт: ОБЫЧНЫЙ");
        }
        if (f==1){
            fb.setText("Шрифт: ЖИРНЫЙ");
        }
        if (f==2){
            fb.setText("Шрифт: КУРСИВ");
        }
        if (f==3){
            fb.setText("Шрифт: ЖИРНЫЙ КУРСИВ");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
        //значения по умолчанию
        c=prefs.getInt("color",-7829368);
        b=prefs.getInt("background",0);
        f=prefs.getInt("type",0);
        //метод при каждом входе в настройки подтягивает текущие значения под текствьшки
        setVal();

        final TextView cb=(TextView)findViewById(R.id.txt_color);
        final TextView bb=(TextView)findViewById(R.id.txt_back);
        final TextView fb=(TextView)findViewById(R.id.txt_font);


//строковый массив для первой и второй текствьюшки
        final String colors []={"Белый", "Серый", "Черный", "Зеленый", "Синий", "Красный", "Бирюзовый", "Невидимый"};

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle ("Выберите цвет шрифта");
                dialog.setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (colors[which]=="Белый"){
                            cb.setText("Цвет текста: БЕЛЫЙ");
                            prefs.edit().putInt("color",-1).apply();
                        }
                        if (colors[which]=="Серый"){
                            cb.setText("Цвет текста: СЕРЫЙ");
                            prefs.edit().putInt("color",-7829368).apply();
                        }
                        if (colors[which]=="Черный"){
                            cb.setText("Цвет текста: ЧЕРНЫЙ");
                            prefs.edit().putInt("color",-16777216).apply();
                        }
                        if (colors[which]=="Зеленый"){
                            cb.setText("Цвет текста: ЗЕЛЕНЫЙ");
                            prefs.edit().putInt("color",-16711936).apply();
                        }
                        if (colors[which]=="Синий"){
                            cb.setText("Цвет текста: СИНИЙ");
                            prefs.edit().putInt("color",-16776961).apply();
                        }
                        if (colors[which]=="Красный"){
                            cb.setText("Цвет текста: КРАСНЫЙ");
                            prefs.edit().putInt("color",-65536).apply();
                        }
                        if (colors[which]=="Бирюзовый"){
                            cb.setText("Цвет текста: БИРЮЗОВЫЙ");
                            prefs.edit().putInt("color",-16711681).apply();
                        }
                        if (colors[which]=="Невидимый"){
                            cb.setText("Цвет текста: НЕВИДИМЫЙ");
                            prefs.edit().putInt("color",0).apply();
                        }
                    }
                });
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                dialog.create().show();
            }
        });

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle ("Выберите цвет фона");
                dialog.setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (colors[which]=="Белый"){
                            bb.setText("Цвет фона текста: БЕЛЫЙ");
                            prefs.edit().putInt("background",-1).apply();
                        }
                        if (colors[which]=="Серый"){
                            bb.setText("Цвет фона текста: СЕРЫЙ");
                            prefs.edit().putInt("background",-7829368).apply();
                        }
                        if (colors[which]=="Черный"){
                            bb.setText("Цвет фона текста: ЧЕРНЫЙ");
                            prefs.edit().putInt("background",-16777216).apply();
                        }
                        if (colors[which]=="Зеленый"){
                            bb.setText("Цвет фона текста: ЗЕЛЕНЫЙ");
                            prefs.edit().putInt("background",-16711936).apply();
                        }
                        if (colors[which]=="Синий"){
                            bb.setText("Цвет фона текста: СИНИЙ");
                            prefs.edit().putInt("background",-16776961).apply();
                        }
                        if (colors[which]=="Красный"){
                            bb.setText("Цвет фона текста: КРАСНЫЙ");
                            prefs.edit().putInt("background",-65536).apply();
                        }
                        if (colors[which]=="Бирюзовый"){
                            bb.setText("Цвет фона текста: БИРЮЗОВЫЙ");
                            prefs.edit().putInt("background",-16711681).apply();
                        }
                        if (colors[which]=="Невидимый"){
                            bb.setText("Цвет фона текста: НЕВИДИМЫЙ");
                            prefs.edit().putInt("background",0).apply();
                        }
                    }
                });
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create().show();
            }
        });


        final String fonst []={"Обычный", "Жирный", "Курсив", "Жирный курсив"};

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle ("Настройте шрифт");
                dialog.setSingleChoiceItems(fonst, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (fonst[which]=="Обычный"){
                            fb.setText("Шрифт: ОБЫЧНЫЙ");
                            prefs.edit().putInt("type",0).apply();
                        }
                        if (fonst[which]=="Жирный"){
                            fb.setText("Шрифт: ЖИРНЫЙ");
                            prefs.edit().putInt("type",1).apply();
                        }
                        if (fonst[which]=="Курсив"){
                            fb.setText("Шрифт: КУРСИВ");
                            prefs.edit().putInt("type",2).apply();
                        }
                        if (fonst[which]=="Жирный курсив"){
                            fb.setText("Шрифт: ЖИРНЫЙ КРУСИВ");
                            prefs.edit().putInt("type",3).apply();
                        }
                    }
                });
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create().show();
            }
        });

        Button btn = (Button)findViewById(R.id.save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
