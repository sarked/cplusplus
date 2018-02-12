package com.example.sarked.subd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;


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
        task = new MyTask(this, MainActivity.list);
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

}