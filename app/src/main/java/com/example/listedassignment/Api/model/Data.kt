package com.example.listedassignment.Api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Data(
    @SerializedName("overall_url_chart")
    @Expose
    val overallUrlChart:Map<String,Int>,
    @SerializedName("recent_links")
    @Expose
    val recentLinks: List<TopLink>,
    @SerializedName("top_links")
    @Expose
    val topLinks: List<TopLink>
)