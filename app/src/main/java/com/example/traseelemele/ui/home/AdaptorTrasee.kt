package com.example.traseelemele.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.traseelemele.data.Traseu

class AdaptorTrasee(var trasee : List<Traseu>) : RecyclerView.Adapter<AdaptorTrasee.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var tvDenumire : TextView
        init{
            tvDenumire = view.findViewById(android.R.id.text1);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return trasee.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val traseu = trasee[position]

        holder.tvDenumire.text = traseu.denumire
    }
}