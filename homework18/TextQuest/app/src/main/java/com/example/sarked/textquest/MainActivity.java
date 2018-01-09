package com.example.sarked.textquest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static MainActivity self;
    TextView gold;
    TextView text;
    Button left;
    Button right;
    TextView shop;
    int money;
    int needmoney;
    LinearLayout back;
    int howMuch;
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self=this;

        gold=(TextView)findViewById(R.id.gold);
        shop=(TextView)findViewById(R.id.shop);
        text=(TextView)findViewById(R.id.text);
        left=(Button)findViewById(R.id.btn_left);
        right=(Button)findViewById(R.id.btn_right);
        back=(LinearLayout)findViewById(R.id.back);

// сохраняем ID текущей комнаты и количество денег, достаем при онкриейте
        final SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
        final String id=prefs.getString("thisway","001");
        money=prefs.getInt("money",100);
        gold.setText(money+"");

        //настройки внешнего вида приложения
        int c=prefs.getInt("color",-7829368);
        int b=prefs.getInt("background",0);
        gold.setTextColor(c);
        text.setTextColor(c);
        back.setBackgroundColor(b);

        //девтулс

        Button restart =(Button)findViewById(R.id.restart);
        Button minus =(Button)findViewById(R.id.minus);
        Button plus =(Button)findViewById(R.id.plus);
        final LinearLayout layout =(LinearLayout)findViewById(R.id.devtools);
        gold.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                layout.setVisibility(View.VISIBLE);
                return false;
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money=prefs.getInt("money",100);
                money=money-50;
                prefs.edit().putInt("money",money).apply();
                gold.setText(money+"");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money=prefs.getInt("money",100);
                money=money+50;
                prefs.edit().putInt("money",money).apply();
                gold.setText(money+"");
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
                prefs.edit().putString("thisway","001").apply();
                loadActivity();
            }
        });

//запуск сервиса MyService, в котором крутится MyTask для добавления денег
        serviceIntent=new Intent(this,MyService.class);
        startService(serviceIntent);



//Открываем БД для построения комнаты
        DBConnection connection = new DBConnection(this);
        SQLiteDatabase db = connection.getReadableDatabase();
        //запрос по айдишнику комнаты
        final Cursor cursor = db.query(DBConnection.ROOMS_TABLE_NAME, new String[]{"_id", DBConnection.ROOMS_WAY, DBConnection.ROOMS_TEXT, DBConnection.ROOMS_VAR_A, DBConnection.ROOMS_VAR_A_WAY, DBConnection.ROOMS_VAR_A_PRICE, DBConnection.ROOMS_VAR_B, DBConnection.ROOMS_VAR_B_WAY, DBConnection.ROOMS_VAR_B_PRICE},
                DBConnection.ROOMS_WAY +" = ?",
                new String[]{id},
                null, null, null);
        //построение элементов
        cursor.moveToFirst();
        db.close();
        //узаем сколько нам нужно денег для перехода
        text.setText(cursor.getString(2));
        left.setText(cursor.getString(3));
        right.setText(cursor.getString(6));
        if(cursor.getInt(5)>=cursor.getInt(8)){
            needmoney=cursor.getInt(5);
        }else{
            needmoney=cursor.getInt(8);
        }

//левый и правый варики
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //проверка на деньги
                money=prefs.getInt("money",100);
                if (money>=cursor.getInt(5)){
                    money=money-cursor.getInt(5);
                    prefs.edit().putInt("money",money).apply();
                    gold.setText(money+"");
            //берем id новой комнаты и рестартаем активность с новой id
                    SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
                    prefs.edit().putString("thisway",cursor.getString(4)).apply();
                    loadActivity();
                } else{
                    Toast.makeText(getApplicationContext(),"Не хватает "+(cursor.getInt(5)-money)+" золота", Toast.LENGTH_SHORT).show();
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money=prefs.getInt("money",100);
                if (money>=cursor.getInt(8)){
                    money=money-cursor.getInt(8);
                    prefs.edit().putInt("money",money).apply();
                    gold.setText(money+"");

                    SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
                    prefs.edit().putString("thisway",cursor.getString(7)).apply();
                    loadActivity();
                } else{
                    Toast.makeText(getApplicationContext(),"Не хватает "+(cursor.getInt(8)-money)+" золота", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //магазин
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),Shop.class);
                startActivity(intent);
                finish();
            }
        });





    }
    private void loadActivity() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void getMoney(){
        SharedPreferences prefs=getSharedPreferences("MainActivity",MODE_PRIVATE);
        money=prefs.getInt("money",100);
        howMuch = prefs.getInt("howMuch",1);
        money=money+howMuch;
        prefs.edit().putInt("money",money).apply();
        gold.setText(money+"");
        Shop.setShopGold(money);
        if(money==needmoney){
            Toast.makeText(getApplicationContext(),"достаточно денег для продолжения приключения", Toast.LENGTH_SHORT).show();
        }
    }
}
