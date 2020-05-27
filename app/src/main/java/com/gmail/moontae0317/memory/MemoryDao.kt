package com.gmail.moontae0317.memory

import androidx.room.*

@Dao
interface MemoryDao {
    @Insert
    fun insertMemory(vararg memory: Memory)

    @Update
    fun updateMemory(memory: Memory)

    @Delete
    fun deleteMemory(memory: Memory)

    //선택한 날짜 안에 있는 모든 메모리 데이터 가져오기
    @Query("SELECT * FROM memories WHERE memory_date BETWEEN (:firstDate) AND (:lastDate)")
    fun loadMemoryForDate(firstDate : String, lastDate : String):ArrayList<Memory>

    //선택한 지역에 해당하는 모든 메모리 데이터 가져오기
    @Query("SELECT * FROM memories WHERE memory_location IN (:location)")
    fun loadMemoryBasedOnLocation(location : String) : ArrayList<Memory>

    //전체 사진 목록 받아오기
    @Query("SELECT memory_picture FROM memories")
    fun getAllPicture():ArrayList<ByteArray>

    //전체 메모리 데이터 가져오기
    @Query("SELECT * FROM memories")
    fun getAllMemories():ArrayList<Memory>
    
}