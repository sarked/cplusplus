package com.example.sarked.chat;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnection extends SQLiteOpenHelper {
    public static String HUMANS_TABLE_NAME="humans";
    public static String HUMANS_NAMES="name";
    public static String MASSAGE_TABLE_NAME="massages";
    public static String MASSAGE_FROM="mFrom";
    public static String MASSAGE_TEXT="text";
    public static String LOG_TABLE_NAME="logs";
    public static String LOG_STRINGS="string";

    public DBConnection (Context ctx) {
        super(ctx, "db_name", null, 1);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+HUMANS_TABLE_NAME+" (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +HUMANS_NAMES+" TEXT)");

        db.execSQL("CREATE TABLE "+MASSAGE_TABLE_NAME+" (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +MASSAGE_FROM+" INTEGER,"
                +MASSAGE_TEXT+" TEXT)");

        db.execSQL("CREATE TABLE "+LOG_TABLE_NAME+" (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +LOG_STRINGS+" TEXT)");

        ContentValues cv =new ContentValues();

        cv.put(HUMANS_NAMES,"Alex");
        db.insert(HUMANS_TABLE_NAME,null,cv);
        cv.put(HUMANS_NAMES,"Bart");
        db.insert(HUMANS_TABLE_NAME,null,cv);
        cv.put(HUMANS_NAMES,"Carl");
        db.insert(HUMANS_TABLE_NAME,null,cv);
        cv.put(HUMANS_NAMES,"Victor");
        db.insert(HUMANS_TABLE_NAME,null,cv);
        cv.put(HUMANS_NAMES,"Dan");
        db.insert(HUMANS_TABLE_NAME,null,cv);
        cv.put(HUMANS_NAMES,"Grag");
        db.insert(HUMANS_TABLE_NAME,null,cv);
        cv.put(HUMANS_NAMES,"Pete");
        db.insert(HUMANS_TABLE_NAME,null,cv);

        cv =new ContentValues();

        cv.put(MASSAGE_FROM,1);
        cv.put(MASSAGE_TEXT,"Всем привет!");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
        cv.put(MASSAGE_FROM,2);
        cv.put(MASSAGE_TEXT,"Всем чмоки в этом чатике!");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
        cv.put(MASSAGE_FROM,1);
        cv.put(MASSAGE_TEXT,"Как здоровье?");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
        cv.put(MASSAGE_FROM,3);
        cv.put(MASSAGE_TEXT,"кекеке");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
        cv.put(MASSAGE_FROM,4);
        cv.put(MASSAGE_TEXT,"Погугли");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
        cv.put(MASSAGE_FROM,5);
        cv.put(MASSAGE_TEXT,"кш-пш");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
        cv.put(MASSAGE_FROM,6);
        cv.put(MASSAGE_TEXT,"Не засерайте чатик, коллеги");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
        cv.put(MASSAGE_FROM,6);
        cv.put(MASSAGE_TEXT,"Сдаем по 5 рубасов на др бухгалтеру");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
        cv.put(MASSAGE_FROM,3);
        cv.put(MASSAGE_TEXT,"Я опаздываю");
        db.insert(MASSAGE_TABLE_NAME,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        db.execSQL("DROP TABLE"+HUMANS_TABLE_NAME);
        this.onCreate(db);
    }
}
