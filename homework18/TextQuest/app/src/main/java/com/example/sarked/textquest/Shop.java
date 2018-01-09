package com.example.sarked.textquest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    TextView txt3;
    static TextView gold;
    int money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        txt3=(TextView)findViewById(R.id.txt3);
        gold=(TextView)findViewById(R.id.goldInShop);



        // количество денег достаем при онкриейте  чтоб записать в текствьюшку
        final SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
        money=prefs.getInt("money",100);
        gold.setText(money+"");

        final int color = prefs.getInt("background",0);
        if (color==-16777216){
            txt3.setText("Крутая светлая тема.");
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money=prefs.getInt("money",100);
                if (money>=1000){
                    money=money-1000;
                    prefs.edit().putInt("money",money).apply();
                    gold.setText(money+"");
                    //нужно сделать так, чтобы приток золота увеличился на 1
                    int howMuch = prefs.getInt("howMuch",1);
                    prefs.edit().putInt("howMuch",howMuch+1).apply();
                } else{
                    Toast.makeText(getApplicationContext(),"Не хватает золота", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money=prefs.getInt("money",100);
                if (money>=20){
                    money=money-20;
                    prefs.edit().putInt("money",money).apply();
                    gold.setText(money+"");

                    //нужно сделать так, чтобы время между притоками сократилось вдвое
//                    Intent intent=new Intent(MainActivity.self,MyService.class);
                    //stopService(MainActivity.self.serviceIntent);
                    MainActivity.self.serviceIntent.getComponent();

                } else{
                    Toast.makeText(getApplicationContext(),"Не хватает золота", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money=prefs.getInt("money",100);
                if (money>=3000){
                    money=money-3000;
                    prefs.edit().putInt("money",money).apply();
                    gold.setText(money+"");
                    //меняем тему
                    final int color = prefs.getInt("background",0);
                    if (color==0){
                        prefs.edit().putInt("background",-16777216).apply();
                        prefs.edit().putInt("color",-1).apply();
                        Toast.makeText(getApplicationContext(),"Готово, зацените!", Toast.LENGTH_SHORT).show();
                        txt3.setText("Крутая темная тема.");
                    }else{
                        prefs.edit().putInt("background",0).apply();
                        prefs.edit().putInt("color",-7829368).apply();
                        Toast.makeText(getApplicationContext(),"Сделано, посморите сами!", Toast.LENGTH_SHORT).show();
                        txt3.setText("Крутая светлая тема.");
                    }

                } else{
                    Toast.makeText(getApplicationContext(),"Не хватает золота", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public static void setShopGold(int money) {
        if(gold!=null){
            gold.setText(money+"");
        }
    }

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}
