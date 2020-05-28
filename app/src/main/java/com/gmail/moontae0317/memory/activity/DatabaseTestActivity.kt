package com.gmail.moontae0317.memory.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.gmail.moontae0317.memory.database.Memory
import com.gmail.moontae0317.memory.database.MemoryDatabase
import com.gmail.moontae0317.memory.R
import kotlinx.android.synthetic.main.activity_database_test.*

class DatabaseTestActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var db : MemoryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_test)

        db = Room.databaseBuilder(this, MemoryDatabase::class.java,"memory.db").allowMainThreadQueries().build()

        btn_insert.setOnClickListener(this)
        btn_delete.setOnClickListener(this)
        btn_update.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_insert -> {
                Log.d("11111","성공")
                db.memoryDao().insertMemory(
                    Memory(
                        0,
                        edit_date.text.toString(),
                        edit_who.text.toString(),
                        edit_latitude.text.toString().toDouble(),
                        edit_longitude.text.toString().toDouble(),
                        edit_location.text.toString(),
                        null,
                        null
                    )
                )
                textView.text = db.memoryDao().getAllMemories().joinToString()

            }
            R.id.btn_update -> {
                db.memoryDao().updateMemory(
                    Memory(
                        edit_id.text.toString().toInt(),
                        edit_date.text.toString(),
                        edit_who.text.toString(),
                        edit_latitude.text.toString().toDouble(),
                        edit_longitude.text.toString().toDouble(),
                        edit_location.text.toString(),
                        null,
                        null
                    )
                )
                textView.text = db.memoryDao().getAllMemories().joinToString()
            }
            R.id.btn_delete -> {
                db.memoryDao().deleteMemory(
                    Memory(
                        edit_id.text.toString().toInt(),
                        edit_date.text.toString(),
                        edit_who.text.toString(),
                        edit_latitude.text.toString().toDouble(),
                        edit_longitude.text.toString().toDouble(),
                        edit_location.text.toString(),
                        null,
                        null
                    )
                )
                textView.text = db.memoryDao().getAllMemories().joinToString()
            }
        }
    }
}