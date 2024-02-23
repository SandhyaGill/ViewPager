package com.sandhyagill.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewPageRecycler(var layout: ArrayList<Int>) : RecyclerView.Adapter<ViewPageRecycler.ViewHolder>() {

    class ViewHolder(var view: View): RecyclerView.ViewHolder(view){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageRecycler.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
        return layout[position]
    }

    override fun onBindViewHolder(holder: ViewPageRecycler.ViewHolder, position: Int) {

    }

    override fun getItemCount() = layout.size


}