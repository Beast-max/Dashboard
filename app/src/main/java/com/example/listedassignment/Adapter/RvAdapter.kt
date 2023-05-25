package com.example.listedassignment.Adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listedassignment.Api.model.TopLink
import com.example.listedassignment.Utiles.UtilesFunction.loadimage
import com.example.listedassignment.databinding.ItemRecentBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

class RvAdapter(val listner:OnCopy): ListAdapter<TopLink, RvAdapter.ViewHolder>(object : DiffUtil.ItemCallback<TopLink>(){
    override fun areItemsTheSame(oldItem: TopLink, newItem: TopLink): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: TopLink, newItem: TopLink): Boolean {
        return oldItem==newItem
    }

}) {
    inner class ViewHolder( val binding: ItemRecentBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRecentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.linkname.text = item.app
        holder.binding.date.text = formatDate(item.createdAt)
        holder.binding.linkImage.loadimage(item.originalImage)
        holder.binding.clickCount.text = item.totalClicks.toString()
        holder.binding.linkUrl.text = item.webLink
        holder.binding.imageView9.setOnClickListener {
            listner.onCopy(holder.binding.linkUrl.text.toString())
        }
    }



    fun formatDate(dateString:String) :String{
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val outputFormat = SimpleDateFormat("dd MMM yyyy")
            try {
                val date: Date = inputFormat.parse(dateString)
                val formattedDate: String = outputFormat.format(date)
                return formattedDate
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return "" }
    fun copyToClipboard(context: Context, text: String) {

    }
    interface OnCopy{
        fun onCopy(text: String)
    }

}