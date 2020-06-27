package com.gmail.moontae0317.memory.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class ConvertUtils(){
    fun byteArrayToBitmap(byteArray: ByteArray):Bitmap{
        var bitmap : Bitmap? = null
        val byteArrayInputStream = ByteArrayInputStream(byteArray)
        bitmap = BitmapFactory.decodeStream(byteArrayInputStream)
        return bitmap!!
    }

    fun BitmapToByteArray(bitmap: Bitmap):ByteArray{
        var byteArray : ByteArray? = null
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        byteArray = stream.toByteArray()
        return byteArray!!
    }

    fun drawableToBitmap(context: Context, resource: Int):Bitmap{
        var bitmap : Bitmap? = null
        val drawable = context.resources.getDrawable(resource)
        bitmap = (drawable as BitmapDrawable).bitmap
        return bitmap!!
    }
}
