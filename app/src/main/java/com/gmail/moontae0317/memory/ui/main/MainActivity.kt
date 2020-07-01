package com.gmail.moontae0317.memory.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.gmail.moontae0317.memory.data.db.MemoryDatabase
import com.gmail.moontae0317.memory.R
import com.gmail.moontae0317.memory.data.db.Memory
import com.gmail.moontae0317.memory.ui.memoryList.MemoryListActivity
import com.gmail.moontae0317.memory.utils.ConvertUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var db : MemoryDatabase
    var userName : String = ""
    lateinit var adapter : RecyclerAdapter
    var selectedMemory : Int = 3



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUserName()

        btn_map.setOnClickListener {
            val testInsertMemory = Memory(0,"06.27","문태영",12.111,13.1111,"서울",ConvertUtils().BitmapToByteArray(ConvertUtils().drawableToBitmap(this,R.drawable.apple)),"내용무")
            db?.memoryDao()?.insertMemory(testInsertMemory)
        }
        btn_memoryList.setOnClickListener {
            val intent = Intent(this,MemoryListActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    fun initUserName(){
        //자동로그인(유저이름 받아오기)
        val userName = getSharedPreferences("user", Context.MODE_PRIVATE).getString("userName","null")
        text_user.text = userName
        initDatabase()
        setRecyclerView()
    }

    fun initDatabase(){
        if(userName != "null"){
            //로그인한 유저가 있으면 데이터베이스 생성
            db = Room.databaseBuilder(this, MemoryDatabase::class.java,"${userName}_memory.db").allowMainThreadQueries().build()
        }
    }

    fun setRecyclerView(){
        if(db?.memoryDao()?.getAllMemories()?.size!! >0){
            text_noItem.visibility = View.INVISIBLE
            //저장된 데이터 있으면 리사이클뷰에 뿌려주기
            adapter = RecyclerAdapter(db?.memoryDao()?.getAllMemories() as ArrayList<Memory>)
            recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
            recyclerView.adapter = adapter
        }else{
            text_noItem.visibility = View.VISIBLE
        }
    }



}
