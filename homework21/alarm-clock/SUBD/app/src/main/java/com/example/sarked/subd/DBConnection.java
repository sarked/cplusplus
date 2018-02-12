package com.example.sarked.subd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBConnection extends SQLiteOpenHelper {
    public static String TABLE_NAME="contacts";
    public static String PHONE="phone";
    public static String NAME="name";

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
                +"hour INTEGER,"
                +"min INTEGER)");

        ContentValues cv =new ContentValues();
        //кладем один объект
        cv.put("name","ДР Бони");
        cv.put("hour",10);
        cv.put("min",15);
        db.insert("contacts",null,cv);
        //второй объект кладем
        cv.put("name","Завтрак");
        cv.put("hour",9);
        cv.put("min",50);
        db.insert("contacts",null,cv);
        //далее
        cv.put("name","Обед");
        cv.put("hour",12);
        cv.put("min",0);
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
