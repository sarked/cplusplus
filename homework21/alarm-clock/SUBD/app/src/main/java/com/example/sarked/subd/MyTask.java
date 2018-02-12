package com.example.sarked.subd;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class MyTask extends AsyncTask <Void,String,Void>{

    Context context;
    ArrayList <Contact> list;
    int minute;
    int a=1;
    SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
    MyTask (Context con, ArrayList<Contact> l){
        context=con;
        list=l;
    }
    @Override
    protected Void doInBackground(Void... params) {


        while (a==1) {
            String currentTime = sdf.format(new Date());

            Iterator<Contact> iter = list.iterator();
            while(iter.hasNext()) {
                Contact x=iter.next();
                String xTime=x.hour+":"+x.min;
                if (currentTime.equals(xTime)){
                    publishProgress(x.name);
                }
            }
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(String... params) {
        String val = params[0];
        MainActivity.self.dingding(val);
    }
}