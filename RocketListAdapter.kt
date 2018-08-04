package com.example.seep.spacexapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RocketListAdapter(val userList: ArrayList<Rocket>): RecyclerView.Adapter<RocketListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName?.text = userList[position].name
        holder.txtTitle?.text = userList[position].engineCount
        holder.txtCountry?.text = userList[position].country

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rocket_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(R.id.rocket_name)
        val txtTitle = itemView.findViewById<TextView>(R.id.engine_count)
        val txtCountry = itemView.findViewById<TextView>(R.id.county)

    }

}