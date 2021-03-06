package com.example.seep.spacexapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.os.StrictMode
import android.widget.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val emptyRocketList : List<RocketDataEntry> = emptyList()
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*var gson = Gson()
        var mMineUserEntity = gson.fromJson(response, RocketDataEntry.RocketData::class.java)*/

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val spaceXApi = retrofit.create(SpaceXApi::class.java)
        var asi = spaceXApi.getTop().execute().body()

        /*var filteredAsi : List<RocketDataEntry> = asi?.filter{it.active}*/
        Log.d("WOW", asi.toString())
        val rv = findViewById<RecyclerView>(R.id.recycle_view)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
/*        val rockets = ArrayList<Rocket>()
        rockets.add(Rocket("SpaceX First","22 Engines", "Russia"))
        rockets.add(Rocket("Big Large Falcon","5 Engines", "Ireland Republic"))*/
        var adapter = RocketListAdapter(asi)
        rv.adapter = adapter
        adapter.notifyDataSetChanged()

        val toggleBtnActive = findViewById<ToggleButton>(R.id.toggle_active)
        toggleBtnActive?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                val filteredAsiInActive = asi?.filter {it.active }
                rv.swapAdapter(RocketListAdapter(filteredAsiInActive), false)
            }
            else{
                rv.swapAdapter(adapter,false)
            }
            /*val msg = "Toggle Button is " + if (isChecked) "ON" else "OFF"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()*/
        }
    }

}