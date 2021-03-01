package com.example.sensor_play;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class SensorActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManger;
    private Sensor mSensor;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManger.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
            mSensor = mSensorManger.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManger.registerListener(this,
                mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManger.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSensorManger = null;
        mSensor = null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}