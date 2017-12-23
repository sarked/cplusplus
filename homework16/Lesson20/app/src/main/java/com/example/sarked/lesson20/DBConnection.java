package com.example.sarked.lesson20;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBConnection extends SQLiteOpenHelper {
    public static String CITIES_TABLE_NAME="cities";
    public static String CITIES_NAME="name";
    public static String CITIES_IATA="iata";
    public static String TICKETS_TABLE_NAME="tickets";
    public static String TICKETS_FROM="fromm";
    public static String TICKETS_TO="too";
    public static String TICKETS_PRICE="price";
    public static String TICKETS_DEPART_DATE="depart_date";
    public static String TICKETS_FLIGHT_TIME="flight_time";
    public static String TICKETS_AVIACOMPANY="aviacompany";
    public static String DB_NAME="db_name";

    public DBConnection (Context ctx){
        super (ctx, DB_NAME,null,1);
    }

    @Override
    public void onCreate (SQLiteDatabase db){

        db.execSQL("CREATE TABLE "+CITIES_TABLE_NAME+" (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +CITIES_NAME+" TEXT,"
                +CITIES_IATA+" TEXT)");

        db.execSQL("CREATE TABLE "+TICKETS_TABLE_NAME+" (" +
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +TICKETS_FROM+" TEXT,"
                +TICKETS_TO+" TEXT,"
                +TICKETS_PRICE+" REAL,"
                +TICKETS_DEPART_DATE+" TEXT,"
                +TICKETS_FLIGHT_TIME+" INTEGER,"
                +TICKETS_AVIACOMPANY+" TEXT)");

        ContentValues cv =new ContentValues();

        cv.put(CITIES_NAME,"Минск");
        cv.put(CITIES_IATA,"MSQ");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Алжир");
        cv.put(CITIES_IATA,"AAE");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Москва");
        cv.put(CITIES_IATA,"MOW");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Бишкек");
        cv.put(CITIES_IATA,"FRU");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Санкт-Петербург");
        cv.put(CITIES_IATA,"LED");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Самара");
        cv.put(CITIES_IATA,"KUF");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Париж");
        cv.put(CITIES_IATA,"POX");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Познан");
        cv.put(CITIES_IATA,"POZ");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Краков");
        cv.put(CITIES_IATA,"KRK");
        db.insert(CITIES_TABLE_NAME,null,cv);
        cv.put(CITIES_NAME,"Лондон");
        cv.put(CITIES_IATA,"LHR");
        db.insert(CITIES_TABLE_NAME,null,cv);

        //пересоздать для новой таблицы
        cv =new ContentValues();

        cv.put(TICKETS_FROM,"MSQ");
        cv.put(TICKETS_TO,"MOW");
        cv.put(TICKETS_PRICE,50.2);
        cv.put(TICKETS_DEPART_DATE,"23.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,90);
        cv.put(TICKETS_AVIACOMPANY,"Белавиа");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"MOW");
        cv.put(TICKETS_TO,"MSQ");
        cv.put(TICKETS_PRICE,52.5);
        cv.put(TICKETS_DEPART_DATE,"24.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,90);
        cv.put(TICKETS_AVIACOMPANY,"Белавиа");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"MSQ");
        cv.put(TICKETS_TO,"LHR");
        cv.put(TICKETS_PRICE,104.3);
        cv.put(TICKETS_DEPART_DATE,"21.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,110);
        cv.put(TICKETS_AVIACOMPANY,"Белавиа");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"LHR");
        cv.put(TICKETS_TO,"MOW");
        cv.put(TICKETS_PRICE,120.35);
        cv.put(TICKETS_DEPART_DATE,"20.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,155);
        cv.put(TICKETS_AVIACOMPANY,"Аэрофлот");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"LHR");
        cv.put(TICKETS_TO,"POX");
        cv.put(TICKETS_PRICE,60.5);
        cv.put(TICKETS_DEPART_DATE,"25.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,38);
        cv.put(TICKETS_AVIACOMPANY,"Королевские авиалинии");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"FRU");
        cv.put(TICKETS_TO,"POX");
        cv.put(TICKETS_PRICE,200.0);
        cv.put(TICKETS_DEPART_DATE,"30.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,89);
        cv.put(TICKETS_AVIACOMPANY,"Бишкекское авиасообщение");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"POX");
        cv.put(TICKETS_TO,"AAE");
        cv.put(TICKETS_PRICE,90.0);
        cv.put(TICKETS_DEPART_DATE,"20.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,70);
        cv.put(TICKETS_AVIACOMPANY,"Турецкие авиалинии");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"KUF");
        cv.put(TICKETS_TO,"LED");
        cv.put(TICKETS_PRICE,55.8);
        cv.put(TICKETS_DEPART_DATE,"22.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,50);
        cv.put(TICKETS_AVIACOMPANY,"Аэрофлот");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"LED");
        cv.put(TICKETS_TO,"KUF");
        cv.put(TICKETS_PRICE,60.2);
        cv.put(TICKETS_DEPART_DATE,"23.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,50);
        cv.put(TICKETS_AVIACOMPANY,"Аэрофлот");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"LED");
        cv.put(TICKETS_TO,"KRK");
        cv.put(TICKETS_PRICE,121.2);
        cv.put(TICKETS_DEPART_DATE,"25.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,75);
        cv.put(TICKETS_AVIACOMPANY,"Аэрофлот");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"POZ");
        cv.put(TICKETS_TO,"KRK");
        cv.put(TICKETS_PRICE,25.0);
        cv.put(TICKETS_DEPART_DATE,"25.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,75);
        cv.put(TICKETS_AVIACOMPANY,"Польский аэродром");
        db.insert(TICKETS_TABLE_NAME,null,cv);

        cv.put(TICKETS_FROM,"KRK");
        cv.put(TICKETS_TO,"POZ");
        cv.put(TICKETS_PRICE,25.0);
        cv.put(TICKETS_DEPART_DATE,"25.12.2017");
        cv.put(TICKETS_FLIGHT_TIME,75);
        cv.put(TICKETS_AVIACOMPANY,"Польский аэродром");
        db.insert(TICKETS_TABLE_NAME,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        db.execSQL("DROP TABLE "+CITIES_TABLE_NAME);
        db.execSQL("DROP TABLE "+TICKETS_TABLE_NAME);
        this.onCreate(db);
    }
}