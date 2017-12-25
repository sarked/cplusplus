package com.example.sarked.chat;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;


public class MyService extends Service {
    MyTask task=null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //для запуска из программного потока, здесь не нужно
        return null;
    }

    @Override
    public void onCreate(){
        //Все это добро запускается один раз

        final DBConnection connection = new DBConnection(this);
        final SQLiteDatabase db=connection.getReadableDatabase();

        ArrayList<String> massages = new ArrayList<>();
        String idfrom;

        Cursor mcursor = db.query(DBConnection.MASSAGE_TABLE_NAME,
                new String[]{"_id",DBConnection.MASSAGE_FROM, DBConnection.MASSAGE_TEXT},null,null,null,null,null);
        if((mcursor!=null)&& mcursor.getCount()>0){
            while (mcursor.moveToNext()){
                idfrom=""+mcursor.getInt(1);

                Cursor cursor = db.query(DBConnection.HUMANS_TABLE_NAME,
                        new String[]{"_id", DBConnection.HUMANS_NAMES},
                        "_id = ?",
                        new String[]{idfrom},
                        null, null, null);
                if((cursor != null) && cursor.getCount() > 0){
                    cursor.moveToFirst();
                    do{
                        massages.add(new String(cursor.getString(1)+": "+mcursor.getString(2)));
                        // у нас есть эррейлист с сообщениями, надо передать его в таск
                        //он там будет вечно прокручиваться и каждое новое сообщение заносить в новую БД
                        // Toast.makeText(this,cursor.getString(1)+": "+mcursor.getString(2),Toast.LENGTH_SHORT).show();
                    }while(cursor.moveToNext());
                }
            }
        }
        db.close();
        task = new MyTask(this,massages);
        task.execute();
    }

    @Override
    public void onDestroy(){
    }
}
