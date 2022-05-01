package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.stopwatch.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private var time = 0
    private var timerTask: Timer? = null
    private var isRunning = false
    private var lap = 1

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            isRunning = !isRunning  // 타이머 반전시키기

            if (isRunning) {
                start()
            } else {
                pause()
            }
        }

        binding.lapButton.setOnClickListener {
            recordLapTime()
        }
    }

    private fun start() {
       binding.fab.setImageResource(R.drawable.ic_baseline_pause_24)
       timerTask = timer(period = 10) {
           time++
           val sec = time / 100
           val milli = time % 100
           runOnUiThread {
               binding.secTextView.text = "$sec"
               binding.milliTextView.text = "$milli"
           }
       }
    }

    private fun pause() {
        binding.fab.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        timerTask?.cancel()
    }

    private fun recordLapTime() {
        val lapTime = this.time
        val textView = TextView(this)
        textView.text = "$lap LAP : ${lapTime / 100}.${lapTime % 100}"

        // 맨 위에 랩타임 추가
        binding.lapLayout.addView(textView, 0)
        lap++
    }
}