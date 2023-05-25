package com.example.listedassignment.Utiles

import android.content.Context
import android.content.SharedPreferences


object SessionManager {
    const val USER_TOKEN = "user_token"
    const val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"

    fun saveString(context: Context, key: String, value: String) {
        val prefs: SharedPreferences =
            context.getSharedPreferences("New", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.apply()

    }
    fun getString(context: Context, key: String): String? {
        val prefs: SharedPreferences =
            context.getSharedPreferences("New", Context.MODE_PRIVATE)
        return prefs.getString(key, "null")
    }
    fun saveJWTToken(context: Context, token: String) {
        saveString(context, USER_TOKEN, token)
    }
    fun getToken(context: Context): String? {
        return getString(context, USER_TOKEN)
    }

}