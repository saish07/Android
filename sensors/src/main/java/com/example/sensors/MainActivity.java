package com.example.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SensorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager)getSystemService(SENSOR_SERVICE);

        gravity();
    }

    private void light(){

        manager.registerListener(

                new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent event) {
                        ((TextView) findViewById(R.id.textView))
                                .setText(String.valueOf(event.values[0]));
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int accuracy) {

                    }
                },
                manager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_NORMAL
        );
    }

    private void proximity() {

        manager.registerListener(

                new SensorEventListener() {

                    @Override
                    public void onSensorChanged(SensorEvent event) {
                        ((TextView) findViewById(R.id.textView))
                                .setText(String.valueOf(event.values[0]));
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int accuracy) {

                    }
                },
                manager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_NORMAL
        );
    }


    private void gravity() {

        manager.registerListener(

                new SensorEventListener() {

                @Override
                public void onSensorChanged(SensorEvent event) {

                    ((TextView) findViewById(R.id.textView))
                            .setText("x - " + event.values[0] + " y - " + event.values[1] + " z - " + event.values[2]);
                }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int accuracy) {

                    }
                },

                manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),

                SensorManager.SENSOR_DELAY_NORMAL

        );

        }


}
