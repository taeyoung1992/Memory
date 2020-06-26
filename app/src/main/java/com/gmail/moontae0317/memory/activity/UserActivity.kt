package com.gmail.moontae0317.memory.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.moontae0317.memory.R
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        userCheck()

    }

    fun userCheck(){
        val pref = getSharedPreferences("user", Context.MODE_PRIVATE)
        val editor = pref.edit()
        val userName = pref.getString("userName","null")
        if(userName == "null"){
            btn_next.setOnClickListener {
                editor.putString("userName",edit_user.text.toString())
                editor.commit()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }else{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}
