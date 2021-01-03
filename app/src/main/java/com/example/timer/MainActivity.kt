package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var isFirstTime:Boolean = true
    var isTimeRunning:Boolean = false
    var segundsTotal = 10
    var points = 0
    fun orchestror(view: View){

        if (isFirstTime) {
            timer()
            isFirstTime = false
            isTimeRunning = true
        }
        if (!isFirstTime && isTimeRunning){
            points +=1
            pointsLabel.text = points.toString()
        }
    }
    fun timer(){
        val timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                segundsTotal -=1
                timeLabel.text = segundsTotal.toString()
            }

            override fun onFinish() {
                isTimeRunning = false
            }
        }
        timer.start()
    }
}