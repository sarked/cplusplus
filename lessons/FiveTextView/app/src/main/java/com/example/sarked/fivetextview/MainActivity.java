package com.example.sarked.fivetextview;

import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.widget.ImageView;
import android.widget.TextView;

import junit.framework.Test;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = (TextView)findViewById(R.id.tv1);
        TextView tv2 = (TextView)findViewById(R.id.tv2);
        TextView tv3 = (TextView)findViewById(R.id.tv3);
        TextView tv4 = (TextView)findViewById(R.id.tv4);
        TextView tv5 = (TextView)findViewById(R.id.tv5);

        TestLoadTask task1=new TestLoadTask(tv1);
        task1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"http://213.184.249.183/text/130");
        TestLoadTask task2=new TestLoadTask(tv2);
        task2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"http://213.184.249.183/text/120");
        TestLoadTask task3=new TestLoadTask(tv3);
        task3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"http://213.184.249.183/text/110");
        TestLoadTask task4=new TestLoadTask(tv4);
        task4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"http://213.184.249.183/text/90");
        TestLoadTask task5=new TestLoadTask(tv5);
        task5.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"http://213.184.249.183/text/70");

        ImageView iv = (ImageView)findViewById(R.id.iv);
        ImageLoadTask task6=new ImageLoadTask(iv);
        task6.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"https://vignette.wikia.nocookie.net/wow/images/c/c3/Inv_trinket_honorhold.png/revision/latest?cb=20170402122556&path-prefix=ru");
    }
}
