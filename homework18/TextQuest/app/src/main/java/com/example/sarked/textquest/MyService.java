package com.example.sarked.textquest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class MyService extends Service {
    MyTask task=null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //для запуска из программного потока
        return null;
    }

    @Override
    public void onCreate(){
        //запускается один раз
        task = new MyTask(this);
        task.execute();
    }

    @Override
    public void onDestroy(){
        //task.cancel(true);
        //если тут будет пусто, то при отчистке памяти сервис будет продолжать работать
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    public void reload(){
        task.cancel(true);
        task = new MyTask(this);
        task.execute();
        Toast.makeText(getApplicationContext(),"Отсчет сброшен. Прибыль ускорена в два раза", Toast.LENGTH_SHORT).show();
    }


}