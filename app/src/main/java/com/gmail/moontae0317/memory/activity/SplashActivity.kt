package com.gmail.moontae0317.memory.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gmail.moontae0317.memory.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startLoading()
    }
    fun startLoading(){
        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(this,UserActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}
