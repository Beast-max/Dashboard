package com.example.listedassignment.Utiles

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.listedassignment.Api.model.MapDataModel
import com.patrykandpatrick.vico.core.entry.FloatEntry
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale

object UtilesFunction {
    var floatingList = mutableListOf<FloatEntry>()
   var i = 0
    fun convertList(map: Map<String, Int>?):MutableList<MapDataModel>{
        val list = mutableListOf<MapDataModel>()
        map?.toList()
        map?.forEach{
                (key,value)->
            list.add(MapDataModel(getDateRange(key),value.toFloat()))
            floatingList.add(FloatEntry( getIntMonth(key),value.toFloat()))
        }
        Log.d("map_list_mod",list.toString())
        return list
    }
    fun getDateRange(dateString:String):String{

        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val outputFormatter = DateTimeFormatter.ofPattern("dd  MMM", Locale.ENGLISH)

        try {
            val date = LocalDate.parse(dateString, inputFormatter)
            val formattedDate = date.format(outputFormatter)
            return formattedDate
        } catch (e: DateTimeParseException) {
            println("Invalid date format")
        }
        return ""
    }
    fun getIntMonth(dateString: String):Float {

        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(dateString, dateFormatter)

        val month = date.dayOfMonth
        Log.d("date", date.dayOfMonth.toString())
        return month.toFloat() // Output: 4 (April is represented by the value 4 in monthValue)
    }
    fun ImageView.loadimage(uri:String) {
        Glide.with(this).load(uri).into(this)
    }
}