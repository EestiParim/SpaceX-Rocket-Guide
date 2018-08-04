package com.example.seep.spacexapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.recycle_view)
        rv.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL, false);
        val rockets = ArrayList<Rocket>()
        rockets.add(Rocket("Suur Rakett","Musk"))
        rockets.add(Rocket("Väike Rakett","USSR"))

        var adapter = RocketListAdapter(rockets)
        rv.adapter = adapter
    }
}
