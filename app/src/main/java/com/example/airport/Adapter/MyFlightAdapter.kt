package com.example.airport.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.airport.model.Flight
import com.example.airport.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class MyFlightAdapter(private val context: Context, private val movieList: MutableList<Flight>):RecyclerView.Adapter<MyFlightAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val fromList: TextView = itemView.fromList
        val toList: TextView = itemView.toList
        val fromTime: TextView = itemView.fromTime
        val image: ImageView = itemView.terminal
        val number: TextView = itemView.number
        val airport: TextView = itemView.airport
        val company: TextView = itemView.company
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]

        //заполняем item
        Picasso.get().load(movieList[position].logo).into(holder.image)
        holder.fromList.text = movieList[position].from
        holder.toList.text = movieList[position].to
        holder.fromTime.text = movieList[position].fromTime
        holder.number.text = movieList[position].numOfFlight
        holder.airport.text = movieList[position].airport
        holder.company.text = movieList[position].company
    }
}

