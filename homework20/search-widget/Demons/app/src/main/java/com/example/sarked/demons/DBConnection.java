package com.example.sarked.demons;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBConnection extends SQLiteOpenHelper {
    public static String DEMONS_TABLE_NAME="demons";
    public static String DEMONS_NAME="name";
    public static String DEMONS_URL="url";
    public DBConnection (Context ctx){
        super (ctx, "db_name",null,1);

    }

    @Override
    public void onCreate (SQLiteDatabase db){
        // запускается 1 раз при запуске или создании после удаления БД
        //создание таблицы:
        db.execSQL("CREATE TABLE "+DEMONS_TABLE_NAME+" (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +DEMONS_NAME+" TEXT,"
                +DEMONS_URL+" TEXT)");

        ContentValues cv =new ContentValues();

        cv.put(DEMONS_NAME,"Велиал");
        cv.put(DEMONS_URL,"https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D0%BB%D0%B8%D0%B0%D0%BB");
        db.insert(DEMONS_TABLE_NAME,null,cv);

        cv.put(DEMONS_NAME,"Пазузу");
        cv.put(DEMONS_URL,"https://ru.wikipedia.org/wiki/%D0%9F%D0%B0%D0%B7%D1%83%D0%B7%D1%83");
        db.insert(DEMONS_TABLE_NAME,null,cv);

        cv.put(DEMONS_NAME,"Вешапи");
        cv.put(DEMONS_URL,"https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D1%88%D0%B0%D0%BF%D0%B8");
        db.insert(DEMONS_TABLE_NAME,null,cv);

        cv.put(DEMONS_NAME,"Они");
        cv.put(DEMONS_URL,"https://ru.wikipedia.org/wiki/%D0%9E%D0%BD%D0%B8_(%D0%B4%D0%B5%D0%BC%D0%BE%D0%BD%D1%8B)");
        db.insert(DEMONS_TABLE_NAME,null,cv);

        cv.put(DEMONS_NAME,"Коронзон");
        cv.put(DEMONS_URL,"https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D1%80%D0%BE%D0%BD%D0%B7%D0%BE%D0%BD");
        db.insert(DEMONS_TABLE_NAME,null,cv);

        cv.put(DEMONS_NAME,"Гаки");
        cv.put(DEMONS_URL,"https://ru.wikipedia.org/wiki/%D0%93%D0%B0%D0%BA%D0%B8");
        db.insert(DEMONS_TABLE_NAME,null,cv);

        cv.put(DEMONS_NAME,"Вереселень");
        cv.put(DEMONS_URL,"https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D1%80%D0%B5%D1%81%D0%B5%D0%BB%D0%B5%D0%BD%D1%8C");
        db.insert(DEMONS_TABLE_NAME,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        //при переходе от одной версии прилажения к другой
        db.execSQL("DROP TABLE "+DEMONS_TABLE_NAME);
        //создание заново:
        this.onCreate(db);
    }
}