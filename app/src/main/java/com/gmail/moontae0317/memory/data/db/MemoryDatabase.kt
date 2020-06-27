package com.gmail.moontae0317.memory.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gmail.moontae0317.memory.data.db.Memory
import com.gmail.moontae0317.memory.data.db.MemoryDao

@Database(entities = arrayOf(Memory::class), version = 1)
abstract class MemoryDatabase : RoomDatabase(){
    abstract fun memoryDao() : MemoryDao

    //데이터베이스 객체를 반환하거나 제거할 수 있도록 getInstance()와 destroyInstance() 메소를 생성
    //비동기처리 수정해야함 (rxkotlin 공부)
    /*
    companion object{
        private var INSTANCE : MemoryDatabase ? = null

        fun getInstance(context : Context) : MemoryDatabase?{
            if(INSTANCE == null){
                synchronized(MemoryDatabase::class){
                    //allowMainThreadQueries() 테스트를 위해 임시 사용 rxkotlin 숙지 후 비동기 처리로 수정해야함
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MemoryDatabase::class.java,"memory.db").allowMainThreadQueries().build()

                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
     */
}