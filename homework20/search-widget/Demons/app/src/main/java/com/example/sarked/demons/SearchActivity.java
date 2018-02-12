package com.example.sarked.demons;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
private SearchActivity self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        self = this;

        final EditText edit = (EditText)findViewById(R.id.inputField);
        Button search = (Button)findViewById(R.id.startSearch);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a= edit.getText().toString();


                final ListView ListView = (android.widget.ListView) findViewById(R.id.result_list);
                final ArrayList<Demon> demons = new ArrayList<>();

                final DBConnection connection = new DBConnection(SearchActivity.this);
                final SQLiteDatabase db = connection.getReadableDatabase();

                Cursor cursor = db.query(DBConnection.DEMONS_TABLE_NAME, new String[]{"_id", DBConnection.DEMONS_NAME, DBConnection.DEMONS_URL},
                        DBConnection.DEMONS_NAME +" = ?",
                        new String[] {a},
                        null, null, null);


                if((cursor != null) && cursor.getCount() > 0){
                    cursor.moveToFirst();
                    do{
                        demons.add(new Demon(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
                    }while(cursor.moveToNext());
                }else{
                    Toast.makeText(SearchActivity.this,"По введенному имени демонов не найдено", Toast.LENGTH_LONG).show();
                }
                db.close();
                final DemonAdapter adapter = new DemonAdapter(SearchActivity.this, demons);
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
        });
    }
}
