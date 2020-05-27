package com.gmail.moontae0317.memory

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memories")
data class Memory(
    @ColumnInfo(name = "memory_date") val date : String,
    @ColumnInfo(name = "memory_who") val who : String,
    @ColumnInfo(name = "memory_latitude") val latitude : Double,
    @ColumnInfo(name = "memory_longitude") val longitude : Double,
    @ColumnInfo(name = "memory_location") val location : String,
    @ColumnInfo(name = "memory_picture", typeAffinity = ColumnInfo.BLOB) val picture : ByteArray?,
    @ColumnInfo(name = "memory_content") val content: String?
){
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "memory_id") val id : Int =0
}
