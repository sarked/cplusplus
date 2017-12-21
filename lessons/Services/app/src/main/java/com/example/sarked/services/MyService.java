package com.example.sarked.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;


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
        task.cancel(true);
    }
}
