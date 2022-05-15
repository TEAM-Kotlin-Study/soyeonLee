package com.example.tiltsensor

import TiltView
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var tiltView: TiltView

    private val sensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) // 화면이 꺼지지 않도록
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE // 화면이 가로 모드로 고정
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tiltView = TiltView(this)
        setContentView(tiltView)
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

    override fun onSensorChanged(event: SensorEvent?) {
        // 센서 정밀도가 변경되면 호출됨
        // values[0] : x축 - 위로 기울이면 -10 ~ 0, 아래로 기울이면 0 ~ 10
        // values[1] : y축 - 왼쪽으로 기울이면 -10 ~ 0, 오른쪽으로 기울이면 0 ~ 10
        // values[2] : z축 - 미사용
        event?.let {
            Log.d(TAG, "onSensorChanged: x : ${event.values[0]}," +
                    " y : ${event.values[1]}, z : ${event.values[2]}")

            tiltView.onSensorEvent(event)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {  // 센서값이 변경되면 호출됨
        TODO("Not yet implemented")
    }
}