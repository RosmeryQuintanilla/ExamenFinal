package com.example.themeal.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        //https://www.themealdb.com/api/json/v1/1/categories.php
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getMealService() : MealService = retrofit.create(MealService::class.java)
}