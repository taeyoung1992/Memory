package com.gmail.moontae0317.memory.database

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.ResourceCursorAdapter
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gmail.moontae0317.memory.R
import com.gmail.moontae0317.memory.activity.DatabaseTestActivity
import com.nightonke.boommenu.Util.getDrawable
import java.io.ByteArrayOutputStream

@Entity(tableName = "memories")
data class Memory(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "memory_id") val id: Int = 0,
    @ColumnInfo(name = "memory_date") val date: String,
    @ColumnInfo(name = "memory_who") val who: String,
    @ColumnInfo(name = "memory_latitude") val latitude: Double,
    @ColumnInfo(name = "memory_longitude") val longitude: Double,
    @ColumnInfo(name = "memory_location") val location: String,
    @ColumnInfo(name = "memory_picture", typeAffinity = ColumnInfo.BLOB) val picture: ByteArray?,
    @ColumnInfo(name = "memory_content") val content: String?
)






