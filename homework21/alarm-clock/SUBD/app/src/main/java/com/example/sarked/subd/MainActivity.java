package com.example.sarked.subd;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static MainActivity self;
    final Calendar today= Calendar.getInstance();
    String b;
    Intent serviceIntent;
    String n;
    int h;
    int m;
    static ArrayList<Contact>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self=this;



        final ListView ListView = (android.widget.ListView)findViewById(R.id.list);
        final ArrayList<Contact> contacts = new ArrayList<>();
        list = new ArrayList<>();

        final DBConnection connection = new DBConnection(this);
        final SQLiteDatabase db=connection.getReadableDatabase();
        Cursor cursor = db.query("contacts",
                new String[]{"_id","name","hour","min"},null,null,null,null,null);
        int id, hour, min; String name;
        if((cursor!=null)&& cursor.getCount()>0){
            while (cursor.moveToNext()){
                //порядок в query
                id=cursor.getInt(0);
                name=cursor.getString(1);
                hour=cursor.getInt(2);
                min=cursor.getInt(3);
                //Toast.makeText(this,id+" "+name+" "+phone,Toast.LENGTH_SHORT).show();
                Contact contact = new Contact(id,name,hour,min);
                contacts.add(contact);
                list.add(contact);
            }
        }
        final ContactsAdapter adapter=new ContactsAdapter(this,contacts);
        ListView.setAdapter(adapter);
        db.close();

        //запуск сервиса MyService
        serviceIntent=new Intent(this,MyService.class);
        startService(serviceIntent);

        //вносим данные на +
        final ContentValues cv =new ContentValues();
        Button btn = (Button)findViewById(R.id.addBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder (self);
                dialog.setTitle ("Кого добавляем?");

                LayoutInflater inflater = getLayoutInflater();
                LinearLayout layout = (LinearLayout)findViewById(R.id.add_layout);
                final View view = inflater.inflate(R.layout.add, layout);
                dialog.setView(view);
                final EditText nameTxt = (EditText) view.findViewById(R.id.setName);

                dialog.setPositiveButton("Далее", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder dialog1 = new AlertDialog.Builder(MainActivity.this);
                        LayoutInflater inflater = getLayoutInflater();
                        LinearLayout layout = (LinearLayout) findViewById(R.id.date_layout);
                        final View view = inflater.inflate(R.layout.date, layout);
                        TimePicker mTimePicker = (TimePicker) view.findViewById(R.id.datePicker);
                        dialog1.setView(view);

                        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                            @Override
                            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                                h=hourOfDay;
                                m=minute;
                            }
                        });
                        dialog1.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //заново открываем закрытый доступ к бд
                                final SQLiteDatabase db=connection.getWritableDatabase();
                                cv.put("name",nameTxt.getText().toString());
                                cv.put("hour",h);
                                cv.put("min",m);
                                db.insert("contacts",null,cv);

                                list.clear();
                                adapter.clear();
                                //проходимся для построения списка
                                Cursor cursor = db.query("contacts",
                                        new String[]{"_id","name","hour","min"},null,null,null,null,null);
                                int id, hour, min; String name;
                                if((cursor!=null)&& cursor.getCount()>0){
                                    while (cursor.moveToNext()){
                                        //порядок в query
                                        id=cursor.getInt(0);
                                        name=cursor.getString(1);
                                        hour=cursor.getInt(2);
                                        min=cursor.getInt(3);
                                        Contact contact = new Contact(id,name,hour,min);
                                        contacts.add(contact);
                                        list.add(contact);
                                    }
                                }
                                final ContactsAdapter adapter=new ContactsAdapter(self,contacts);
                                ListView.setAdapter(adapter);
                                //в конце закрываем
                                db.close();
                            }
                        });
                        dialog1.show();
                    }
                });
                dialog.setNeutralButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //просто чтоб диалог закрывался
                    }
                });
                dialog.create().show();
            }
        });
    }

    public void dingding(String result){
        Toast.makeText(getApplicationContext(), "ДЗЫНЬ ДЗЫНЬ!!! "+ result, Toast.LENGTH_SHORT).show();


    }
}
