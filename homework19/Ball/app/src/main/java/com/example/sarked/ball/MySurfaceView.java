package com.example.sarked.ball;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private boolean isActive=true;
    private RenderThread th;
    private SurfaceHolder holder;
    //начальные координаты шара
    float y=0;
    float x=0;

    float ay=0;
    float ax=0;

    //скорость шарика по оси y (100 пкс в сек вниз)
    float v=100;
    //сюда будем сохранять время, в которое был отрисован предыдущий кадр
    long prevTS=0;
    public MySurfaceView(Context context) {
        super(context);
        this.holder=getHolder();
        this.holder.addCallback(this);
    }
    SensorManager manager = (SensorManager)this.getContext().getSystemService(Context.SENSOR_SERVICE);
    Sensor orientationSensor = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);



    SensorEventListener lastListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            ay=event.values[1];
            ax=event.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    //manager.registerListener(lastListener, orientationSensor, SensorManager.SENSOR_DELAY_FASTEST);



    class RenderThread extends Thread{
        public void run(){
            while (MySurfaceView.this.isActive){
                MySurfaceView.this.render();

                manager.registerListener(lastListener, orientationSensor, SensorManager.SENSOR_DELAY_FASTEST);
            }
        }
    }

    public void render(){
        //узнаем нынешнее время
        long TS = System.currentTimeMillis();
        long diff = TS-prevTS;

        //если предыдущий кадр был меньше, чем 20 милисек назад, то ретурн, не идет дальше
        if (diff<20){
            return;
        }

        y+=-(ay*2);
        x+=-(ax*2);
        //перерисовываем
        if (holder.getSurface().isValid()){
            //блочим холст, чтоб другие не могли нарисовать другое
            Canvas c=holder.lockCanvas();
//границы
            System.out.println("y: "+y+"; x: "+x);
            if(y>=c.getHeight()){
                y=c.getHeight();
            }
            if(y<0){
                y=0;
            }
            if(x>=c.getWidth()){
                x=c.getWidth();
            }
            if(x<0){
                x=0;
            }
            c.drawColor(Color.BLACK);
            Paint p = new Paint();
            p.setColor(Color.RED);
            p.setStyle(Paint.Style.FILL);
            if(prevTS == 0){
                y = c.getHeight()/2;
                x = c.getWidth()/2;
            }
            c.drawCircle(x,y,30,p);

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