package com.example.tiltsensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(), SensorEventListener {

    private val sensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),  // TYPE_ACCELEROMETER : 가속도 센서
        SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {    // 센서 정밀도가 변경되면 호출됨
        // values[0] : x축 - 위로 기울이면 -10 ~ 0, 아래로 기울이면 0 ~ 10
        // values[1] : y축 - 왼쪽으로 기울이면 -10 ~ 0, 오른쪽으로 기울이면 0 ~ 10
        // values[2] : z축 - 미사용
        event?.let {
            Log.d("MainActivity", "onSensorChanged: x : ${event.values[0]}," +
                    " y : ${event.values[1]}, z : ${event.values[2]}")
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {  // 센서값이 변경되면 호출됨
        TODO("Not yet implemented")
    }
}