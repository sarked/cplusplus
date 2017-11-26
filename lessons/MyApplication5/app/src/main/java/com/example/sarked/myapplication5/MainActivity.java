package com.example.sarked.myapplication5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    private MainActivity self;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self=this;



        //подтянули главный лайаут из xml
        LinearLayout layout=(LinearLayout)findViewById(R.id.root);
        Button btn = (Button) findViewById(R.id.buttonXml);

        //коллекция Фильмов для дальнейшего выведения их построково
        ArrayList<String> movies = new ArrayList<>();
        movies.add("Inception");
        movies.add("Man in black");
        movies.add("Death Proof");

        //массив
        final String items []={"Movie 43", "IT", "MyFilm"};


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder (self);
//                диалог с выбором элемента строкового массива
//                dialog.setItems(items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(),items[which],Toast.LENGTH_SHORT).show();
//                    }
//                });

                //диалог с выбором одного элеента строкового массива
//                dialog.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
//                    @Override
//                    //обработчик событий выполняет действие при нажатии на элемент, а не закрытии окна диалога
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(),items[which],Toast.LENGTH_SHORT).show();
//                    }
//                });

//                boolean selected [] = {true, true, false};
//                dialog.setMultiChoiceItems(items, selected, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//
//                    }
//                });

                dialog.setTitle ("Название диалога");
                //dialog.setMessage("Сообщение");

                //подтягиваем форму логина из папки лайаут
                //dialog.setView(R.layout.dialog_layout);

                dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"no",Toast.LENGTH_SHORT).show();
                    }
                });

                LayoutInflater inflater = getLayoutInflater();
                LinearLayout layout = (LinearLayout)findViewById(R.id.dialog_layout_main);
                final View view = inflater.inflate(R.layout.dialog_layout, layout);
                dialog.setView(view);

                dialog.setNeutralButton("maybe", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String t = ((EditText)view.findViewById(R.id.login)).getText().toString();
                        String p = ((EditText)view.findViewById(R.id.pass)).getText().toString();
                        //выводим логинпароль в подсказке
                        Toast.makeText(getApplicationContext(),t+" "+p,Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.create().show();
            }
        });

        Iterator<String> iter = movies.iterator();
        while(iter.hasNext()) {


            LinearLayout layer = new LinearLayout(this);
            //магия
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
            layer.setLayoutParams(params);
            //
            layer.setOrientation(LinearLayout.HORIZONTAL);

            params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            TextView text = new TextView(this);
            text.setLayoutParams(params);
            final String name = iter.next();
            text.setText(name);
            //имя текущего элемента

            Button but = new Button(this);
            but.setLayoutParams(params);
            but.setText("efg");

            //метод помещения в линер
            layer.addView(text);
            layer.addView(but);

            // а тут линеры поместили в вертикальный лаяут
            layout.addView(layer);


            //нажималка на кнопку
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    //переопределение метода меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        int id=item.getItemId();
        switch (id){
            case R.id.title:
                Toast.makeText(getApplicationContext(),"Title",Toast.LENGTH_SHORT).show();

            case R.id.info:
                Toast.makeText(getApplicationContext(),"Info",Toast.LENGTH_SHORT).show();
            case R.id.exit:
                Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_SHORT).show();

        }
        return true;
    }

}
