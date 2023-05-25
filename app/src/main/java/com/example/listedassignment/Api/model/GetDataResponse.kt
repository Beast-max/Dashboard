package com.example.listedassignment.Api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class GetDataResponse(
    @SerializedName("applied_campaign")
    @Expose
    val appliedCampaign: Int,
    @SerializedName("data")
    @Expose
    val `data`: Data,
    @SerializedName("extra_income")
    @Expose
    val extraIncome: Double,
    @SerializedName("links_created_today")
    @Expose
    val linksCreatedToday: Int,
    @SerializedName("message")
    @Expose
    val message: String,
    @SerializedName("startTime")
    @Expose
    val startTime: String,
    @SerializedName("status")
    @Expose
    val status: Boolean,
    @SerializedName("statusCode")
    @Expose
    val statusCode: Int,
    @SerializedName("support_whatsapp_number")
    @Expose
    val supportWhatsappNumber: String,
    @SerializedName("today_clicks")
    @Expose
    val todayClicks: Int,
    @SerializedName("top_location")
    @Expose
    val topLocation: String,
    @SerializedName("top_source")
    @Expose
    val topSource: String,
    @SerializedName("total_clicks")
    @Expose
    val totalClicks: Int,
    @SerializedName("total_links")
    @Expose
    val totalLinks: Int
)