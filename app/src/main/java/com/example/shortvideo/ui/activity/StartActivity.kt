package com.example.shortvideo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.shortvideo.R

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        /*
        * 开一个线程用于倒计时启动界面
        */
        Thread {
            try {
                Thread.sleep(1800L)
                MainActivity.startActivity(this@StartActivity)
                finish()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }.start()
    }
}