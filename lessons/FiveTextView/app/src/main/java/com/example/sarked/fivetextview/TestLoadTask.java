package com.example.sarked.fivetextview;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestLoadTask extends AsyncTask<String, Void, String> {

    public TextView textView;
    public TestLoadTask(TextView view){
        super();
        this.textView=view;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader( new InputStreamReader(is));
            String line ="";
            StringBuffer buffer = new StringBuffer();
            while ((line=reader.readLine())!=null){
                buffer.append(line);
            }
            return buffer.toString();
        } catch (Exception e)  {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(String result){
        //пишем в здешнюю текствьюшку, чтобы не возвращаться в мейактивити
        this.textView.setText(result);
  }
}
