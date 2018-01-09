package com.example.sarked.textquest;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MyTask extends AsyncTask <Void,Void,Void>{

    Context context;
    int minute;
    int a=1;
    MyTask (Context con){
        context=con;
    }
    @Override
    protected Void doInBackground(Void... params) {

        while (a==1) {
            try {
                //Thread.sleep(4000);
                TimeUnit.MINUTES.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress();
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Void... params) {
        MainActivity.self.getMoney();
    }
}