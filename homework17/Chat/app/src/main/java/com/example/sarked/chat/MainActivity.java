package com.example.sarked.chat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static MainActivity self;
    ListView listView;
    ArrayList<String> massages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self=this;

        listView = (android.widget.ListView)findViewById(R.id.log);
        massages=new ArrayList<>();

        final Intent intent=new Intent(this,MyService.class);
        startService(intent);

        showList();
    }




    void showProgress(String a) {
        DBConnection connection = new DBConnection(MainActivity.this);
        SQLiteDatabase db=connection.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(DBConnection.LOG_STRINGS,a+"");
        db.insert(DBConnection.LOG_TABLE_NAME,null,cv);

        showList();
        db.close();
    }

    void showList(){
        DBConnection connection = new DBConnection(MainActivity.this);
        SQLiteDatabase db=connection.getReadableDatabase();
        Cursor cursor = db.query(DBConnection.LOG_TABLE_NAME,
                new String[]{DBConnection.LOG_STRINGS},null,null,null,null,null);

            ArrayList<String> massages = new ArrayList<>();
        if((cursor!=null)&& cursor.getCount()>0){
            while (cursor.moveToNext()){
                massages.add(cursor.getString(0)+"");
            }
        }
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this, R.layout.list_item, massages);
        listView.setAdapter(adapter);
        db.close();
    }
}
