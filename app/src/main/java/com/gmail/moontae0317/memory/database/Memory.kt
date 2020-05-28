package com.gmail.moontae0317.memory.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memories")
data class Memory(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "memory_id") val id : Int,
    @ColumnInfo(name = "memory_date") val date : String,
    @ColumnInfo(name = "memory_who") val who : String,
    @ColumnInfo(name = "memory_latitude") val latitude : Double,
    @ColumnInfo(name = "memory_longitude") val longitude : Double,
    @ColumnInfo(name = "memory_location") val location : String,
    @ColumnInfo(name = "memory_picture", typeAffinity = ColumnInfo.BLOB) val picture : ByteArray?,
    @ColumnInfo(name = "memory_content") val content: String?
)
