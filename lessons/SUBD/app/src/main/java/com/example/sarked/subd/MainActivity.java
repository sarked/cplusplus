package com.example.sarked.subd;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self=this;


        final ListView ListView = (android.widget.ListView)findViewById(R.id.list);
        final ArrayList<Contact> contacts = new ArrayList<>();


        final DBConnection connection = new DBConnection(this);
        final SQLiteDatabase db=connection.getWritableDatabase();
                ///.getWritableDatabase();
        //для этой будет создан кеш, она будет продублирована и все операции будут выполняться над копией, пока БД не будет закрыта.
                //или .getReadableDatabase()  //если нужно только чтение

        //курсор - это итератор, который позволяет обходить результаты получения данных
        Cursor cursor = db.query("contacts",
                new String[]{"_id","name","phone"},null,null,null,null,null);

        int id; String name, phone;
        //cursor.getCount()>0 - проверка есть ли что-нибудь
        if((cursor!=null)&& cursor.getCount()>0){
            while (cursor.moveToNext()){
                //порядок в query
                id=cursor.getInt(0);
                name=cursor.getString(1);
                phone=cursor.getString(2);
                //Toast.makeText(this,id+" "+name+" "+phone,Toast.LENGTH_SHORT).show();
                Contact contact = new Contact(id,name,phone);
                contacts.add(contact);
            }
        }

        final ContactsAdapter adapter=new ContactsAdapter(this,contacts);
        ListView.setAdapter(adapter);

        //рекомендуется закрывать везде, где до этого открывалось
        db.close();

        final ContentValues cv =new ContentValues();
        //вызываем один раз, чтобы вносить данные

        //кликалка по строкам
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                //Toast.makeText(getApplicationContext(),contacts.get(position).name,Toast.LENGTH_SHORT).show();
                AlertDialog.Builder dialog = new AlertDialog.Builder (self);
                dialog.setTitle ("Редактирование");

                LayoutInflater inflater = getLayoutInflater();
                LinearLayout layout = (LinearLayout)findViewById(R.id.add_layout);
                final View viewEdit = inflater.inflate(R.layout.add, layout);
                dialog.setView(viewEdit);
                //внимание, подтягиваем из viewEdit в этом случае виджеты
                final EditText nameTxt = (EditText) viewEdit.findViewById(R.id.setName);
                final EditText phoneTxt = (EditText)viewEdit.findViewById(R.id.setPhone);
                nameTxt.setText(contacts.get(position).name);
                phoneTxt.setText(contacts.get(position).phone);


                dialog.setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //заново открываем закрытый доступ к бд
                        final SQLiteDatabase db=connection.getWritableDatabase();
                        //пишем нового человека
                        cv.put("name",nameTxt.getText().toString());
                        cv.put("phone",phoneTxt.getText().toString());
                        //добавление
                        //db.insert("contacts",null,cv);
                        //обновление
                        db.update("contacts",cv,"_id=?", new String[]{String.valueOf(position+1)});

                        //проходимся для построения списка
                        adapter.clear();
                        Cursor cursor = db.query("contacts",
                                new String[]{"_id","name","phone"},null,null,null,null,null);

                        int id; String name, phone;
                        if((cursor!=null)&& cursor.getCount()>0){
                            while (cursor.moveToNext()){
                                //порядок в query
                                id=cursor.getInt(0);
                                name=cursor.getString(1);
                                phone=cursor.getString(2);
                                Contact contact = new Contact(id,name,phone);
                                contacts.add(contact);
                            }
                        }
                        final ContactsAdapter adapter=new ContactsAdapter(self,contacts);
                        ListView.setAdapter(adapter);

                        //в конце закрываем
                        db.close();
                    }
                });
                dialog.setNeutralButton("Удалить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //заново открываем закрытый доступ к бд
                        final SQLiteDatabase db = connection.getWritableDatabase();
                        //добавление
                            //пишем нового человека
                            //cv.put("name", nameTxt.getText().toString());
                            //cv.put("phone", phoneTxt.getText().toString());
                            //db.insert("contacts",null,cv);
                        //обновление
                            //db.update("contacts", cv, "_id=?", new String[]{String.valueOf(position + 1)});
                        //удаление
                        db.delete("contacts","_id=?", new String[]{String.valueOf(position + 1)});

                        //проходимся для построения списка
                        adapter.clear();
                        Cursor cursor = db.query("contacts",
                                new String[]{"_id", "name", "phone"}, null, null, null, null, null);

                        int id;
                        String name, phone;
                        if ((cursor != null) && cursor.getCount() > 0) {
                            while (cursor.moveToNext()) {
                                //порядок в query
                                id = cursor.getInt(0);
                                name = cursor.getString(1);
                                phone = cursor.getString(2);
                                Contact contact = new Contact(id, name, phone);
                                contacts.add(contact);
                            }
                        }
                        final ContactsAdapter adapter = new ContactsAdapter(self, contacts);
                        ListView.setAdapter(adapter);

                        //в конце закрываем
                        db.close();
                    }
                });

                dialog.create().show();
            }
        });




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
                final EditText phoneTxt = (EditText)view.findViewById(R.id.setPhone);


                dialog.setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //заново открываем закрытый доступ к бд
                        final SQLiteDatabase db=connection.getWritableDatabase();
                        //пишем нового человека
                        cv.put("name",nameTxt.getText().toString());
                        cv.put("phone",phoneTxt.getText().toString());
                        db.insert("contacts",null,cv);

                        //проходимся для построения списка
                        Cursor cursor = db.query("contacts",
                                new String[]{"_id","name","phone"},null,null,null,null,null);

                        int id; String name, phone;
                        if((cursor!=null)&& cursor.getCount()>0){
                            while (cursor.moveToNext()){
                                //порядок в query
                                id=cursor.getInt(0);
                                name=cursor.getString(1);
                                phone=cursor.getString(2);
                                Contact contact = new Contact(id,name,phone);
                                contacts.add(contact);
                            }
                        }
                        final ContactsAdapter adapter=new ContactsAdapter(self,contacts);
                        ListView.setAdapter(adapter);

                        //в конце закрываем
                        db.close();
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



        //удаление
        //db.delete("contacts","_id=?", new String[]{id});

        //изменение
        //ContentValues cv =new ContentValues();
        //cv.put("name","Alex");
        //cv.put("phone","80213331177");
        //db.insert("contacts",null,cv);

        //обновление, 1 - это айдишник элемента. position
        //db.update("contacts",cv,"_id=?", new String[]{String.valueOf(1)});
    }
}
