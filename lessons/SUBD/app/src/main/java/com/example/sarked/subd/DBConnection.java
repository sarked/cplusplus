package com.example.sarked.subd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBConnection extends SQLiteOpenHelper {
    public DBConnection (Context ctx){
        super (ctx, "db_name",null,1);

    }

    @Override
    public void onCreate (SQLiteDatabase db){
        // запускается 1 раз при запуске или создании после удаления БД
        //создание таблицы:
        db.execSQL("CREATE TABLE contacts (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +"name TEXT,"
                +"phone TEXT)");

        ContentValues cv =new ContentValues();
        //кладем один объект
        cv.put("name","Alex");
        cv.put("phone","80213331177");
        db.insert("contacts",null,cv);
        //второй объект кладем
        cv.put("name","Bart");
        cv.put("phone","80212455666");
        db.insert("contacts",null,cv);
        //далее
        cv.put("name","Carl");
        cv.put("phone","80295553322");
        db.insert("contacts",null,cv);

        cv.put("name","Victor");
        cv.put("phone","80335594422");
        db.insert("contacts",null,cv);

        cv.put("name","Dan");
        cv.put("phone","80449859312");
        db.insert("contacts",null,cv);

        cv.put("name","Grag");
        cv.put("phone","80293337650");
        db.insert("contacts",null,cv);

        cv.put("name","Pete");
        cv.put("phone","80338885511");
        db.insert("contacts",null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        //при переходе от одной версии прилажения к другой
        db.execSQL("DROP TABLE contacts");
        //создание заново:
        this.onCreate(db);
    }
}
