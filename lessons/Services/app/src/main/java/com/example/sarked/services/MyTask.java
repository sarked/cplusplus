package com.example.sarked.services;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class MyTask extends AsyncTask <Void,Void,Void>{

    Context context;
    int a=1;
    MyTask (Context con){
        context=con;
    }
    @Override
    protected Void doInBackground(Void... params) {

    while (a==1) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publishProgress();
    }
        return null;
    }
    @Override
    protected void onProgressUpdate(Void... params) {
        Toast.makeText(context, String.valueOf("привет"), Toast.LENGTH_SHORT).show();
    }
}
