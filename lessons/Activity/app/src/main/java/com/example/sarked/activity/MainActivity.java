package com.example.sarked.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    public ArrayList <String> humans ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//инициализация поля
        humans=new ArrayList<>();
        edtxt = (EditText)findViewById(R.id.edtxt);
        abc = (TextView)findViewById(R.id.txt);
        abc.append("OnCreate\n");
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //у каждого класса есть метод, который закрывает текущую активность
                finish();
            }
        });

//кнопочка старта второй активности
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),SecondActivity.class);

                //передача данных между активностями
                intent.putExtra("AC","Привет");

                startActivity(intent);
                //НЕ СРАБОТАЕТ, ТАМ ЗАКОММЕНЧЕНО ПОЛЕ, ЧТОБ НЕ КОНФЛИКТОВАЛО С ДРУГОЙ ПЕРЕДАЧЕЙ ИНТЕКСТА

            }
        });
        //final ArrayList<String> humans = new ArrayList<>();

        humans.add("Алла Борисовна Пугачева");
        humans.add("Борис Викторович Гребенщеков");
        humans.add("Андрей Евгеньевич Кострома");
        //кнопочка добавления нового элемента в список (переход в другую активность)
        Button addbtn=(Button)findViewById(R.id.add) ;
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),SecondActivity.class);
                startActivityForResult(intent, 10);

            }
        });



        LayoutInflater inflater = getLayoutInflater();
        LinearLayout layout = (LinearLayout)findViewById(R.id.list);
        //final View view = inflater.inflate(R.layout.activity_main, layout);

        Iterator<String> iter = humans.iterator();
        while(iter.hasNext()) {

            LinearLayout layer = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
            layer.setLayoutParams(params);
            layer.setOrientation(LinearLayout.HORIZONTAL);

            params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            TextView text = new TextView(this);
            text.setLayoutParams(params);
            final String name = iter.next();
            text.setText(name);
            layer.addView(text);
            layout.addView(layer);

        }



    }
    //поле класса, которое хранит текствью и эдтст, можно образаться из разных методов
    //public ArrayList humans;
    public TextView abc;
    public EditText edtxt;
    public Button btn;
    public Button btn2;

    @Override
    public void onStart(){
        super.onStart();
        abc.append("OnStart\n");
    }
    @Override
    public void onStop(){
        super.onStop();
        abc.append("OnStop\n");
    }
    @Override
    public void onPause(){
        super.onPause();
        abc.append("OnPause\n");
    }
    @Override
    public void onResume(){
        super.onResume();
        abc.append("OnResume\n");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        abc.append("OnRestart\n");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        abc.append("OnDestroy\n");
    }

    @Override
    //метод должен вбирать 1 бандл, а то по умолчанию выбирается не тот метод
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String text = abc.getText().toString();
        Toast.makeText(this, ":"+text, Toast.LENGTH_SHORT).show();
        outState.putString("AB",abc.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String saved = savedInstanceState.getString("AB");
        Toast.makeText(this, saved, Toast.LENGTH_SHORT).show();
        abc.setText(saved);

    }


    //метод нажатия кнопочки "назад"
    public void onBackPressed(){
        //Toast.makeText(this, "back pressed", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
        dialog.setTitle ("Точно выйти?");
        dialog.setPositiveButton("точно", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("не точно", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"как скажете",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.create().show();
    }

    @Override
    public void onActivityResult(int pid, int code, Intent intent){
        //извлечь пришедший контент, вставить в ArrayList
        Bundle data=intent.getExtras();
        String txt = data.getString("name");
        humans.add(txt);

    }

}
