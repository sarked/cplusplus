package com.example.sarked.asynchron2;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

public class RunTask extends AsyncTask<Integer, Integer, String> {
    String textViewName;
    TextView textView;

    RunTask(String tvn,TextView tv){
        textViewName = tvn;
        textView = tv;

    }


    protected String doInBackground(Integer... params){

        int speed = params[0];
        int distMin = params[1];
        int distMax = params[2];
        int i=0;

        Random random=new Random();
        //цикл с записью всех чисел от и до???
        int[] dist = {distMin,distMax};
        int finDist = dist[random.nextInt(dist.length)];

        while(i<42800){
            try{
                Thread.sleep(speed);
                i=i+finDist;
                publishProgress(i);
            }catch (InterruptedException e){
            }
        }
        return textViewName;
    }

    protected void onProgressUpdate(Integer... params){
//отправить полученое число и записать в текствьюшку нужного существа
        int val = params[0];
        //метод для записи в нужную текствьюшку
        MainActivity.self.showProgress(textView, val);
    }

    protected void onPostExecute(String result){

        //кто прибежал первым?
        MainActivity.self.onFinish(result);
    }
}
