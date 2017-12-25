package com.example.sarked.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MyBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Вы снова в чате!", Toast.LENGTH_SHORT).show();
        Intent serviceIntent = new Intent(context, MyService.class);
        context.startService(serviceIntent);

        }
}