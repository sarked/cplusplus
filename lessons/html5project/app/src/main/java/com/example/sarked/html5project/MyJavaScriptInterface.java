package com.example.sarked.html5project;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class MyJavaScriptInterface {

    @JavascriptInterface
    public void getWeapon (){
        Toast.makeText(MainActivity.self,"Берем оружие", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void deleteWeapon (){
        Toast.makeText(MainActivity.self,"Удаляем оружие", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void createWeapon (){
        Toast.makeText(MainActivity.self,"Добавляем оружие", Toast.LENGTH_SHORT).show();
    }

}

