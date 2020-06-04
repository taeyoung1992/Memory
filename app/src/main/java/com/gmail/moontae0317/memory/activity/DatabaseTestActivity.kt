package com.gmail.moontae0317.memory.activity

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.gmail.moontae0317.memory.database.Memory
import com.gmail.moontae0317.memory.database.MemoryDatabase
import com.gmail.moontae0317.memory.R
import kotlinx.android.synthetic.main.activity_database_test.*
import java.io.ByteArrayOutputStream

class DatabaseTestActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var db : MemoryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_test)

        db = Room.databaseBuilder(this, MemoryDatabase::class.java,"memory.db").allowMainThreadQueries().build()


    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_insert -> {
                Log.d("11111","성공")
                db.memoryDao().insertMemory(
                    Memory(
                        date = edit_date.text.toString(),
                        who = edit_who.text.toString(),
                        latitude = edit_latitude.text.toString().toDouble(),
                        longitude = edit_longitude.text.toString().toDouble(),
                        location = edit_location.text.toString(),
                        picture = null,
                        content = null
                    )
                )
                textView.text = db.memoryDao().getAllMemories().joinToString()

            }
            R.id.btn_update -> {
                db.memoryDao().updateMemory(
                    Memory(
                        date = edit_date.text.toString(),
                        who = edit_who.text.toString(),
                        latitude = edit_latitude.text.toString().toDouble(),
                        longitude = edit_longitude.text.toString().toDouble(),
                        location = edit_location.text.toString(),
                        picture = null,
                        content = null
                    )
                )
                textView.text = db.memoryDao().getAllMemories().joinToString()
            }
            R.id.btn_delete -> {
                db.memoryDao().deleteMemory(
                    Memory(
                        date = edit_date.text.toString(),
                        who = edit_who.text.toString(),
                        latitude = edit_latitude.text.toString().toDouble(),
                        longitude = edit_longitude.text.toString().toDouble(),
                        location = edit_location.text.toString(),
                        picture = null,
                        content = null
                    )
                )
                textView.text = db.memoryDao().getAllMemories().joinToString()
            }
        }
    }
}
