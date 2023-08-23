package com.example.themeal.repository

import androidx.lifecycle.viewModelScope
import com.example.themeal.db.CategorieDao
import com.example.themeal.model.Categoria
import com.example.themeal.response.ApiResponse
import com.example.themeal.response.CategorieListResponse
import com.example.themeal.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategorieRepository ( val categorieDao: CategorieDao?=null){

    suspend fun getCategories(): ApiResponse<CategorieListResponse> {
        return try {
            val response = RetrofitInstance.getMealService().getCategories()
            ApiResponse.Success(response)
        }catch (e:Exception){
            ApiResponse.Error(e)
        }
    }

    suspend fun addFavorite(categoria: Categoria){
        categorieDao?.let{
            it.addFavorite(categoria)

        }
    }
    suspend fun getFavorites(): List<Categoria>{
        return withContext(Dispatchers.IO){
            categorieDao?.getFavorites()?: emptyList()
        }
    }
}