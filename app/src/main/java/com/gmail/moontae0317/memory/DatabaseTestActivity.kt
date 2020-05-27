package com.gmail.moontae0317.memory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
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
                db.memoryDao().insertMemory(
                    Memory(
                    edit_date.text.toString(),edit_who.text.toString(),
                        edit_latitude.text.toString().toDouble(),edit_longitude.text.toString().toDouble(),
                        edit_location.text.toString(),null,null)
                )
                textView.text = db.memoryDao().getAllMemories().joinToString()

            }
            R.id.btn_update -> {

            }
            R.id.btn_delete -> {

            }
        }
    }
}
