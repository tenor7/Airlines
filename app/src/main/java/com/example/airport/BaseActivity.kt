package com.example.airport

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_base.*
import android.widget.CalendarView

import android.widget.CalendarView.OnDateChangeListener

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val to: Spinner = findViewById(R.id.to)
        val from: Spinner = findViewById(R.id.from)

        var date: String = ""
        var codeFromSpinner: String = ""
        var codeToSpinner: String = ""

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val year = year.toString()
            //+1, потому что calendarView возвращает месяцы с нулевого
            val month = month+1
            val month1 = month.toString()
            val dayOfMonth = dayOfMonth.toString()
            date = year +  "-" + month1 + "-" + dayOfMonth
        }

        search.setOnClickListener{
            val selectedToSpinner = to.selectedItem.toString()
            val selectedFromSpinner = from.selectedItem.toString()

            when (selectedFromSpinner) {
                "Москва" -> codeFromSpinner = "c213"
                "Алматы" -> codeFromSpinner = "c22177"
                "Анталья" -> codeFromSpinner = "c11511"
                "Баку" -> codeFromSpinner = "c10253"
                "Дубай" -> codeFromSpinner = "c11499"
                "Лондон" -> codeFromSpinner = "c10393"
                "Ереван" -> codeFromSpinner = "c10262"
                "Нур-Султан" -> codeFromSpinner = "c163"
                "Белград" -> codeFromSpinner = "c10522"
                "Пекин" -> codeFromSpinner = "c10590"
                "Стамбул" -> codeFromSpinner = "c11508"
                else -> {
                }
            }

            //конвертируем в коды городов
            when (selectedToSpinner) {
                "Москва" -> codeFromSpinner = "c213"
                "Алматы" -> codeToSpinner = "c22177"
                "Анталья" -> codeToSpinner = "c11511"
                "Баку" -> codeToSpinner = "c10253"
                "Дубай" -> codeToSpinner = "c11499"
                "Лондон" -> codeToSpinner = "c10393"
                "Ереван" -> codeToSpinner = "c10262"
                "Нур-Султан" -> codeToSpinner = "c163"
                "Белград" -> codeToSpinner = "c10522"
                "Пекин" -> codeToSpinner = "c10590"
                "Стамбул" -> codeToSpinner = "c11508"
                else -> {
                }
            }

            val API_KEY = BuildConfig.APIKEY;

            val url = "&format=json&from=$codeFromSpinner&to=$codeToSpinner&date=$date&transport_types=plane"

            val intent = Intent(this, Timetable::class.java)
            intent.putExtra("api", API_KEY);
            intent.putExtra("format", "json")
            intent.putExtra("from", codeFromSpinner)
            intent.putExtra("to", codeToSpinner)
            intent.putExtra("date", date)
            intent.putExtra("transport_type", "plane")
            //Toast.makeText(this, url, Toast.LENGTH_SHORT).show()
            startActivity(intent);
        }
    }
}