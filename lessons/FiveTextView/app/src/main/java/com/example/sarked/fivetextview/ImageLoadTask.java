package com.example.sarked.fivetextview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoadTask extends AsyncTask<String, Void, Bitmap> {

    public ImageView imgView;
    public ImageLoadTask(ImageView view){
        super();
        this.imgView=view;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            return BitmapFactory.decodeStream(is);
        } catch (Exception e)  {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Bitmap result){
        //пишем в здешнюю текствьюшку, чтобы не возвращаться в мейактивити
        this.imgView.setImageBitmap(result);
    }
}
