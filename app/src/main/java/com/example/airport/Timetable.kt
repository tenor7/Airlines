package com.example.airport

import android.app.AlertDialog
import android.os.Bundle
import dmax.dialog.SpotsDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.airport.Adapter.MyFlightAdapter
import com.example.airport.Common.Common
import com.example.airport.Interface.RetrofitServices
import com.example.airport.model.Flights
import com.example.airport.model.fromFlightsToListOfFlight
import kotlinx.android.synthetic.main.timetable.*

class Timetable : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyFlightAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetable)
        mService = Common.retrofitService
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        recyclerMovieList.setHasFixedSize(true)
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        getAllFlightList()
    }

    private fun getAllFlightList() {
        dialog.show()
        val apikey = intent.extras!!.getString("api") as String                      //получаем url из BaseActivity
        val format = intent.extras!!.getString("format") as String                   //получаем url из BaseActivity
        val from = intent.extras!!.getString("from") as String                       //получаем url из BaseActivity
        val to = intent.extras!!.getString("to") as String                           //получаем url из BaseActivity
        val date = intent.extras!!.getString("date") as String                       //получаем url из BaseActivity
        val transport = intent.extras!!.getString("transport_type") as String        //получаем url из BaseActivity

        mService.getMovieList("v3.0/search/",apikey,format,from,to,date,transport).enqueue(object : retrofit2.Callback<Flights> {
            override fun onFailure(call: retrofit2.Call<Flights>, t: Throwable) {
            }
            override fun onResponse(call: retrofit2.Call<Flights>, response: retrofit2.Response<Flights>) {
                val flights = response.body()!!.fromFlightsToListOfFlight()
                adapter = MyFlightAdapter(baseContext,flights)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter
                dialog.dismiss()
            }
        })
    }
}
