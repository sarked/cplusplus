package com.example.sarked.html5project;

import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static MainActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self=this;


        String text ="";
        WebView webView = (WebView)findViewById(R.id.browser);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

//проверка и-нета
        //нужны разрешения в манифесте:
//        <uses-permission android:name="android.permission.INTERNET"/>
//        <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

        ConnectivityManager manager = (ConnectivityManager)getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        boolean mobile=manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected();
        boolean wifi=manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();

        if (mobile==false && wifi==false){
            Toast.makeText(MainActivity.self,"Отстутствует подключение к интернету", Toast.LENGTH_SHORT).show();
        }else{

            //загрузка данных
            webView.loadUrl("http://iteajob.retarcorp.com/weapon_crud/");

            // создание JS интерфейса
            webView.addJavascriptInterface(new MyJavaScriptInterface(),"MyInterface");
            //.MyInterface.getWeapon();
        }


    }
}
