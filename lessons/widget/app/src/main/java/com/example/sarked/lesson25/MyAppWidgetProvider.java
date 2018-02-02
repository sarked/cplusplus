package com.example.sarked.lesson25;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Random;

public class MyAppWidgetProvider extends AppWidgetProvider {



    @Override
    public void onEnabled(Context ctx){
        super.onEnabled(ctx);
        Toast.makeText(ctx, "onEnabled", Toast.LENGTH_SHORT).show();
        //вызывается, когда добавляем первый виджет на раб стол
    }

    @Override
    public void onDisabled(Context ctx){
        super.onDisabled(ctx);
        Toast.makeText(ctx, "onDisabled", Toast.LENGTH_SHORT).show();
        //когда удаляем какой-либо виджет с раб стола
    }

    @Override
    public void onDeleted(Context ctx, int[] ids){
        super.onDeleted(ctx, ids);
        Toast.makeText(ctx, "onDeleted", Toast.LENGTH_SHORT).show();
        //когда удаляем все существующие экземпляры виджета
    }

    @Override
    public void onUpdate(Context ctx, AppWidgetManager awm, int[] ids){
        super.onUpdate(ctx, awm, ids);
        Toast.makeText(ctx, "onUpdate", Toast.LENGTH_SHORT).show();
        //по обновлению инфы виджета, раз в 30 минут или по бродкасту

        RemoteViews views = new RemoteViews(ctx.getPackageName(), R.layout.widget);
        final Random random = new Random();
        String text=random.nextInt(100)+"";
        views.setTextViewText(R.id.textView, text);

        //код1
        //открытие при клике
        //айдишник элемента, на который кликаем
//        views.setOnClickPendingIntent(R.id.layout,
//                PendingIntent.getActivity(ctx,0,
//                        //какая активность, можно сделать интент заранее и напихать в него данных
//                        new Intent(ctx, MainActivity.class),0));


        //код2
        //способ вызова метода onReсеive нажатием. Вызывается бродкас с ссылкой на класс
        Intent intent = new Intent(ctx,getClass());
        views.setOnClickPendingIntent(R.id.layout,
                PendingIntent.getBroadcast(ctx,0,intent,0));


        views.setOnClickPendingIntent(R.id.profile,
                PendingIntent.getActivity(ctx,0,
                        new Intent(ctx, MainActivity.class),0));
        views.setOnClickPendingIntent(R.id.news,
                PendingIntent.getActivity(ctx,0,
                        new Intent(ctx, NewsActivity.class),0));
        views.setOnClickPendingIntent(R.id.mess,
                PendingIntent.getActivity(ctx,0,
                        new Intent(ctx, MessActivity.class),0));
        //в самом конце всегда
        awm.updateAppWidget(ids, views);
    }

    @Override
    public void onReceive(Context ctx, Intent intent){
        super.onReceive(ctx, intent);
        Toast.makeText(ctx, "onReceive", Toast.LENGTH_SHORT).show();
        //когда класс, зареганный как широковещательный приемник, получает соотвествующее событие


        //обновление при клике
        RemoteViews views = new RemoteViews(ctx.getPackageName(), R.layout.widget);
        AppWidgetManager awm = AppWidgetManager.getInstance(ctx);

        ComponentName widget=new ComponentName(ctx,MyAppWidgetProvider.class);

        final Random random = new Random();
        String text=random.nextInt(100)+"";
        views.setTextViewText(R.id.textView, text);

        awm.updateAppWidget(widget, views);

    }


}

