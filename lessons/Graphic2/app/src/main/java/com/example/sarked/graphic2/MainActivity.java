package com.example.sarked.graphic2;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
//        Button btn = (Button)findViewById(R.id.btn);
//        ImageView img1 = (ImageView) findViewById(R.id.img1);
//        ImageView img2 = (ImageView) findViewById(R.id.img2);
//
//        final TransitionDrawable td=(TransitionDrawable)getResources().getDrawable(R.drawable.animation);
//        img1.setImageDrawable(td);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                td.startTransition(2000);
//            }
//        });
//
//        //кривая
//        Path p = new Path();
//        p.moveTo(500,330);
//        p.lineTo(600,600);
//        p.lineTo(400,400);
//        p.lineTo(600,400);
//        p.lineTo(400,600);
//        p.lineTo(500,330);
//        //отрисовка фигур
//        PathShape sp = new PathShape (p,600,600);
//        ShapeDrawable sd = new ShapeDrawable(sp);
//        //задать размеры фигуры на картинке
//        sd.setIntrinsicHeight(60);
//        sd.setIntrinsicWidth(60);
//        //sd.getPaint().setStyle(Paint.Style.STROKE);
//        sd.getPaint().setColor(getResources().getColor(R.color.colorAccent));
//        img2.setImageDrawable(sd);


        //surfaceView

        setContentView(new MySurfaceView(this));
    }
}
