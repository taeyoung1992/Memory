package com.gmail.moontae0317.memory.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.gmail.moontae0317.memory.R
import com.gmail.moontae0317.memory.ui.user.UserActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlin.concurrent.timer

class SplashActivity : AppCompatActivity() {

    //private var samplingValue : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //samplingValue = 100

        //imageLoading()
        appTitleAnimation()

    }

    fun appTitleAnimation(){
        val anim = AnimationUtils.loadAnimation(this,R.anim.alpha)
        img_title.startAnimation(anim)
        timer(period = 1000,initialDelay = 3000){
            val intent = Intent(this@SplashActivity, UserActivity::class.java)
            startActivity(intent)
            finish()
            cancel()
        }
    }


//    fun imageLoading() {
//        for(loop in 1..10){
//            runOnUiThread(Runnable {
//                setImage()
//                Log.d("sam","${samplingValue}")
//                samplingValue = samplingValue.minus(10)
//                Log.d("sam2","${samplingValue}")
//                if(samplingValue<10){
//                    val intent = Intent(this, UserActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//                Thread.sleep(5000)
//            })
//        }
//    }
//
//    fun setImage(){
//
//        Glide.with(this).load(R.drawable.android).apply(RequestOptions.bitmapTransform(BlurTransformation(30,samplingValue))).transition(
//            DrawableTransitionOptions.withCrossFade()).into(splashImage)
//
//    }

}
