package com.gmail.moontae0317.memory.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gmail.moontae0317.memory.R

class AddMemoryActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_memory)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_camera->{

            }
            R.id.btn_photo->{

            }
        }
    }
}
