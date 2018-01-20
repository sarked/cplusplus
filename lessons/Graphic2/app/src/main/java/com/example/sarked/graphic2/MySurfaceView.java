package com.example.sarked.graphic2;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private boolean isActive=true;
    private RenderThread th;
    private SurfaceHolder holder;
    int vector=1;
    //скорость шарика по оси y (100 пкс в сек вниз)
    float v=100;
    //сюда будем сохранять время, в которое был отрисован предыдущий кадр
    long prevTS=0;
    //y - фактическое местоположение шарика
    float y=0;

    public MySurfaceView(Context context) {
        super(context);
        this.holder=getHolder();
        this.holder.addCallback(this);


    }

    class RenderThread extends Thread{
        public void run(){
            while (MySurfaceView.this.isActive){
                MySurfaceView.this.render();
            }
        }
    }

    public void render(){

        System.out.print("render!");
        //узнаем нынешнее время
        long TS = System.currentTimeMillis();
        long diff = TS-prevTS;
        //если предыдущий кадр был меньше, чем 20 милисек назад, то ретурн, не идет дальше
        if (diff<20){
            return;
        }

        float dy=(diff*v)/1000;
        y+=dy;
        //перерисовываем
        if (holder.getSurface().isValid()){
            //блочим холст, чтоб другие не могли нарисовать другое
            Canvas c=holder.lockCanvas();
//изменение координат шарика
            if(y>=c.getHeight()||y<=0){
                v=-v;
            }
            c.drawColor(Color.BLACK);
            Paint p = new Paint();
            p.setColor(getResources().getColor(R.color.colorAccent));
            p.setStyle(Paint.Style.FILL);
            if(prevTS == 0){
                y = c.getHeight()/2;
            }
            c.drawCircle(c.getWidth()/2,y,100,p);

            //а тут разблокировка холста
            holder.unlockCanvasAndPost(c);
        }


        prevTS=TS;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.holder = holder;
        //вызов бесконечного потока, который будет вызывать метод render();
        th=new RenderThread();
        th.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.holder = holder;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        this.isActive=false;
    }
}
