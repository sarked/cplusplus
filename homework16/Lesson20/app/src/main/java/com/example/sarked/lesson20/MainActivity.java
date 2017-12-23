package com.example.sarked.lesson20;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Spinner from;
    private Spinner to;
    private Button departureDate;
    private EditText priceFrom;
    private EditText priceTo;
    private TextView durationLabel;
    private SeekBar duration;
    private Button search;
    private Button sort;
    private ListView results;
    String fromCity;
    String toCity;
    String flyDate;
    SeekBar seek;
    TextView seekText;
    String setedDuration;
    String priceMin;
    String priceMax;
    String filterChoise;
    int choise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        from = (Spinner) findViewById(R.id.from);
        to = (Spinner) findViewById(R.id.to);
        departureDate = (Button) findViewById(R.id.departure_date);
        priceFrom = (EditText) findViewById(R.id.price_from);
        priceTo = (EditText) findViewById(R.id.price_to);
        durationLabel = (TextView) findViewById(R.id.duration_label);
        duration = (SeekBar) findViewById(R.id.duration);
        search = (Button) findViewById(R.id.search);
        sort = (Button) findViewById(R.id.sort);
        results = (ListView) findViewById(R.id.results);
        seek = (SeekBar) findViewById(R.id.duration);
        seekText = (TextView) findViewById(R.id.duration_label);
        Button cancelBtn = (Button) findViewById(R.id.cancel);

        final Calendar today = Calendar.getInstance();
        fromCity="MSQ";
        toCity="MSQ";
        flyDate="01.01.2017";
        setedDuration="1000";
        priceMin="0";
        priceMax="1000";
        filterChoise="";
        choise=1;

//строим список городов
        DBConnection connection = new DBConnection(this);
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.query(DBConnection.CITIES_TABLE_NAME, new String[]{"_id", DBConnection.CITIES_NAME, DBConnection.CITIES_IATA}, null, null, null, null, null);
        final ArrayList<City> cities = new ArrayList<>();
        if((cursor != null) && cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                cities.add(new City(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        db.close();

        CityAdapter adapter = new CityAdapter(this, cities);
        from.setAdapter(adapter);
        to.setAdapter(adapter);
        //!!!!!!!!!!!в адаптере не выводятся города, выводятся айдишники объектов

//клик по городу
        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromCity=cities.get(position).iata;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toCity=cities.get(position).iata;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//выбор даты
        departureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                LinearLayout layout = (LinearLayout)findViewById(R.id.date_layou1);
                final View view = inflater.inflate(R.layout.date, layout);
                DatePicker mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);
                dialog.setView(view);
                mDatePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH),
                        new DatePicker.OnDateChangedListener() {
                            @Override
                            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String a;
                                String d;
                                if ((monthOfYear+1)<10){
                                    a="0"+(monthOfYear+1);
                                }else{
                                    a=String.valueOf(monthOfYear+1);
                                }
                                if (dayOfMonth<10){
                                    d="0"+dayOfMonth;
                                }else{
                                    d=String.valueOf(dayOfMonth);
                                }

                                flyDate=d+"."+a+"."+year;
                                //Toast.makeText(getApplicationContext(),flyDate, Toast.LENGTH_SHORT).show();
                                departureDate.setText(flyDate);
                            }
                        });
                dialog.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //закрываем окно
                    }
                });
                dialog.show();
            }
        });

//сикбар
        DBConnection seekConnection = new DBConnection(this);
        SQLiteDatabase seekdb = connection.getReadableDatabase();

        Cursor seekCursor = seekdb.query(seekConnection.TICKETS_TABLE_NAME, new String[]{"MAX("+seekConnection.TICKETS_FLIGHT_TIME+")"},
                null, null, null, null, null);
        int seekMax=100;
        seekCursor.moveToFirst();
              if ((seekCursor != null) && cursor.getCount() > 0) {
                seekMax = seekCursor.getInt(0);
            }
        db.close();
        seek.setMax(seekMax);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekText.setText("Время в пути до "+progress+" минут");
                setedDuration=String.valueOf(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

// сортировка листа по цене-времени
        final String filters []={"цене", "времени"};
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setSingleChoiceItems(filters, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String w=filters[which];

                        sort.setText(w);
                        //и сортировка листа в зависимости от выбора
                        if(w=="цене"){
                            choise=1;
                        }
                        if(w=="времени"){
                            choise=2;
                        }
                    }
                });
                dialog.show();
            }
        });

//ПОИСК:
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceMin=priceFrom.getText().toString();
                priceMax=priceTo.getText().toString();

                DBConnection connection = new DBConnection(MainActivity.this);
                SQLiteDatabase db = connection.getReadableDatabase();

                if (choise==1){
                    filterChoise=DBConnection.TICKETS_PRICE;
                }
                if (choise==2){
                    filterChoise=DBConnection.TICKETS_FLIGHT_TIME;
                }
                //Cursor cursor = db.query(DBConnection.TICKETS_TABLE_NAME, new String[]{"_id", DBConnection.TICKETS_FROM, DBConnection.TICKETS_TO, DBConnection.TICKETS_PRICE, DBConnection.TICKETS_DEPART_DATE, DBConnection.TICKETS_FLIGHT_TIME, DBConnection.TICKETS_AVIACOMPANY}, null, null,
                // null, null, null);
                Cursor cursor = db.query(DBConnection.TICKETS_TABLE_NAME, new String[]{"_id", DBConnection.TICKETS_FROM, DBConnection.TICKETS_TO, DBConnection.TICKETS_PRICE, DBConnection.TICKETS_DEPART_DATE, DBConnection.TICKETS_FLIGHT_TIME, DBConnection.TICKETS_AVIACOMPANY},
                        DBConnection.TICKETS_FROM +" = ? AND "+DBConnection.TICKETS_TO+" = ? AND "+DBConnection.TICKETS_DEPART_DATE+" = ? AND "+DBConnection.TICKETS_FLIGHT_TIME+" <= ? AND "+DBConnection.TICKETS_PRICE+" >= ? AND "+DBConnection.TICKETS_PRICE+" <= ?",
                        new String[]{fromCity,toCity,flyDate,setedDuration,priceMin,priceMax},
                        null, null, filterChoise+" ASC");

                ArrayList<Ticket> tickets = new ArrayList<>();
                if((cursor != null) && cursor.getCount() > 0){
                    cursor.moveToFirst();
                    do{
                        tickets.add(new Ticket(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getDouble(3),cursor.getString(4),cursor.getInt(5),cursor.getString(6)));
                    }while(cursor.moveToNext());
                }
                final TicketAdapter adapter=new TicketAdapter(MainActivity.this,tickets);
                results.setAdapter(adapter);
                db.close();
            }
        });

        //кнопка сброса

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBConnection connection = new DBConnection(MainActivity.this);
                SQLiteDatabase db = connection.getReadableDatabase();

                Cursor cursor = db.query(DBConnection.TICKETS_TABLE_NAME, null, null, null, null, null, null);

                ArrayList<Ticket> tickets = new ArrayList<>();
                if((cursor != null) && cursor.getCount() > 0){
                    cursor.moveToFirst();
                    do{
                        tickets.add(new Ticket(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getDouble(3),cursor.getString(4),cursor.getInt(5),cursor.getString(6)));
                    }while(cursor.moveToNext());
                }
                final TicketAdapter adapter=new TicketAdapter(MainActivity.this,tickets);
                results.setAdapter(adapter);
                db.close();
            }
        });

    }
}
