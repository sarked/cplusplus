package com.example.sarked.chat;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MyTask extends AsyncTask<Void,String,String>{
   Context context=MainActivity.self;
    ArrayList <String> massage;
    MyTask (Context con, ArrayList<String>m){
//        передавать контекст в конструкторе? два списка, выдергивать из них
        context=con;
        massage=m;
    }
    @Override
    protected String doInBackground(Void... params) {
        //бесконечный или долгий цикл
        //кидает в базу данных 3 рандомное кто-сообщение
        Random random=new Random();
        int b=0; int a=1; int c=0;
        while (a==1){
            b=random.nextInt(massage.size());
            c=3+random.nextInt(9);
            //System.out.println(massage.get(b)+" спустя "+c+"000");
            try {
                Thread.sleep(c*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(massage.get(b));
        }
        return null;
    }

    protected void onProgressUpdate(String... result) {
        //при закрытом приложении одно сообщение, при открытом что? ничего?

        String val = result[0];
        Toast.makeText(MainActivity.self, val, Toast.LENGTH_SHORT).show();
        MainActivity.self.showProgress(val);


    }
}
