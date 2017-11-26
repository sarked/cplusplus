package com.example.sarked.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = (TextView)findViewById(R.id.text);

        SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
        //значения по умолчанию
        int c=prefs.getInt("color",-7829368);
        int b=prefs.getInt("background",0);
        int f=prefs.getInt("type",0);
        //применяем на текствьюшку
        txt.setTextColor(c);
        txt.setBackgroundColor(b);
        txt.setTypeface(Typeface.defaultFromStyle(f));
    }

    //переобпределяем медод меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        int id=item.getItemId();
        switch (id){
            case R.id.menu_btn:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
        }
        return true;
    }
}
