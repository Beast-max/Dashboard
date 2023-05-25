package com.example.listedassignment.Api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class TopLink(
    @SerializedName("app")
    @Expose
    val app: String,
    @SerializedName("created_at")
    @Expose
    val createdAt: String,
    @SerializedName("domain_id")
    @Expose
    val domainId: String,
    @SerializedName("original_image")
    @Expose
    val originalImage: String,
    @SerializedName("smart_link")
    @Expose
    val smartLink: String,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: Any,
    @SerializedName("times_ago")
    @Expose
    val timesAgo: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("total_clicks")
    @Expose
    val totalClicks: Int,
    @SerializedName("url_id")
    @Expose
    val urlId: Int,
    @SerializedName("url_prefix")
    @Expose
    val urlPrefix: String,
    @SerializedName("url_suffix")
    @Expose
    val urlSuffix: String,
    @SerializedName("web_link")
    @Expose
    val webLink: String
)