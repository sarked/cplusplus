package com.example.sarked.adapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final String [] items ={"One","Two","Three"};

        Button btn = (Button)findViewById(R.id.btn);

        ListView ListView = (android.widget.ListView)findViewById(R.id.list);

        final ArrayList<String> items = new ArrayList<>();
        items.add("One");
        items.add("Tho");
        items.add("Three");

        //создаем адаптер
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this, R.layout.list_item, items);
        ListView.setAdapter(adapter);

        //нажатие на строку
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //int position - это номер элемента списка
                Toast.makeText(getApplicationContext(),items.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        //нажатие на кнопку добавляе элемент в адаптер
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                adapter.add("Elem");
//                Toast.makeText(getApplicationContext(),String.valueOf(items.size()),Toast.LENGTH_SHORT).show();
//            }
//        });

//тел контакты

        //три объекта класса Контакт
        Contact alla = new Contact("Алла","+375 29 344-54-34");
        Contact boris = new Contact("Борис","+375 33 399-99-99");
        Contact victor = new Contact("Виктор","+375 25 669-69-69");

        final ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(alla);
        contacts.add(boris);
        contacts.add(victor);

        ContactsAdapter adapter1=new ContactsAdapter(this,contacts);
        //перекрывает первый адаптер для листвьюшки
        ListView.setAdapter(adapter1);


    }
}
