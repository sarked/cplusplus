package com.example.sarked.demons;

import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final WebView webView = (WebView)findViewById(R.id.browser);
        final Button btn = (Button)findViewById(R.id.btn);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        final Bundle data=getIntent().getExtras();
        btn.setText(data.getString("name"));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager manager = (ConnectivityManager)getSystemService(MainActivity.CONNECTIVITY_SERVICE);
                boolean mobile=manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected();
                boolean wifi=manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();

                if (mobile==false && wifi==false){
                    btn.setText("Проверьте подключение к интернету");
                }else{
                    webView.loadUrl(data.getString("url"));
                    btn.setVisibility(View.GONE);

                }
            }
        });

    }
}
