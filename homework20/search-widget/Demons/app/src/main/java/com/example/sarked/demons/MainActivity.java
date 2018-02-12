package com.example.sarked.demons;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MainActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;

        final ListView ListView = (android.widget.ListView) findViewById(R.id.list);
        final ArrayList<Demon> demons = new ArrayList<>();

        final DBConnection connection = new DBConnection(this);
        final SQLiteDatabase db = connection.getReadableDatabase();

        Cursor cursor = db.query(DBConnection.DEMONS_TABLE_NAME, new String[]{"_id", DBConnection.DEMONS_NAME, DBConnection.DEMONS_URL}, null, null, null, null, null);

        if((cursor != null) && cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                demons.add(new Demon(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        db.close();
        final DemonAdapter adapter = new DemonAdapter(this, demons);
        ListView.setAdapter(adapter);
        db.close();

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),SecondActivity.class);
                intent.putExtra("name",demons.get(position).name);
                intent.putExtra("url",demons.get(position).url);
                startActivity(intent);
            }
        });


    }
}