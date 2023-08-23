package com.example.themeal.retrofit

import com.example.themeal.response.CategorieListResponse
import retrofit2.http.GET

interface MealService {
    @GET("categories.php")
    suspend fun getCategories() : CategorieListResponse
}