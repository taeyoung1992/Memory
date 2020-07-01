package com.gmail.moontae0317.memory.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gmail.moontae0317.memory.R
import com.gmail.moontae0317.memory.data.db.Memory
import com.gmail.moontae0317.memory.utils.ConvertUtils
import kotlinx.android.synthetic.main.memory_form.view.*

class RecyclerAdapter (private val memories : ArrayList<Memory>):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.memory_form,parent,false)
        return ViewHolder(inflatedView)

    }

    override fun getItemCount(): Int {
        return memories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val memory = memories[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context,"Clicked : ${memory.id}",Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener,memory)
        }
    }

    class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        private var view = v
        fun bind(listener: View.OnClickListener,memory:Memory){
            view.img_myPhoto.setImageBitmap(ConvertUtils().byteArrayToBitmap(memory.picture!!))
            view.text_myText.text = memory.location
            view.setOnClickListener(listener)
        }
    }

}