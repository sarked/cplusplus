package com.example.sarked.graphic;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView info;
    TextView secondInfo;
    TextView lastInfo;
    LinearLayout layout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = (TextView)findViewById(R.id.info);
        secondInfo = (TextView)findViewById(R.id.secondInfo);
        lastInfo = (TextView)findViewById(R.id.lastInfo);
        layout = (LinearLayout) findViewById(R.id.layout);
        btn = (Button)findViewById(R.id.btn) ;


        SensorManager manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        //List<Sensor> sensor = manager.getSensorList(Sensor.TYPE_ALL);
        List<Sensor> sensor = manager.getSensorList(Sensor.TYPE_LIGHT);

        String str="";
        for (Sensor s: sensor){
            str +=s.getName()+"\n";
        }
        info.setText(str);


        //выбор какой сенсор юзать
        //Sensor lightSensor = sensors.get(0);
        Sensor lightSensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);

        //обработчик
        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                //event.values[0]
                info.setText("Свет: "+String.valueOf(event.values[0]));
                if (event.values[0]>=110){
                    layout.setBackgroundColor(Color.WHITE);
                    info.setTextColor(Color.BLACK);
                    secondInfo.setTextColor(Color.BLACK);
                    lastInfo.setTextColor(Color.BLACK);
                }else{
                    layout.setBackgroundColor(Color.BLACK);
                    info.setTextColor(Color.WHITE);
                    secondInfo.setTextColor(Color.WHITE);
                    lastInfo.setTextColor(Color.WHITE);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        //регистрация сенсора, (послали обработчик, привязали к сенсору, показали на сколько часто хотим получать эти данные(4 варика))
        manager.registerListener(listener, lightSensor, SensorManager.SENSOR_DELAY_FASTEST);

        Sensor proximitySensor = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener secListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                secondInfo.setText("Растояние: "+String.valueOf(event.values[0]));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        manager.registerListener(secListener, proximitySensor, SensorManager.SENSOR_DELAY_FASTEST);

        Sensor orientationSensor = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        SensorEventListener lastListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                lastInfo.setText("ax: "+String.valueOf(event.values[0])+" \n"
                        +"ay: "+String.valueOf(event.values[1])+" \n"
                        +"az: "+String.valueOf(event.values[2]));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        manager.registerListener(lastListener, orientationSensor, SensorManager.SENSOR_DELAY_FASTEST);


        //оповещения
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });

// лекция 25


    }

    public void sendNotification(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        //три обязательных параметра для вывода

        //иконка возможно слишком большая
        builder.setSmallIcon(R.drawable.scroll)
                .setContentTitle("Тайтл")
                .setContentText("Текст");
        //и чтоб не пропало
        builder.setAutoCancel(false);
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),MainActivity.class);

        TaskStackBuilder taskBuilder=TaskStackBuilder.create(this);
        taskBuilder.addParentStack(MainActivity.class);
        taskBuilder.addNextIntent(intent);
        PendingIntent pintent = taskBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pintent);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1,builder.build());


    }
}
