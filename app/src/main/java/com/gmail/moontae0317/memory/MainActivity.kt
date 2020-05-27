package com.gmail.moontae0317.memory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var db : MemoryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_databaseTest.setOnClickListener {
            var intent = Intent(this,DatabaseTestActivity::class.java)
            startActivity(intent)
        }

    }
}
