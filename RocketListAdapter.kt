package com.example.seep.spacexapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RocketListAdapter(val rocketList: List<RocketDataEntry>?): RecyclerView.Adapter<RocketListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rocketDataEntry = rocketList?.get(position)
        holder.txtName?.text = rocketDataEntry?.name
        holder.txtTitle?.text = rocketDataEntry?.boosters.toString()
        holder.txtCountry?.text = rocketDataEntry?.country

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rocket_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return rocketList!!.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(R.id.rocket_name)
        val txtTitle = itemView.findViewById<TextView>(R.id.engine_count)
        val txtCountry = itemView.findViewById<TextView>(R.id.county)

    }

}