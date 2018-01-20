package com.example.sarked.ball;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setContentView(new MySurfaceView(this));
//
//        final TextView ay = (TextView)findViewById(R.id.ay);
//        final TextView ax = (TextView)findViewById(R.id.ax);
//
//        SensorManager manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
//
//
//        Sensor orientationSensor = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
//        SensorEventListener lastListener = new SensorEventListener() {
//            @Override
//            public void onSensorChanged(SensorEvent event) {
//                ay.setText(String.valueOf(event.values[1]));
//                ax.setText(String.valueOf(event.values[2]));
//            }
//
//            @Override
//            public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//            }
//        };
//        manager.registerListener(lastListener, orientationSensor, SensorManager.SENSOR_DELAY_FASTEST);

    }
}
