package com.example.sarked.asynchron2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static MainActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self=this;

        TextView rabbit = (TextView)findViewById(R.id.rabbit);
        TextView fox = (TextView)findViewById(R.id.fox);

        RunTask task=new RunTask("Заяц", rabbit);
        //task.execute(40,60,80);
        RunTask taskFox=new RunTask("Лис", fox);
        //taskFox.execute(60,90,120);

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 40,60,80);
        taskFox.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 60,90,120);

    }

    void showProgress(TextView tv, int val){
        String a=String.valueOf(val);
        tv.setText(a);

    }
    void onFinish(String res){
        Toast.makeText(getApplicationContext(), res+" прибежал", Toast.LENGTH_SHORT).show();
        //как узнать
    }
}
